package cn.daisj.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    /**
     * 使用spring-boot-starter-jdbc
     * SpringBoot 会自动配置相应的 JdbcTemplate
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("queryAllUser")
    public List<Map<String, Object>> queryAllUser() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from t_user");
        return list;
    }

}
