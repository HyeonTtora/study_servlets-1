<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
        <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
  </head>
  <body>
      <div class="container">
  <% HashMap<String, Object> question = (HashMap<String, Object>)request.getAttribute("questions");%>
  <%  ArrayList<HashMap> answer = (ArrayList<HashMap>)request.getAttribute("example_list"); %>
  <% ArrayList<String> questionUIDs = (ArrayList<String>)request.getAttribute("questionUIDs"); %> 
     <nav class="navbar navbar-expand">
    <div class="navbar-nav">
    <% for (int i = 0; i < questionUIDs.size(); i++) { %>
    <% String questionUID = questionUIDs.get(i); %>

       <a class="nav-item nav-link fs-4" href="/poll/PollServlet?QUESTIONS_UID=<%=questionUID%>"><%=questionUID%></a>

    <% } %>
    </div>
     </nav>
    <div class = "fs-4">
     <%= question.get("ORDERS") %>. <%= question.get("QUESTIONS")%>
    </div>

    <%for (int i = 0; i < answer.size(); i++) { %>
            <% HashMap<String, Object> bundle = answer.get(i); %>
            <% String example = (String) bundle.get("EXAMPLE"); %>
            <% int order = (int) bundle.get("ORDERS") ;%>

        <div class="form-check"> 
          <input class="form-check-input" type="radio" name="<%= question.get("QUESTIONS_UID")%>" id="<%= question.get("QUESTIONS_UID")%><%= order %>" value = "<%=bundle.get("EXAMPLE_UID") %>" />
        <label class ="fs-5"for="<%= question.get("QUESTIONS_UID")%><%= order %>">(<%= order %>) <%=example%> </label>
         </div>

    <% } %>

    </div>
        <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
    </body>
</html>
