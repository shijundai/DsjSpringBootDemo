package cn.daisj.postprocess;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * bean工厂后置处理类 bean工厂初始化好后调用
 **/
@Component
@Order(1)
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("My TestBeanFactoryPostProcessor Method ...........");
        //获取或创建bean
        //configurableListableBeanFactory.getBean("personBean");
        //获取bean定义
        //configurableListableBeanFactory.getBeanDefinition("personBean");
    }
}
