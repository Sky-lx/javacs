package top.lx.exception;

import org.springframework.lang.Nullable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * user：chen xi
 *
 * @Description TODO
 * @Date： 2020/7/1  上午 9:02
 */
public interface HandlerExceptionResolver {
    void resolveException(
            HttpServletRequest request, HttpServletResponse response, @Nullable Object handler, Exception ex) throws IOException;


}
