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
public class UserEdit extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String uid;
        String uname;
        int level = 0;
        String actions=null;
        uid=request.getParameter("user_id");
        uname=request.getParameter("user_name");
        level=Integer.parseInt(request.getParameter("level"));
        actions=request.getParameter("actions");
        if("edit".equals(actions)){
            Users users=new Users();
            users.setUser_id(uid);
            users.setUser_name(uname);
            users.setLevel(level);
            try {
                if(DaoFactory.getIuserDaostance().doUpdate(users)){
                    request.setAttribute("edit", " <script laguage='JavaScript'> alert('修改成功！') </script>");
                    request.getRequestDispatcher("users.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            Users users=new Users();
            users.setUser_id(uid);
            users.setUser_name(uname);
            users.setLevel(level);
            try {
                if(DaoFactory.getIuserDaostance().doDelete(users)){
                    request.setAttribute("edit", " <script laguage='JavaScript'> alert('删除成功！') </script>");
                    request.getRequestDispatcher("users.jsp").forward(request,response);
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
