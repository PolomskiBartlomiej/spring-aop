package demo.spring.aop.login;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService service;

    @GetMapping("/login/{user}")
    void login(@PathVariable(value = "user") String encryptUser) {
        service.login(encryptUser);
    }

    @GetMapping("/login/{id}")
    User login(@PathVariable(value = "id") long userId) {
       return service.getLoggedUser(userId);
    }
}
