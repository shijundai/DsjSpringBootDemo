package cn.daisj.aware;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletConfigAware;

import javax.servlet.ServletConfig;

/**
 *
 **/
@Component
public class TestServerletConfigAware implements ServletConfigAware {
    @Override
    public void setServletConfig(ServletConfig servletConfig) {
        System.out.println("scscscscscscsc TestServerletConfigAware setServletConfig method scscscscscscscsc");
    }
}
