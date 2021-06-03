package art.tattoo.wowtattoo.dao;

import art.tattoo.wowtattoo.entity.MasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MasterListRepository extends JpaRepository<MasterEntity, Long> {

    @Query(value = "select * from master order by id asc limit 10",nativeQuery = true)
    List<MasterEntity> findAll10();

    @Query(value = "select * from master where id > ? order by id asc limit 10 ",nativeQuery = true)
    List<MasterEntity> findAllByIdBetweenOrderByIdAsc(Long id);
}
