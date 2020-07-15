package cn.daisj.aop;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/15
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 *@ClassName TestInterceptor
 *@Description TODO
 *@Author Administrator
 *@Date 2020/7/15 16:15
 *@Version 1.0
 **/
@Component
public class TestInterceptor implements MethodInterceptor {

    /**
     * Interceptor 相当于@Befor @After @Exeption
     * @param methodInvocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try {
            System.out.println(Thread.currentThread()+" 方法执行前..........");
            Object result = methodInvocation.proceed();
            System.out.println(Thread.currentThread()+" 方法执之后..........");
            return result;
        }catch (Exception e) {
            System.out.println("方法异常了...........");
        }
        return null;
    }
}
