package abc.com.vn.commerce.service;

import abc.com.vn.commerce.model.Customer;
import abc.com.vn.commerce.repository.CustomerRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService{
    @Autowired
    CustomerRepository repo;

    public void saveCustomer(Customer customer) {
        try{
            repo.save(customer);

        }
        catch (HibernateException e){
            if(e.toString().contains("email_uniq"))
                System.out.println("Email đã sử dụng");
        }
    }
    public List<Customer> listAllCustomer() {
        return repo.findAll();

    }
    public Customer getCustomerById(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    public Optional<Customer> emailCheck(String email) {return repo.findCustomerByEmail(email);};

}
