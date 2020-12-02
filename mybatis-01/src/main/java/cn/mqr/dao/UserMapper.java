package cn.mqr.dao;

import cn.mqr.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    //查询所有用户
    List<User> getUserList();

    //添加用户
    void insertUser(User user);

    //根据id查询用户  方法中有多个参数  参数必须加@Param
    @Select("select * from test where id = #{id}")
    User getUserById(@Param("id") int id);

}
