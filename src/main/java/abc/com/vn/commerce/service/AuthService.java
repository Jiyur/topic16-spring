package abc.com.vn.commerce.service;

import abc.com.vn.commerce.model.AuthModel;
import abc.com.vn.commerce.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public AuthModel login(String username, String password) {
        return authRepository.findByUsernameAndPassword(username, password);
    }

    public AuthModel createAuth(AuthModel authModel) {
        return authRepository.save(authModel);
    }
}
