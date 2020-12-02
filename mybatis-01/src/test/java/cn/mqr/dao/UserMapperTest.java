package cn.mqr.dao;

import cn.mqr.pojo.User;
import cn.mqr.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // way 1
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        //close sqlSession
        sqlSession.close();
    }

    @Test
    public void insert() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(4, "孟庆荣", "1111");
        mapper.insertUser(user);

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void select() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(4);
        System.out.println(user);
    }
}
