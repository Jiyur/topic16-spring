package abc.com.vn.commerce.repository;

import abc.com.vn.commerce.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, Integer> {
    Catalog findByCatalogName(String name);
}
