package art.tattoo.wowtattoo.dao;

import art.tattoo.wowtattoo.entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<RatingEntity, Long> {
}
