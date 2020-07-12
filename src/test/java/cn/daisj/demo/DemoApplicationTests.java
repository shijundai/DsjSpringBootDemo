package cn.daisj.demo;

import cn.daisj.bean.PersonBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    PersonBean personBean;

    @Test
    void contextLoads() {
    }

    @Test
    void testPersonBean() {
        System.out.println(personBean);
    }

}
