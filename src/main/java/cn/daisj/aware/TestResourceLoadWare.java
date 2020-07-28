package cn.daisj.aware;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 *@ClassName TestResourceLoadWare
 *@Description TODO
 *@Author Administrator
 *@Date 2020/7/28 14:57
 *@Version 1.0
 **/
@Component
public class TestResourceLoadWare implements ResourceLoaderAware {
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("rrrrrrrrrrrrrr ResourceLoaderAware setResourceLoader method rrrrrrr");
    }
}
