package cn.daisj.postprocess;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import cn.daisj.bean.PersonBean;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 **/
@Data
public class TestRegisterBeanDefinition {

    @Autowired
    private PersonBean personBean;

    public String name="testRegisterBeanDefinition";
}
