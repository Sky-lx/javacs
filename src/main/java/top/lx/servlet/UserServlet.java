package top.lx.servlet;

import top.lx.domain.Music;
import top.lx.domain.User;

import java.util.List;

/**
 * user：chen xi
 *
 * @Description TODO
 * @Date： 2020/6/24  下午 3:44
 */
public interface UserServlet {
    //    注册
    void register(User user);
    //    登陆
    List<User> login(User user);
    //    根据用户名查询
    List<User> selectUser(String username) ;
    //
}

