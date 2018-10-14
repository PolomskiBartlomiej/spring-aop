package demo.spring.aop.aspect;

import demo.spring.aop.login.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
class UserEncryptionAspect implements UserEncryptionPointcut {

    @Around(value = "decipherUserPointcut(user)", argNames = "method,user")
    Object decipherUser(final ProceedingJoinPoint method, final String user) throws Throwable {
        System.out.println("Start decipher  " + user);

        final String decipherUser = "decipher"  + user;

        return method.proceed(new Object[] {decipherUser});
    }

    @Around(value = "encryptUserPointcut()")
    Object encryptUser(final ProceedingJoinPoint method) throws Throwable {
        User user = (User) method.proceed();

        System.out.println("Start encrypt  " + user.getName());

        return new User("encrypt"  + user.getName());
    }
}
