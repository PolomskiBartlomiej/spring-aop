package demo.spring.aop.login;

import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {

    @Autowired
    private LoginService classUnderTest;

    @Test
    public void decipherUserTest() {
        var user = classUnderTest.login("John");
        assertThat(user.getName(), is("decipherJohn"));
    }

    @Test
    public void encryptUser() {
        var user = classUnderTest.getLoggedUser(1);
        assertThat(user.getName(), is("encryptJohn"));
    }
}