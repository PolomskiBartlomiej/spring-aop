package demo.spring.aop.login;

import demo.spring.aop.aspect.bind.DecipherUser;
import demo.spring.aop.aspect.bind.EncryptUser;
import org.springframework.stereotype.Service;

@Service
class LoginService {

    @DecipherUser
    public User login(final String userName) {
        System.out.println("user : " + userName + " logged" );
        return new User(userName);
    }

    @EncryptUser
    public User getLoggedUser(long userId) {
        return new User("John");
    }
}
