package abc.com.vn.commerce.controller;

import abc.com.vn.commerce.model.Customer;
import abc.com.vn.commerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerDAO;

    @GetMapping(value = "/save")
    public String saveCustomer(){
        Customer customer=new Customer();
        customer.setEmail("vcatanh@gmail.com");

        customerDAO.saveCustomer(customer);
        return "index";
    }
}
