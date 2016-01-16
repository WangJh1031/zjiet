package Servlet;

import IncDao.factory.DaoFactory;
import IncDao.vo.Inc_news;

import javax.imageio.IIOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by winfa on 2016/1/6.
 */
public class CreateNew extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IIOException,ServletException{
        String ntitle;
        String nvalue;
        String actions;
        int nid;
        actions=request.getParameter("actions");
        ntitle=request.getParameter("ntitle");
        nvalue=request.getParameter("nvalue");




        if("create".equals(actions)) {

            try {
                Inc_news inc_news= new Inc_news();
                inc_news.setNews_title(ntitle);
                inc_news.setNews_value(nvalue);
                if (DaoFactory.getIInc_newsDaostance().doInsert(inc_news)) {
                    request.setAttribute("message", " <script laguage='JavaScript'> alert('新闻发布成功!!') </script>");
                    request.getRequestDispatcher("news.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            nid=Integer.getInteger(request.getParameter("nid"));
            Inc_news inc_news= new Inc_news();
            inc_news.setNews_title(ntitle);
            inc_news.setNews_value(nvalue);
            inc_news.setNews_id(nid);
            try {
                if(DaoFactory.getIInc_newsDaostance().doUpdate(inc_news)){
                    request.setAttribute("message", " <script laguage='JavaScript'> alert('新闻修改成功!!') </script>");
                    request.getRequestDispatcher("news.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IIOException,ServletException{
        this.doGet(request,response);
    }
}
