package cn.daisj.factorybean.mapper;/**
 * @author Administrator
 * @Title: Controller
 * @Description:
 * @date 2020/7/28
 */

import java.util.List;

/**
 *@ClassName UserMapper
 *@Description TODO
 *@Author Administrator
 *@Date 2020/7/28 18:00
 *@Version 1.0
 **/
public interface UserMapper {

    List queryAll();

    void deleteById(String id);

}
