package abc.com.vn.commerce.repository;

import abc.com.vn.commerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    @Query("select c from customer c where c.email=?1")
    Optional<Customer> findCustomerByEmail(String email);

    @Modifying
    @Query("UPDATE customer c SET c.fullName=?1,c.gender=?2,c.address_line=?3,c.phone=?4 where c.email=?5")
    void updateCustomer(String fullName,String gender,String address_line,String phone,String email);
}
