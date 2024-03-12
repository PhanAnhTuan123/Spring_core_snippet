package security.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.api.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
