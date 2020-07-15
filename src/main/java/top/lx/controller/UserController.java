package top.lx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lx.domain.User;
import top.lx.servlet.UserServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//将类交spring来管理
@Controller
//一级路径一般用实体类名
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServlet userServlet;

    @RequestMapping(value="/register", produces="text/html;charset=UTF-8" )
    @ResponseBody
    protected void register(User user, HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");//推荐使用
            userServlet.register(user);
        try {
            response.getWriter().print("注册成功");

        } catch (IOException e) {
            e.printStackTrace();
            try {
                System.out.println("异常");
                response.getWriter().print("注册异常");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }
    @RequestMapping(value="/login", produces="text/html;charset=UTF-8" )
    @ResponseBody
    public void login(User user, HttpServletResponse response, HttpServletRequest request) throws IOException, InterruptedException {
        response.setContentType("text/html;charset=utf-8");//推荐使用
        System.out.println("1"+user.getPassword()+user.getUsername());

//       得到页面传入的密码
        String password = user.getPassword();
//        从数据库中拿对象
        List<User> users = userServlet.login(user);
//        判断是否拿到对象
        if (users.size() > 0) {
//         得到其密码
            String password1 = users.get(0).getPassword();
//           比较传入密码与数据库对象的密码
            if (password1.equals(password)) {
                response.getWriter().print("登陆成功");
                return;
            }
        }else {
            response.getWriter().print("密码错误,请重新输入");

        }

    }

    //    判断用户名是否己存在
    @RequestMapping("/selectUser")
    public void selectUser(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String name = request.getParameter("username");
        List<User> users = userServlet.selectUser(name);
//        判断用户名是否己存在
        if (users.size() > 0) {
            response.getWriter().print("用户名己存在,请重新输入");
        }

    }

    @RequestMapping(value="/cs", produces="text/html;charset=UTF-8" )
//    获取前端传过来的值
    @ResponseBody
    public String cs() {

         //值为*或指定的域名。
        System.out.println("被请求");

//要传的值
     return "未来";
    }
}
