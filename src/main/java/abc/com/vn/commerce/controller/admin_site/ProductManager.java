package abc.com.vn.commerce.controller.admin_site;

import abc.com.vn.commerce.form.req.CustomerReq;
import abc.com.vn.commerce.form.req.ProductReq;
import abc.com.vn.commerce.model.Customer;
import abc.com.vn.commerce.model.Product;
import abc.com.vn.commerce.service.AmazonService;
import abc.com.vn.commerce.service.CatalogService;
import abc.com.vn.commerce.service.ProductService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Controller
@RequestMapping(value = "/admin/products")
public class ProductManager {
    @Autowired
    ProductService productService;
    @Autowired
    CatalogService catalogService;
    @Autowired
    AmazonService amazonService;

    @GetMapping(value ="" )
    public String productManager(Model model){
        model.addAttribute("listProduct",productService.getAllProduct());
        ProductReq productAdd=new ProductReq();
        model.addAttribute("productAdd",productAdd);
        ProductReq productUpdate=new ProductReq();
        model.addAttribute("productUpdate",productUpdate);
        return "admin/products";
    }
    @SneakyThrows
    @PostMapping(value = "addProduct")
    public String addCustomer(Model model, //
                              @ModelAttribute("productAdd") ProductReq productAdd) throws Exception {

        String name=productAdd.getProductName();
        double price=productAdd.getProductPrice();
        MultipartFile image=productAdd.getProductImage();
        String ObjectName = UUID.randomUUID() + "_" + image.getOriginalFilename();
        String catalogName=productAdd.getCatalogName();
        String url = amazonService.uploadFile(ObjectName, image.getBytes(), image.getContentType());
        Product product=new Product();
        product.setCatalog(productAdd.getCatalogName());
        product.setProductName(name);
        product.setProductPrice(price);
        product.setProductImage(url);
        productService.saveProduct(product);

        return "redirect:/admin/products";


    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.deleteProduct(id);
        return "redirect:/admin/products";
    }
}
