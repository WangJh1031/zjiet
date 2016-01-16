package Servlet;

        import IncDao.factory.DaoFactory;
        import IncDao.vo.User_message;
        import IncDao.vo.Users;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;



/**
 * Created by winfath on 16/1/4.
 */
public class LoginServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        String spath="index.jsp";
        String dpath="login.jsp";
        int level=0;
        String uid=request.getParameter("uid");
        String pwd=request.getParameter("pwd");
        List<String> info= new ArrayList<String>();

        Users users = new Users();
        try {
            users=DaoFactory.getIuserDaostance().findByIdPwd(uid,pwd);
            level=users.getLevel();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if(users!=null && level>=3){

            info.add(users.getUser_name());
            HttpSession session = request.getSession(true);
            session.removeAttribute("uid");
            session.setAttribute("uid",users.getUser_name());

            response.sendRedirect("index.jsp");
        }
        else if(users!=null && level<3) {
            request.setAttribute("message", " <script laguage='JavaScript'> alert('拒绝访问 你太LOW！！') </script>");
            request.getRequestDispatcher(dpath).forward(request,response);
        }
        else {
            request.setAttribute("message", " <script laguage='JavaScript'> alert('傻逼！输错密码啦！！！') </script>");
            request.getRequestDispatcher(dpath).forward(request,response);
        }

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        doGet(request,response);
    }
}
