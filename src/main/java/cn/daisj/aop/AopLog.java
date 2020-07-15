package cn.daisj.aop;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/14
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 *@ClassName AopLog
 *@Description TODO
 *@Author Administrator
 *@Date 2020/7/14 16:46
 *@Version 1.0
 **/
@Component
@Aspect
public class AopLog {
    private final Logger logger = LoggerFactory.getLogger(AopLog.class);

    ThreadLocal<Long> time = new ThreadLocal<>();

    /**
     * 切入点
     */
    @Pointcut("execution(public * *..*.controller.*..*(..))")
    public void allController() {

        System.out.println("==============================这里的代码不会执行====================");
    }

    /**
     *
     * @param point
     */
    @Before("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
//    @Before("execution(public * *..*.controller.*..*(..))")
//    @Before("allController()")//在哪个切入点
    public void logBefor(JoinPoint point) {
        time.set(System.currentTimeMillis());
        System.out.println(Thread.currentThread()+" .........");
        System.out.println(point.getSignature()+"  start......");
    }


    @After("allController()")//在哪个切入点
    public void logAfter(JoinPoint point) {
        System.out.println(point.getSignature()+"  End......" + (System.currentTimeMillis()-time.get()));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
