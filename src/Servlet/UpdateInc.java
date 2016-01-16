package Servlet;



import IncDao.factory.DaoFactory;
import IncDao.vo.Inc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by winfa on 2016/1/5.
 */
public class UpdateInc extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String inc_title;
        String inc_value;
        inc_title=request.getParameter("title");
        inc_value=request.getParameter("values");
        Inc inc = new Inc();
        inc.setInc_title(inc_title);
        inc.setInc_info(inc_value);
        try {
            if(DaoFactory.getIIncDaostance().doUpdate(inc)){
                request.setAttribute("message", " <script laguage='JavaScript'> alert('修改成功，刷新主页查看效果！') </script>");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        doGet(request,response);
    }

}
