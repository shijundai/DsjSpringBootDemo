package cn.daisj.aware;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * 获取beanName
 **/
@Getter
@Setter
@Component
public class TestBeanNameAware implements BeanNameAware {
    String beanName;

    @Override
    public void setBeanName(String s) {
        System.out.println("===== Bean Name Aware setBeanName method=======");
       this.beanName=s;
    }
}
