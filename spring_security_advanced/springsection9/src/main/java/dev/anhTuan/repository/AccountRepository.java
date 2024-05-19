package dev.anhTuan.repository;

import dev.anhTuan.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Accounts,Long> {
    Accounts findByCustomerId(int customerId);
}
