// package com.kh.test.model;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
// import java.util.List;
// import com.kh.test.model;


// public class TestDao {
    
//     public Statement getStatement() {
//         String url = "jdbc:oracle:thin:@192.168.10.3:1521:xe";
//         String user = "kh";
//         String password = "kh";

//         Statement statement = null;
//         try {
//             Connection connection = DriverManager.getConnection(url, user, password);
//             statement = connection.createStatement();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return statement;
//     }

//     public List<Test> selectList(){
//         String query = "SELECT * FROM TEST";

//         List<Test> tests = new ArrayList();
//         Statement statement = getStatement();
//         ResultSet resultSet = statement.executeQuery(query);
        
//         while(resultSet.next()){ 
//             Test test = new Test();
//         test.setSeq(resultSet.getInt("SEQ"));
//         test.setWriter(resultSet.getString("WRITER"));
//         test.setTittle(resultSet.getString("TITLE"));
//         test.setContent(resultSet.getString("CONTENT"));
//         test.setDate(resultSet.getDate("DATE"));
//             tests.add(test);
//     }
//     return tests;



// }

// }
