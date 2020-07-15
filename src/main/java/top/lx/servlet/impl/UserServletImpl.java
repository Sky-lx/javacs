package top.lx.servlet.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lx.dao.UserDao;
import top.lx.domain.Music;
import top.lx.domain.User;
import top.lx.servlet.UserServlet;

import java.util.List;

@Service("userService")
public class UserServletImpl implements UserServlet {

    @Autowired
    private UserDao userDao;


    @Override
    public void register(User user) {
        userDao.register(user);
    }

    @Override
    public List<User> login(User user) {
        List<User> login = userDao.login(user);
        System.out.println("登陆成功");
        return  login;

    }

    @Override
    public  List<User> selectUser(String username) {

        List<User> users = userDao.selectUser(username);

        return users;
    }


}
