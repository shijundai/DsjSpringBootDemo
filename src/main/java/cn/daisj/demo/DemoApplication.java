package cn.daisj.demo;

import cn.daisj.bean.PersonBean;
import cn.daisj.filter.DsjFilter;
import cn.daisj.listener.DsjListener;
import cn.daisj.serverlet.DsjServerlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value={"cn.daisj"})
//servlet filter listener 都是这个注解来扫描注册
@ServletComponentScan
//@ServletComponentScan(basePackages = {"cn.daisj.serverlet","cn.daisj.filter","cn.daisj.listener"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * 注册一个servlet
     * @ServletComponentScan
     * 对应的servlet类上加上@WebServlet标签,并且制定url
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean<DsjServerlet> getDsjServletBean() {
        //如果在这指定了urlmapping 那么注解上的url将失效
        ServletRegistrationBean<DsjServerlet> bean = new ServletRegistrationBean<>(new DsjServerlet(),"/servlet2");
//        ServletRegistrationBean<DsjServerlet> bean = new ServletRegistrationBean<>(new DsjServerlet());
//        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<DsjFilter> getDsjFilterBean() {
        FilterRegistrationBean<DsjFilter> bean = new FilterRegistrationBean<>(new DsjFilter());
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean<DsjListener>  getDsjListenerBean() {
        ServletListenerRegistrationBean<DsjListener> bean = new ServletListenerRegistrationBean<>(new DsjListener());
        return bean;
    }

}
