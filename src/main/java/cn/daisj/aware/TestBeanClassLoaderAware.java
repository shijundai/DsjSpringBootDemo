package cn.daisj.aware;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.stereotype.Component;

/**
 * ClassLoader
 **/
@Component
public class TestBeanClassLoaderAware implements BeanClassLoaderAware {
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ccccccccccccccccccccccc BeanClassLoaderAware setBeanClassLoader method ccccccccccccccccccccccccccccc");
    }
}
