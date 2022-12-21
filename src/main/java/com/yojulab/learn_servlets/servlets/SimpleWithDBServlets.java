package com.yojulab.learn_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.yojulab.learn_servlets.dao.SimpleWithDB;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/simple/WithDBServlets")
public class SimpleWithDBServlets extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        // bix with DB
        SimpleWithDB simpleWithDB = new SimpleWithDB();
        ArrayList<HashMap> bundleList = simpleWithDB.getList();
        for (int i = 0; i < bundleList.size(); i++) {
            HashMap<String, Object> bundle = bundleList.get(i);
            HashMap<String, Object> question = (HashMap<String, Object>) bundle.get("question");
            int orders = (int) question.get("ORDERS");
            String questions = (String) question.get("QUESTIONS");
            String questionsUid = (String) question.get("QUESTIONS_UID");
        }

        // display
                                                   
        PrintWriter pw = response.getWriter();
        pw.println("<div>SimpleWithDBServlets</div>");
        for (int i = 0; i < bundleList.size(); i++) {
            HashMap<String, Object> bundle = bundleList.get(i);
            HashMap<String, Object> question = (HashMap<String, Object>) bundle.get("question");
            int orders = (int) question.get("ORDERS");
            String questions = (String) question.get("QUESTIONS");
            String questionsUid = (String) question.get("QUESTIONS_UID");
            pw.println(
                    "<div>" + orders + ". " + questions + "<input type='hidden' value='" + questionsUid + "'></div>");
        }
        pw.close();
    }
}