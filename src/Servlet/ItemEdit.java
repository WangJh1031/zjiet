package Servlet;

import IncDao.factory.DaoFactory;
import IncDao.vo.Items;

import javax.imageio.IIOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by winfa on 2016/1/7.
 */
public class ItemEdit extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IIOException,ServletException{
        String item_id;
        String item_name;
        String item_info;
        String actions;
        String iclass;
        String isrc;
        item_id=request.getParameter("item_id");
        item_name=request.getParameter("item_name");
        item_info=request.getParameter("item_info");
        actions=request.getParameter("actions");
        iclass=request.getParameter("iclass");
        isrc=request.getParameter("isrc");
        if("edit".equals(actions)){
            Items items = new Items();
            items.setItem_id(item_id);
            items.setItem_name(item_name);
            items.setItem_info(item_info);
            try {
                if(DaoFactory.getIItemsDaostance().doUpdate(items)) {
                    request.setAttribute("edit", " <script laguage='JavaScript'> alert('修改成功！') </script>");
                    request.getRequestDispatcher("items.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if("create".equals(actions)){
            Items items = new Items();
            items.setItem_id(item_id);
            items.setItem_name(item_name);
            items.setItem_info(item_info);
            items.setIclass(iclass);
            items.setIsrc(isrc);
            try {
                if(DaoFactory.getIItemsDaostance().doInsert(items)){
                    request.setAttribute("edit", " <script laguage='JavaScript'> alert('添加成功！') </script>");
                    request.getRequestDispatcher("items.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            Items items = new Items();
            items.setItem_id(item_id);
            items.setItem_name(item_name);
            items.setItem_info(item_info);
            try {
                if (DaoFactory.getIItemsDaostance().doDelete(items)) {
                    request.setAttribute("edit", " <script laguage='JavaScript'> alert('删除成功！') </script>");
                    request.getRequestDispatcher("items.jsp").forward(request,response);
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
