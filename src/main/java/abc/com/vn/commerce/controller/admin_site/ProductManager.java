package abc.com.vn.commerce.controller.admin_site;

import abc.com.vn.commerce.form.req.CustomerReq;
import abc.com.vn.commerce.form.req.ProductReq;
import abc.com.vn.commerce.model.Customer;
import abc.com.vn.commerce.model.Product;
import abc.com.vn.commerce.service.CatalogService;
import abc.com.vn.commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping(value = "/admin/products")
public class ProductManager {
    @Autowired
    ProductService productService;
    @Autowired
    CatalogService catalogService;
    @GetMapping(value ="" )
    public String productManager(Model model){
        model.addAttribute("listProduct",productService.getAllProduct());
        ProductReq productAdd=new ProductReq();
        model.addAttribute("productAdd",productAdd);
        ProductReq productUpdate=new ProductReq();
        model.addAttribute("productUpdate",productUpdate);
        return "admin/products";
    }
    @PostMapping(value = "addProduct")
    public String addCustomer(Model model, //
                              @ModelAttribute("productAdd") ProductReq productAdd){
        String name=productAdd.getProductName();
        double price=productAdd.getProductPrice();
        String image=productAdd.getProductImage();
        String catalogName=productAdd.getCatalogName();
        if(catalogName.length()>0 && name.length()>0 && image.length()>0){
            Product product=new Product();
            product.setCatalog(catalogService.getCatalogByName(catalogName));
            product.setProductName(name);
            product.setProductPrice(price);
            product.setProductImage(image);
            try{
                productService.saveProduct(product);

            }
            catch(Exception e) {
                model.addAttribute("errorMessage",e.getMessage());
                System.out.println(e.getMessage());

            }
        }

        return "redirect:/admin/products/";


    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.deleteProduct(id);
        return "redirect:/admin/products/";
    }
}
