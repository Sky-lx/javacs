package top.lx.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * user：chen xing
 *
 * @Description TODO
 * @Date： 2020/7/15  上午 8:58
 */
public class SimpleCORSFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException, IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
//        解决跨域问题只要这一句就ok了
        //出现跨哉问题的原因：CORS 头缺少 'Access-Control-Allow-Origin'
//        那我们手动加上Access-Control-Allow-Origin就可以解决问题
        response.setHeader("Access-Control-Allow-Origin", "*");
    /*    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");*/
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }
}

