package cn.daisj.controller;

import cn.daisj.bean.PersonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试证明final类不能被spring aop代理
 */
@RestController
@RequestMapping("/hello")
public /*final*/ class HelloContorller {

    @Autowired
    private PersonBean personBean;

    /**
     * final方法不能被aop
     * @param param
     * @return
     */
    @GetMapping("/world")
    public final String hello(String param) {
        return "Hello world!" + param;
    }

    @RequestMapping("/person")
    public PersonBean getPerson() {
        return personBean;
    }
}
