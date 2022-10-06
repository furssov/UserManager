package com.ua.furssov;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users/create")
public class CreateUserServlet extends HttpServlet {

         private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = UserDAO.getInstance();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Create new user</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/users/create\" method=\"post\">\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                <label for=\"userName\">UserName: </label>\n" +
                "            </td>\n" +
                "            <td>\n" +
                "                <input type=\"text\" id=\"userName\" name=\"username\" />\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                <label for=\"password\">Password: </label>\n" +
                "            </td>\n" +
                "            <td>\n" +
                "                <input type=\"password\" id=\"password\" name=\"password\" />\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td> <input type=\"submit\" value=\"Create\" /></td>\n" +
                "            <td><input type=\"reset\" value=\"Reset\"></td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "    \n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String username =  request.getParameter("username");
         String password =  request.getParameter("password");
         userDAO.create(new User(username, password));
         response.sendRedirect("/users/list");
    }
}
