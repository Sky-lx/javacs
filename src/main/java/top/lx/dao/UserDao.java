package top.lx.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.lx.domain.Music;
import top.lx.domain.User;

import java.util.List;

@Repository
public interface UserDao {
//    注册
    @Insert("insert into user(id,username,password,gender,age,email) VALUES (null,#{username},#{password},#{gender},#{age},#{email})")
    void register(User user);
    //    登陆
    @Select(" select * from user where username=#{username} and password=#{password}")
    List<User> login(User user);

    @Select("select*from user where username=#{username}")
    //根据用户名查询
    List<User> selectUser(String username);

}
