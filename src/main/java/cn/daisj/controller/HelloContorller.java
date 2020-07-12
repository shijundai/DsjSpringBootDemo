package cn.daisj.controller;

import cn.daisj.bean.PersonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloContorller {

    @Autowired
    private PersonBean personBean;

    @GetMapping("/world")
    public String hello(String param) {
        return "Hello world!" + param;
    }

    @RequestMapping("/person")
    public PersonBean getPerson() {
        return personBean;
    }
}
