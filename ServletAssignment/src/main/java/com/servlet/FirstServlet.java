package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get data from request
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // Store in session
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("password", password);

        // Response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Welcome, " + name + "</h2>");
        out.println("<p>Data saved in session.</p>");
        out.println("<a href='SecondServlet'>Click here to go to SecondServlet</a>");
    }
}
