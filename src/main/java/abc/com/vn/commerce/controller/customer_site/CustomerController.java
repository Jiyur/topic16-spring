package abc.com.vn.commerce.controller.customer_site;

import abc.com.vn.commerce.model.Customer;
import abc.com.vn.commerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Value("${error.message}")
    private String errorMessage;

    @Autowired
    CustomerService customerDAO;


    @GetMapping(value = "/save")
    public String saveCustomer(Model model){
        Customer customer=new Customer();
        customer.setEmail("vcatanh@gmail.com");
//        customer.setEmail("vcatanh@gmail.com");
//        customer.setFullName("Trần quang khánh");
//        customer.setGender("Male");
//        customer.setPhone("012345678");
//        customer.setAddress_line("Thủ Đức");
        try{
            customerDAO.saveCustomer(customer);

        }
        catch (Exception e){
            if (e.toString().contains("email_unique")){
                model.addAttribute("errorMessage","Email taken");
            }
            else{
                model.addAttribute("errorMessage","Error !");
            }
        }
        return "customer/home";
    }
    @GetMapping(value = {"/","/home"})
    public String home(){
        return "customer/home";
    }
}
