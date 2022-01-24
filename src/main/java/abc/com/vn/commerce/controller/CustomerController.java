package abc.com.vn.commerce.controller;

import abc.com.vn.commerce.model.Customer;
import abc.com.vn.commerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
    @Value("${error.message}")
    private String errorMessage;

    @Autowired
    CustomerService customerDAO;

//    @GetMapping(value = "/save")
//    public String saveCustomer(Model model){
//        Customer customer=new Customer();
//        customer.setEmail("vcatanh@gmail.com");
//        try{
//            customerDAO.saveCustomer(customer);
//
//        }
//        catch (Exception e){
//            if (e.toString().contains("email_unique")){
//                model.addAttribute("errorMessage","Email taken");
//            }
//            else{
//                model.addAttribute("errorMessage","Error !");
//            }
//        }
//        return "index";
//    }
    @RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
    public String home(){
        return "index";
    }
}
