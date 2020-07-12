package cn.daisj.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "person")
@Data
public class PersonBean {
    private String name;
    private Integer age;
    private boolean sex;
    private List<String> tag;


    @Override
    public String toString() {
        return "PersonBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", tag=" + tag +
                '}';
    }
}
