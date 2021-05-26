package art.tattoo.wowtattoo.dao;

import art.tattoo.wowtattoo.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
}
