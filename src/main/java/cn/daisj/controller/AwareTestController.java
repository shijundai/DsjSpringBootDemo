package cn.daisj.controller;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import cn.daisj.aware.TestApplicationContextAware;
import cn.daisj.aware.TestApplicationEventPublishAware;
import cn.daisj.aware.TestBeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName AwareTestController
 *@Description TODO
 *@Author Administrator
 *@Date 2020/7/28 9:22
 *@Version 1.0
 **/
@RestController
    @ControllerAdvice
public class AwareTestController {

    @Autowired
    TestBeanNameAware beanNameAware;

    @Autowired
    TestApplicationContextAware testApplicationContextAware;

    @Autowired
    TestApplicationEventPublishAware testApplicationEventPublishAware;


    @RequestMapping("/getTestBeanAware")
    public TestBeanNameAware getTestBeanAware() {
        return beanNameAware;
    }


    @RequestMapping("/testApplicationContextAware")
    public Object getTestApplicationContextAware() {
        return TestApplicationContextAware.getApplicationContext().getBean("testBeanNameAware");
    }

    @RequestMapping("/testApplicatlionEventPublishAware")
    public String testApplicatlionEventPublishAware(String name) {
        testApplicationEventPublishAware.register(name);
        return "success";
    }
}
