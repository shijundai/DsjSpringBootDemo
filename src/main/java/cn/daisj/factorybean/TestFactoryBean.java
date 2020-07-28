package cn.daisj.factorybean;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 *@ClassName TestFactoryBean
 *@Description TODO
 *@Author Administrator
 *@Date 2020/7/28 17:47
 *@Version 1.0
 **/
@Component
public class TestFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new TestBean();
    }

    @Override
    public Class<?> getObjectType() {
        return TestBean.class;
    }
}
