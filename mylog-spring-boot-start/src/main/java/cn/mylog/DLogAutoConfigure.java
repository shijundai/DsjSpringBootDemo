package cn.mylog;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/25
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@ClassName DLogAutoConfigure
 *@Description TODO
 *@Author Administrator
 *@Date 2020/7/25 15:32
 *@Version 1.0
 **/

@Configuration
public class DLogAutoConfigure {

    @Bean
    public DLogAspect getDlogBean() {
        return new DLogAspect();
    }
}
