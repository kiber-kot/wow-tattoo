package art.tattoo.wowtattoo.dao;

import art.tattoo.wowtattoo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
