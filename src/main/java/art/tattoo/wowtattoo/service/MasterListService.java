package art.tattoo.wowtattoo.service;

import art.tattoo.wowtattoo.dto.MasterListDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.mapping.MasterListMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

        baseSql = generatorFilterSql(baseSql, city, "city");
        baseSql = generatorFilterSql(baseSql, experience,"experience");
        baseSql = generatorFilterSql(baseSql, price, "price");

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

        baseSql = generatorFilterSql(baseSql, city, "city");
        baseSql = generatorFilterSql(baseSql, experience,"experience");
        baseSql = generatorFilterSql(baseSql, price, "price");

        String filterSql = " AND id > " + id + " ORDER BY id ASC limit 10 ";

        Query query = entityManager.createNativeQuery(baseSql + filterSql);
        List<MasterEntity> masterEntity = query.getResultList();

        masterListMapper.toTdoList(masterEntity);

        return masterListMapper.toTdoList(masterEntity);
    }

    private String generatorFilterSql(String sql, List<?> list, String columnType){
        if(list != null) {
            if (!columnType.equals("style")) {
                for (Object value : list) {
                    if (sql.substring(21).equals("WHERE")) {
                        sql = sql + " " + columnType + " = " + "'" + value + "'";
                    } else {
                        sql = sql + " AND " + columnType + " = " + "'" + value + "'";
                    }
                }
                return sql;
            } else {
                StringBuilder mainSQL = new StringBuilder(sql);
                mainSQL.insert(20, "RIGHT JOIN syle ON master.id = style.master_id");
                for(Object value : list) {
                    if (sql.substring(21).equals("WHERE")) {
                        String sqlJoinStyle = "RIGHT JOIN syle ON master.id = style.master_id";
                        sql = sql + " " + columnType + " = " + "'" + value + "'";
                    } else {
                        sql = sql + " AND " + columnType + " = " + "'" + value + "'";
                    }
                }
            }
        }
        return sql;
    }

    private String generatorFilterStyleSql(String sql, List<?> list){
        if(list != null){
            for(Object value: list){
                if(sql.substring(21).equals("WHERE")){
                    sql = sql + " city = "  + "'" + value + "'";
                }else {
                    sql = sql + " AND city = " + "'" + value + "'";
                }
            }
            return sql;
        }
        return sql;
    }
}
