package art.tattoo.wowtattoo.dao;

import art.tattoo.wowtattoo.entity.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<PortfolioEntity, Long> {
    List<PortfolioEntity> findAllByMasterId(long id);
}
