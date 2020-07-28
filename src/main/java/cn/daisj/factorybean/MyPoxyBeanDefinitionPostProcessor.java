package cn.daisj.factorybean;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import cn.daisj.factorybean.mapper.RoleMapper;
import cn.daisj.factorybean.mapper.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 *@ClassName MyPoxyBeanDefinitionPostProcessor
 *@Description TODO
 *@Author Administrator
 *@Date 2020/7/28 18:07
 *@Version 1.0
 **/
@Component
public class MyPoxyBeanDefinitionPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        //先获取所有mapper的class
        List<Class<? extends Object>> classList = Arrays.asList(RoleMapper.class, UserMapper.class);
        classList.forEach(o -> {
            AbstractBeanDefinition beanDef = BeanDefinitionBuilder.genericBeanDefinition(ProxyFactoryBean.class).addConstructorArgValue(o).setScope(BeanDefinition.SCOPE_SINGLETON).getBeanDefinition();
            beanDefinitionRegistry.registerBeanDefinition(o.getName(),beanDef);
        });
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
