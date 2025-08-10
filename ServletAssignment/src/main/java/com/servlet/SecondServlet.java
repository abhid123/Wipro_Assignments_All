package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get session
        HttpSession session = request.getSession(false); // false = don't create if not exists

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (session != null) {
            String name = (String) session.getAttribute("name");
            String password = (String) session.getAttribute("password");

            out.println("<h2>Welcome Back</h2>");
            out.println("<p>Name from session: " + name + "</p>");
            out.println("<p>Password from session: " + password + "</p>");
        } else {
            out.println("<p>No session found. Please login first.</p>");
        }
    }
}
	