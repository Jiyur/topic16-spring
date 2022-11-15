package abc.com.vn.commerce.controller.auth_site;

import abc.com.vn.commerce.form.req.LoginReq;
import abc.com.vn.commerce.form.req.RegisterReq;
import abc.com.vn.commerce.model.AuthModel;
import abc.com.vn.commerce.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping(value = {"/redirect-login"})
    public String redirectLogin(Model model){
        LoginReq loginReq = new LoginReq();
        RegisterReq registerReq = new RegisterReq();
        model.addAttribute("loginReq",loginReq);
        model.addAttribute("registerReq",registerReq);
        return "auth/auth";
    }

    @PostMapping("/login")
    public String login(Model model, @ModelAttribute("loginReq")LoginReq loginReq) {
        String username = loginReq.getUsername();
        String password = loginReq.getPassword();
        AuthModel authModel = authService.login(username, password);

        if (authModel == null) {
            model.addAttribute("errorMessage", "Login failed");
            return  "redirect:/home";
        } else if (authModel.getRole().equals("Admin")) {
            return "redirect:/admin/customer/";
        } else {
            return "redirect:/home";
        }
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute("registerReq")RegisterReq registerReq) {
        AuthModel authModel = new AuthModel();
        authModel.setRole("User");
        authModel.setUsername(registerReq.getUsername());
        authModel.setPassword(registerReq.getPassword());

        authService.createAuth(authModel);
        return "redirect:/home";
    }


}
