package cn.daisj.aware;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

/**
 * 国际化??
 **/
@Component
public class TestMessageSourceAware implements MessageSourceAware {
    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("mmmmmmmmmm MessageSourceAware setMessageSource methodmmmmmmmmmmm");
    }
}
