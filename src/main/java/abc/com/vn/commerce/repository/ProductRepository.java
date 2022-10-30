package abc.com.vn.commerce.repository;

import abc.com.vn.commerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
