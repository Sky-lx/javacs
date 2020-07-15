package top.lx.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * user：chen xi
 *.编写异常处理器
 * @Description TODO
 * @Date： 2020/6/30  下午 9:07
 */
@Controller
@RequestMapping("/exception")
public class zdyExceptionResolver implements HandlerExceptionResolver {
    //     处理异常业务逻辑
    @Override
    @RequestMapping("/resolveException")
    public void resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws IOException {
//      获取异常对象
        zdyException e = null;
//       判断,如果传入的异常对象是后面的类的实例,
        if (ex instanceof zdyException) {
//            将这个异常强转
            e = (zdyException) ex;
            e = new zdyException("");
        } else {
//            如果不是这个异常,就创建一个异常
            e = new zdyException("系统正在维护");
        }
        String message = e.getMessage();
//        创建ModeLAndView对象
        response.getWriter().print(message);
    }

}
