package cn.daisj.controller;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import cn.daisj.factorybean.TestBean;
import cn.daisj.factorybean.mapper.RoleMapper;
import cn.daisj.factorybean.mapper.UserMapper;
import cn.daisj.postprocess.TestRegisterBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName TestPostProcessorController
 *@Description TODO
 *@Author Administrator
 *@Date 2020/7/28 15:32
 *@Version 1.0
 **/
@RestController
public class TestPostProcessorController {

    @Autowired
    TestRegisterBeanDefinition testRegisterBeanDefinition;

    @Autowired
    TestBean testBean;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @RequestMapping("/getTestRegisterBeanDefinition")
    public TestRegisterBeanDefinition getTestRegisterBeanDefinition() {
        return testRegisterBeanDefinition;
    }


    @RequestMapping("/getTestBean")
    public TestBean getTestBean() {
        return testBean;
    }

    @RequestMapping("/userMapper")
    public String opratorUserMapper(String op) {
        if(op != null) {
            userMapper.deleteById(op);
        } else {
            userMapper.queryAll();
        }
        return "success";
    }

    @RequestMapping("/roleMapper")
    public String opratorRoleMapper(String op) {
        if(op != null) {
            roleMapper.deleteById(op);
        } else {
            roleMapper.queryAll();
        }
        return "success";
    }

}
