package cn.daisj.aware;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 *
 **/
@Component
public class TestServletContextAware implements ServletContextAware {
    @Override
    public void setServletContext(ServletContext servletContext) {
        System.out.println("ssssssssss TestServletContextAware setServletContext method ssssssssssssssssss");
    }
}
