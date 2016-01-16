package Servlet;

import IncDao.factory.DaoFactory;
import IncDao.vo.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by winfa on 2016/1/6.
 */
public class Regedit extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String uid;
        String uname;
        String pwd;
        int level;
        uid=request.getParameter("uid");
        uname=request.getParameter("uname");
        pwd=request.getParameter("pwd");
        level=Integer.parseInt(request.getParameter("level"));
        Users users=new Users();
        users.setUser_id(uid);
        users.setUser_name(uname);
        users.setUser_pwd(pwd);
        users.setLevel(level);
        try {
            if(DaoFactory.getIuserDaostance().doInsert(users)){
                request.setAttribute("message", " <script laguage='JavaScript'> alert('注册成功！') </script>");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }else{
                request.setAttribute("message", " <script laguage='JavaScript'> alert('注册失败！请重新注册，建议使用手机号作为ID') </script>");
                request.getRequestDispatcher("regedit.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        this.doGet(request,response);
    }
}
