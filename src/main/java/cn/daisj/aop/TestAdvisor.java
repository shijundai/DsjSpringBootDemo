package cn.daisj.aop;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/15
 */

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@ClassName TestAdvisor
 *@Description TODO
 *@Author Administrator
 *@Date 2020/7/15 18:55
 *@Version 1.0
 **/
@Configuration
public class TestAdvisor {


    @Bean
    public Advisor getAdvisor(TestInterceptor testInterceptor) {
        //定义切入点
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public * *..*.controller.*..*(..))");

        //配置增强类advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(testInterceptor);
        return advisor;

    }

}
