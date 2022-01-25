package abc.com.vn.commerce.controller.admin_site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin/products")
public class ProductManager {
    @GetMapping(value ="" )
    public String productManager(){
        return "admin/products";
    }
}
