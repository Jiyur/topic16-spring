package abc.com.vn.commerce.repository;

import abc.com.vn.commerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    @Query("select c from customer c where c.email=?1")
    Optional<Customer> findCustomerByEmail(String email);
}
