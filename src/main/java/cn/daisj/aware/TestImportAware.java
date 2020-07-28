package cn.daisj.aware;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 需要配合@import一起使用
 **/
public class TestImportAware implements ImportAware {
    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        System.out.println("iiiiiiiiiiiiiiiii ImportAware setImportMetadata method iiiiiiiiiiiii");
        System.out.println(importMetadata);
    }
}
