package abc.com.vn.commerce.service;

import abc.com.vn.commerce.model.Catalog;
import abc.com.vn.commerce.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class CatalogService {
    @Autowired
    CatalogRepository repo;
    public List<Catalog> getAllCatalog(){
        return repo.findAll();
    }
    public Catalog getCatalogByName(String name){
        return repo.findByCatalogName(name);
    }
}
