package cn.daisj.aware;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 *@ClassName TestEmbeddedValueResolverAware
 *@Description TODO
 *@Author Administrator
 *@Date 2020/7/28 11:52
 *@Version 1.0
 **/
@Component
public class TestEmbeddedValueResolverAware implements EmbeddedValueResolverAware {
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("eeeeeeeeee EmbeddedValueResolverAware setEmbeddedValueResolver method eeeeeeeee");
    }
}
