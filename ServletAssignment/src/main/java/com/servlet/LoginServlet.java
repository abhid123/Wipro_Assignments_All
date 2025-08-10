package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if ("admin".equals(name) && "wipro".equals(password)) {
            // Redirect to SuccessServlet
            RequestDispatcher rd = request.getRequestDispatcher("SuccessServlet");
            rd.forward(request, response);
        } else {
            // Redirect to Fail.html
            RequestDispatcher rd = request.getRequestDispatcher("Fail.html");
            rd.forward(request, response);
        }
    }
}
