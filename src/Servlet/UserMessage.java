package Servlet;

import IncDao.factory.DaoFactory;
import IncDao.vo.User_message;
import netscape.security.UserDialogHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;

/**
 * Created by winfa on 2016/1/5.
 */
public class UserMessage extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String uname;
        String uemail;
        String utitle;
        String umessage;
        String rsp = null;
        uname=request.getParameter("uname");
        uemail=request.getParameter("uemail");
        utitle=request.getParameter("utitle");
        umessage=request.getParameter("umessage");
        User_message user_message = new User_message();
        user_message.setUser_id(uname);
        user_message.setUser_name(uemail);
        user_message.setMessage_title(utitle);
        user_message.setMessage_value(umessage);
        try {
            if(DaoFactory.getIUser_messageDAOstance().doInsert(user_message)) {
                request.setAttribute("message", " <script laguage='JavaScript'> alert('提交成功，您的建议对我们非常重要感谢您的留言') </script>");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        this.doGet(request,response);
    }
}
