package cn.daisj.aop;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/15
 */

import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置druid Spring监控
 *
 **/
@Configuration
public class DruidSpringStatConfig {

    /**
     *
     * @return
     */
    @Bean
    public DruidStatInterceptor getBean(){
        return new DruidStatInterceptor();
    }

    /**
     * 配置增强类
     * @param interceptor
     * @return
     */
    @Bean
    public DefaultPointcutAdvisor springAdvisor(DruidStatInterceptor interceptor) {
        //定义切入点
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("@annotation(org.springframework.web.bind.annotation.RequestMapping)");

        //配置增强类advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(interceptor);
        return advisor;
    }
}
