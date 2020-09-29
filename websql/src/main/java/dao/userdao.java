package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mysql.user;

public class userdao {
public List<user> getusers(){
	List<user> list =new ArrayList<>();
	try {
		Class.forName("com.mysql.jdbc.Driver"); 
		 Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false",
	                "root", "");
		 String sql = "select id, username, age, birth from user";
	        PreparedStatement pstmt =  conn.prepareStatement(sql);
	        ResultSet rs =  pstmt.executeQuery();
	        while (rs.next()){
	        	user user = new user(rs.getString("username"),rs.getInt("age"),rs.getTimestamp("birth")); 
	        	user.setId(rs.getInt("id"));
	        	list.add(user);
	        }
	        conn.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}
public void save(String username, int age, Date birth) throws Exception{
    // 链接上数据库
    Class.forName("com.mysql.jdbc.Driver");
    // 获取数据库的链接
    Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false",
            "root", "");
    // 保存数据
    String saveSql = "insert into user(username,age,birth,id) values(?,?,?,?)";

    PreparedStatement pstmt =  conn.prepareStatement(saveSql);

    // 给占位符赋值
    pstmt.setString(1,username);
    pstmt.setInt(2,age);
    pstmt.setObject(3,birth);
    pstmt.setObject(4,8);

    // 执行sql语句
    pstmt.executeUpdate(); // 适合 insert delete update的操作

   conn.close();

}
}
