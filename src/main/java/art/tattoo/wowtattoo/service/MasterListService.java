package art.tattoo.wowtattoo.service;

import art.tattoo.wowtattoo.dao.MasterListRepository;
import art.tattoo.wowtattoo.dto.MasterListDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.mapping.MasterListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
@Transactional
public class MasterListService {

    @Autowired
    private MasterListMapper masterListMapper;

    @Autowired
    private EntityManager entityManager;

    public List<MasterListDto> getDefaultMasterList(List<String> city,
                                             List<Integer> experience,
                                             List<Integer> price){
        String baseSql = "SELECT * FROM master WHERE";
        if(city != null){
            for(String value: city){
                if(baseSql.substring(21).equals("WHERE")){
                    baseSql = baseSql + " city = "  + "'" + value + "'";
                }else {
                    baseSql = baseSql + " AND city = " + "'" + value + "'";
                }
            }
        }
        if(experience != null){
            for(Integer value : experience){
                if(baseSql.substring(20).equals("WHERE")){
                    baseSql = baseSql + " experience = " + "'" + value + "'";
                }else {
                    baseSql = baseSql + " AND experience = " + "'" + value + "'";
                }
            }
        }
        if(price != null){
            for(Integer value : price){
                if(baseSql.substring(20).equals("WHERE")){
                    baseSql = baseSql + " price = " + "'" + value + "'";
                }else {
                    baseSql = baseSql + " AND price = " + "'" + value + "'";
                }
            }
        }

        String filterSql = " ORDER BY id ASC limit 10";

        Query query = entityManager.createNativeQuery(baseSql + filterSql);
        List<MasterEntity> masterEntity = query.getResultList();

        masterListMapper.toTdoList(masterEntity);

        return masterListMapper.toTdoList(masterEntity);
    }

    public List<MasterListDto> getLimitByIdMasterList(
                                                    long id,
                                                    List<String> city,
                                                    List<Integer> experience,
                                                    List<Integer> price){
        String baseSql = "SELECT * FROM master WHERE";
        if(city != null){
            for(String value: city){
                if(baseSql.substring(21).equals("WHERE")){
                    baseSql = baseSql + " city = "  + "'" + value + "'";
                }else {
                    baseSql = baseSql + " AND city = " + "'" + value + "'";
                }
            }
        }
        if(experience != null){
            for(Integer value : experience){
                if(baseSql.substring(20).equals("WHERE")){
                    baseSql = baseSql + " experience = " + "'" + value + "'";
                }else {
                    baseSql = baseSql + " AND experience = " + "'" + value + "'";
                }
            }
        }
        if(price != null){
            for(Integer value : price){
                if(baseSql.substring(20).equals("WHERE")){
                    baseSql = baseSql + " price = " + "'" + value + "'";
                }else {
                    baseSql = baseSql + " AND price = " + "'" + value + "'";
                }
            }
        }

        String filterSql = " AND id > " + id + " ORDER BY id ASC limit 10 ";

        Query query = entityManager.createNativeQuery(baseSql + filterSql);
        List<MasterEntity> masterEntity = query.getResultList();

        masterListMapper.toTdoList(masterEntity);

        return masterListMapper.toTdoList(masterEntity);
    }
}
