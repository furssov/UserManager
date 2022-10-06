package com.ua.furssov;

import com.ua.furssov.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/users/list")
public class UserListServlet extends HttpServlet {

    private UserDAO userDAO;

            @Override
            public void init()
            {
                userDAO = UserDAO.getInstance();
            }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/userList.jsp");
        request.setAttribute("users", userDAO.readAll());
        requestDispatcher.forward(request, response);
    }


}
