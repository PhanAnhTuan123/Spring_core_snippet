package security.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.api.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
