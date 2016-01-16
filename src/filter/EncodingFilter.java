package filter;

/**
 * Created by Wang Jh/winfath@foxmail.com on 2016/1/6.
 */
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    protected FilterConfig config;

    protected String Encoding = null;

    public void init(FilterConfig config) throws ServletException {

        this.config = config;
        this.Encoding = config.getInitParameter("Encoding");

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException, IOException {

        if (request.getCharacterEncoding() == null) {
            if (Encoding != null) {
                request.setCharacterEncoding(Encoding);
                response.setCharacterEncoding(Encoding);
            }
        }
        chain.doFilter(request,response);
    }
    public void destroy() {}
}