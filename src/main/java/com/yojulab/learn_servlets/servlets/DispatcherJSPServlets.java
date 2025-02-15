package com.yojulab.learn_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatcherJSPServlets")
public class DispatcherJSPServlets extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String hiddenParam = request.getParameter("hiddenParam");

            request.setAttribute("firstName", "httoras");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/seaech_form.jsp");
            requestDispatcher.forward(request, response);
            
      
    }
}
