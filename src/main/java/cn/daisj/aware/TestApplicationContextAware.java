package cn.daisj.aware;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * awaer 接口
 * 常用aware接口
 * 用于获取application
 **/
@Component
public class TestApplicationContextAware implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("======= applicationContext aware setApplicationContext method ======");
        TestApplicationContextAware.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
