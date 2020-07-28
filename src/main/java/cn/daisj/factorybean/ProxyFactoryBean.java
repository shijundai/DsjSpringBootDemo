package cn.daisj.factorybean;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *@ClassName ProxyFactoryBean
 *@Description TODO
 *@Author Administrator
 *@Date 2020/7/28 18:01
 *@Version 1.0
 **/
public class ProxyFactoryBean implements FactoryBean {

    private Class clazz;

    public ProxyFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object getObject() throws Exception {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{this.clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("call Proxy "+clazz.getName() + " "+ method.getName());
                return null;
            }
        });
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }
}
