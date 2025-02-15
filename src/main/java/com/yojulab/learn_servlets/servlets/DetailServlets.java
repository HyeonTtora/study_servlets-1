package com.yojulab.learn_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.yojulab.learn_servlets.dao.PollWithDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/poll/PollServlet")

public class DetailServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // input type
        String questions_Uid = request.getParameter("QUESTIONS_UID");

        // biz with DB and Class
        PollWithDB pollWithDB = new PollWithDB();
        HashMap<String, Object> question = null;
        ArrayList<HashMap> example_list = null;
        ArrayList<String> questionUIDs = null;
        try {
            question = pollWithDB.getQuestion(questions_Uid);
            example_list = pollWithDB.getExamples(questions_Uid);
            questionUIDs = pollWithDB.getQuestionUIDs();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Output with html
        request.setAttribute("questions", question);
        request.setAttribute("example_list", example_list);
        request.setAttribute("questionUIDs", questionUIDs);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/poll/details.jsp");
        requestDispatcher.forward(request, response);
    }

}
