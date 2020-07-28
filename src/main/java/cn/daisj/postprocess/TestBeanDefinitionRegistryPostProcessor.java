package cn.daisj.postprocess;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * Spring BeanDefinition后置处理器
 * BeanDefinitionRegistryPostProcessor 继承自BeanFactoryPostProcessor 在生成beanDefinition后执行
 * Bean定义
 * Bean的生命周期(初始化流程)
 * class --> beanDefinition --> BeanFactoryPostProcessor(Bean工厂后置处理器) --> instance(New) --> 设置属(AutoWrite) --> aware --> 放入单例池
 **/
@Component
public class TestBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
//        BeanDefinitionBuilder.genericBeanDefinition(TestRegisterBeanDefinition.class)
//                //.setInitMethodName("")
//                .setScope(BeanDefinition.SCOPE_SINGLETON)
//                .getBeanDefinition();
        System.out.println("BeanDefinitionRegistryPostProcessor postProcessBeanDefinitionRegistry");
        System.out.println("PersonBean definition:"+beanDefinitionRegistry.getBeanDefinition("personBean"));
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(TestRegisterBeanDefinition.class);
        beanDefinition.setScope("singleton");
        beanDefinitionRegistry.registerBeanDefinition("testRegisterBean",beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor postProcessBeanFactory");
    }
}
