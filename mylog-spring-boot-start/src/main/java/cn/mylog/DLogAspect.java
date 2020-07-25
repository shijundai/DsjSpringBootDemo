package cn.mylog;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/25
 */

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 *@ClassName DLogAspect
 *@Description TODO
 *@Author Administrator
 *@Date 2020/7/25 15:34
 *@Version 1.0
 **/
@Aspect
public class DLogAspect {

    ThreadLocal<Long> time = new ThreadLocal<>();

    @Before("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void befor() {
        time.set(System.currentTimeMillis());
        System.out.println("auto befor log ......");
    }

    @After("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void after() {
        long v = System.currentTimeMillis() - time.get();
        System.out.println("auto after log time: "+v+" ......");
    }

}
