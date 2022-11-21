package abc.com.vn.commerce.repository;

import abc.com.vn.commerce.model.AuthModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<AuthModel, Integer> {
    AuthModel findByUsernameAndPassword(String username, String password);
    AuthModel findByUsername(String username);
}
