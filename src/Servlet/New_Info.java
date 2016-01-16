package Servlet;

import IncDao.factory.DaoFactory;
import IncDao.vo.Inc_news;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created by winfa on 2016/1/6.
 */
public class New_Info extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        int nid;
        String actions;
        actions=request.getParameter("actions");
        nid=Integer.parseInt(request.getParameter("new_id"));
        if("edit".equals(actions)){
            Inc_news inc_news = new Inc_news();
            try {
                inc_news = DaoFactory.getIInc_newsDaostance().findById(nid);
                request.setAttribute("nid",inc_news.getNews_id());
                request.setAttribute("ntitle",inc_news.getNews_title());
                request.setAttribute("nvalue",inc_news.getNews_value());
                request.getRequestDispatcher("new_info.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            Inc_news inc_news = new Inc_news();
            try {
                inc_news = DaoFactory.getIInc_newsDaostance().findById(nid);
                if(DaoFactory.getIInc_newsDaostance().doDelete(inc_news)){
                    request.setAttribute("message", " <script laguage='JavaScript'> alert('删除成功!') </script>");
                    request.getRequestDispatcher("news.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        this.doGet(request,response);
    }
}
