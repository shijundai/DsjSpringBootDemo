package cn.daisj.postprocess;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BeanPostProcessor为我们提供了两个方法，我们可以在Spring实例化Bean的前后实现我们的特定需求。
 * (Spring AOP就是根据BeanPostProcessor建立与IOC的联系)
 */
@Component
public class TestBeanPostProcess implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //不加的判断 所有的bean初始化都会打印
        if(StringUtils.equals(beanName,"personBean")) {
            System.out.println("++++++++++++++ in BeanPostProcess postProcessBeforeInitialization +++++++++++++++++++");
            System.out.println(beanName + ":" + bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(StringUtils.equals(beanName,"personBean")) {
            System.out.println("__________________ in BeanPostProcess postProcessAfterInitialization _________________");
            System.out.println(beanName + ":" + bean);
        }
        return bean;
    }
}
