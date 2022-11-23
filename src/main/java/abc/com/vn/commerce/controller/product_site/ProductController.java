package abc.com.vn.commerce.controller.product_site;

import abc.com.vn.commerce.model.Product;
import abc.com.vn.commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

  @Autowired
  ProductService productService;

  @GetMapping("/product/{id}")
  public String getAllById(Model model, @PathVariable("id") Integer id) {
    Product product = productService.getProductById(id);
    if (product == null) {
      return "customer/home";
    }
    model.addAttribute("product", product);
    return "temp/product";
  }
}
