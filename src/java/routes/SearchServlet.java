/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package routes;

import entities.Post;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import models.PostModel;

/**
 *
 * @author Huu
 */
@WebServlet(name="SearchServlet", urlPatterns={"/search"})
public class SearchServlet extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String name=request.getParameter("name");PrintWriter out = response.getWriter();
        try
        {
            PostModel pm=new PostModel();
            List<Post> list=pm.getPost(name);
            request.setAttribute("list", list);
            request.getRequestDispatcher("listpost.jsp").forward(request, response);
            
        }catch(Exception e)
        {
            e.printStackTrace(out);
        }
    } 


}
