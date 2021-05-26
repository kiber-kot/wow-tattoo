package art.tattoo.wowtattoo.dao;

import art.tattoo.wowtattoo.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
