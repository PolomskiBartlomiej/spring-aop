package demo.spring.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

interface UserEncryptionPointcut {

    @Pointcut("@annotation(demo.spring.aop.aspect.bind.EncryptUser)")
    default void encryptUserPointcut(){}

    @Pointcut("@annotation(demo.spring.aop.aspect.bind.DecipherUser) && args (user)")
    default void decipherUserPointcut(String user){}
}
