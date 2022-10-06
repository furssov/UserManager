package com.ua.furssov;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/update")
public class UpdateUserServlet extends HttpServlet {
    private UserDAO userDAO;
    private User user;

    @Override
    public void init() {
        userDAO = UserDAO.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user = userDAO.read(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("user", user);
        request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        user.setUserName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        userDAO.update(user.getId(), user);
         response.sendRedirect("/users/list");
    }
}