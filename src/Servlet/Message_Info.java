package Servlet;

import IncDao.factory.DaoFactory;
import IncDao.vo.User_message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by winfa on 2016/1/6.
 */
public class Message_Info extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String title;
        String actions;
        actions=request.getParameter("actions");
        title=request.getParameter("title");
        if("info".equals(actions)) {
            User_message user_message = new User_message();
            try {
                user_message = DaoFactory.getIUser_messageDAOstance().findByTitle(title);
                request.setAttribute("uname", user_message.getUser_id());
                request.setAttribute("uemail", user_message.getUser_name());
                request.setAttribute("mtitle", user_message.getMessage_title());
                request.setAttribute("mvalue", user_message.getMessage_value());
                request.setAttribute("mdate", user_message.getMessage_date());
                request.getRequestDispatcher("message_info.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            User_message user_message= new User_message();
            try {
                user_message = DaoFactory.getIUser_messageDAOstance().findByTitle(title);
                if(DaoFactory.getIUser_messageDAOstance().doDelete(user_message)){
                    request.setAttribute("message", " <script laguage='JavaScript'> alert('删除成功!') </script>");
                    request.getRequestDispatcher("message.jsp").forward(request,response);
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
