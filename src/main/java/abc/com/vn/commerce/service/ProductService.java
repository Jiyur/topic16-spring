package abc.com.vn.commerce.service;

import abc.com.vn.commerce.model.Product;
import abc.com.vn.commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ProductService {
    @Autowired
    ProductRepository repo;
    public List<Product> getAllProduct(){
        return repo.findAll();
    }
    public Product getProductById(int id){
        return repo.findById(id).orElse(null);
    }
    public Product saveProduct(Product product){
        return repo.save(product);
    }
    public void deleteProduct(int id){
        repo.deleteById(id);
    }
}
