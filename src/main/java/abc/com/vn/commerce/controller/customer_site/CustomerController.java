package abc.com.vn.commerce.controller.customer_site;

import abc.com.vn.commerce.model.Customer;
import abc.com.vn.commerce.service.CustomerService;
import abc.com.vn.commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    @Value("${error.message}")
    private String errorMessage;

    @Autowired
    ProductService productService;



    @GetMapping(value = {"/","/home"})
    public String home(Model model){
        model.addAttribute("listProduct",productService.getAllProduct());
        return "customer/home";
    }

}
