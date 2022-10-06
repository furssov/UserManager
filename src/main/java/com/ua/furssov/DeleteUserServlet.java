package com.ua.furssov;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/delete")
public class DeleteUserServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = UserDAO.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        userDAO.delete(Integer.parseInt(request.getParameter("id")));

        response.sendRedirect("/users/list");
    }
}
