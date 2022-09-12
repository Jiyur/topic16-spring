package abc.com.vn.commerce.service;

import abc.com.vn.commerce.form.req.SignUpRequest;
import abc.com.vn.commerce.model.Customer;
import abc.com.vn.commerce.repository.CustomerRepository;
import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CustomerService{
    @Autowired
    CustomerRepository repo;

    public void saveCustomer(Customer customer) {
        repo.save(customer);
    }
    public List<Customer> listAllCustomer() {
        return repo.findAll();

    }
    public Customer getCustomerById(UUID id) {
        return repo.findById(id).get();
    }

    public void delete(UUID id) {
        repo.deleteById(id);

    }
    public Optional<Customer> emailCheck(String email) {return repo.findCustomerByEmail(email);};
    public void update(Customer customer){
        repo.updateCustomer(
                customer.getFullName(),
                customer.getGender(),
                customer.getAddress_line(),
                customer.getPhone(),
                customer.getEmail());
    }



}
