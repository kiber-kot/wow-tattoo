package art.tattoo.wowtattoo.service;

import art.tattoo.wowtattoo.dto.MasterListDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.mapping.MasterListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MasterListService {

    @Autowired
    private MasterListMapper masterListMapper;

    @Autowired
    private EntityManager entityManager;

    public List<MasterListDto> getDefaultMasterList(List<String> city,
                                                    List<Integer> experience,
                                                    List<Integer> price) {
        String baseSql = "SELECT * FROM master WHERE";

        baseSql = generatorFilterSql(baseSql, city, "city");
        baseSql = generatorFilterSql(baseSql, experience, "experience");
        baseSql = generatorFilterSql(baseSql, price, "min_price");

        String filterSql = " ORDER BY master.id ASC limit 10";

        Query query = entityManager.createNativeQuery(baseSql + filterSql, MasterEntity.class);

        List<MasterEntity> masterEntity = query.getResultList();

        return masterListMapper.toTdoList(masterEntity);
    }

    public List<MasterListDto> getLimitByIdMasterList(
            long id,
            List<String> city,
            List<Integer> experience,
            List<Integer> price) {
        String baseSql = "SELECT * FROM master WHERE";

        baseSql = generatorFilterSql(baseSql, city, "city");
        baseSql = generatorFilterSql(baseSql, experience, "experience");
        baseSql = generatorFilterSql(baseSql, price, "min_price");

        String filterSql = " AND master.id > " + id + " ORDER BY id ASC limit 10 ";

        Query query = entityManager.createNativeQuery(baseSql + filterSql, MasterEntity.class);
        List<MasterEntity> masterEntity = query.getResultList();

        masterListMapper.toTdoList(masterEntity);

        return masterListMapper.toTdoList(masterEntity);
    }

    private String generatorFilterSql(String sql, List<?> list, String columnType) {
        if (list != null) {
            if (!columnType.equals("style")) {
                if (columnType.equals("city")) {
                    for (Object value : list) {
                        int index = sql.indexOf("WHERE");
                        if (sql.substring(index).equals("WHERE")) {
                            sql = sql + " " + columnType + " in('" + value + "'";
                        } else {
                            sql = sql + " , " + value + "'";
                        }
                    }
                    return sql +") ";
                } else if(columnType.equals("min_price")){
                    for (Object value : list) {
                        int index = sql.indexOf("WHERE");
                        if (sql.substring(index).equals("WHERE")) {
                            sql = sql + " " + columnType + " in(" + value;
                        } else if(!sql.contains("min_price in(")){
                            sql = sql + " AND min_price in(" + value;
                        }
                        else {
                            sql = sql + " , " + value;
                        }
                    }
                    return sql +") ";
                } else if(columnType.equals("experience")){
                    for (Object value : list) {
                        int index = sql.indexOf("WHERE");
                        if (sql.substring(index).equals("WHERE")) {
                            sql = sql + " " + columnType + " in(" + value;
                        } else if(!sql.contains("experience in(")){
                            sql = sql + " AND experience in(" + value;
                        }
                        else {
                            sql = sql + " , " + value;
                        }
                    }
                }

            }
        }
        return sql;
    }
}

//            if (!columnType.equals("style")) {
//                if (columnType.equals("city")) {
//                    for (Object value : list) {
//                        int index = sql.indexOf("WHERE");
//                        if (sql.substring(index).equals("WHERE")) {
//                            sql = sql + " " + columnType + " = " + "'" + value + "'";
//                        } else {
//                            sql = sql + " OR " + columnType + " = " + "'" + value + "'";
//                        }
//                    }
//                    return sql;
//                }
