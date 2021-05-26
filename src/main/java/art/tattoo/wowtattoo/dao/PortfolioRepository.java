package art.tattoo.wowtattoo.dao;

import art.tattoo.wowtattoo.entity.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<PortfolioEntity, Long> {
}
