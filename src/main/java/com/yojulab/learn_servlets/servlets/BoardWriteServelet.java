package com.yojulab.learn_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardWriteServelet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest requsest, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(requsest, response);
    }

    @Override
    protected void doPost(HttpServletRequest requsest, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(requsest, response);
        response.setContentType("text/html;charset=UTF-8");
        requsest.setCharacterEncoding("utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<form action='<%= request.getContextPath() %>/board/boardInsert' method='post'>");

        printWriter.println("<table>");

        printWriter.println("<tr><td>제목</td>");

        printWriter.println("<td><input type='text' name='boardTitle​​'></td></tr>");

        printWriter.println("<tr><td>작성자</td>");

        printWriter.println("<td><input type='text' name='boardWriter​'></td></tr>");

        printWriter.println("<tr><td>내용</td>");

        printWriter.println("<td><textarea cols='50' rows='7' name='boardContent​'></textarea></td></tr>");

        printWriter.println(" <tr><td colspan='2'>");

        printWriter.println("<input type='submit' value='등록하기'>  ");

        printWriter.println("<a href='/board/boardList'>목록으로</a></td></tr>");

        printWriter.println("</table>");

        printWriter.println("</form>");

        printWriter.close();
    }
}
