package abc.com.vn.commerce.controller.admin_site;

import abc.com.vn.commerce.model.Customer;
import abc.com.vn.commerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerManager {
    @Autowired
    CustomerService customerDAO;

    @GetMapping(value = "admin/customer")
    public String customer(Model model){
        List<Customer> customerList=customerDAO.listAllCustomer();
        model.addAttribute("listCustomer",customerList);
        return "admin/customers";
    }
}
