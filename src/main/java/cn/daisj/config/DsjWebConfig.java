package cn.daisj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * 两种注册ViewResolvers的方式
 * 1.@Bean
 * 2.重写configureViewResolvers方法
 * @return
 */
@Configuration
public class DsjWebConfig implements WebMvcConfigurer {

    class DsjViewResolver implements ViewResolver {

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            System.out.println("resolverViewName ..... ");
            if(StringUtils.equals(s,"testResolver")) {
                return (map, request, response) -> {
                    request.setAttribute("resolver",true);
                    request.setAttribute("resolverName","DsjViewResolver");
                };
            }
            return  null;
        }
    }

    /**
     * template中即使是静态资源，也应当防止直接访问，而应当通过一个Controller方法来接收访问，然后返回对应的资源
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("viewOne").setViewName("view1");
        registry.addViewController("viewTwo").setViewName("view2");
    }

    /**
     * 增加local Resolver 用于国际化
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }


    static class MyLocalResolver extends AcceptHeaderLocaleResolver {
        @Override
        public Locale resolveLocale(HttpServletRequest request) {
            String lang = request.getParameter("lang");
            if(StringUtils.isEmpty(lang)) {
                lang = (String)request.getSession().getAttribute("lang");
            } else {
                request.getSession().setAttribute("lang",lang);
            }
            if(!StringUtils.isEmpty(lang)) {
//                String[] langs = lang.split("_");
//                return new Locale(langs[0],langs[1]);
                return Locale.forLanguageTag(lang);
            }
            return super.resolveLocale(request);
        }
    }


    //    @Bean
//    public ViewResolver viewResolverBean() {
//        return new DsjViewResolver();
//    }

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.viewResolver(new DsjViewResolver());
//    }
}
