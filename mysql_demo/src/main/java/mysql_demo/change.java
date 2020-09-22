package mysql_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class change {
	 public static void main(String[] args) throws  Exception {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false",
	                "root", "");
		 PreparedStatement pstmt = conn.prepareStatement("update user set username = ?, age = ?,birth=? where id = ?");
		 pstmt.setString(1,"Ð¡Áù");
		 pstmt.setInt(2, 15);
		 pstmt.setInt(4, 4);
		 pstmt.setObject(3,new Date());
		 pstmt.executeUpdate();
	     pstmt =  conn.prepareStatement("select id, username, age, birth from user");
	     ResultSet rs =  pstmt.executeQuery();
	     while (rs.next()){
	            System.out.print(rs.getInt("id") + "\t");
	            System.out.print(rs.getString("username") + "\t");
	            System.out.print(rs.getInt("age") + "\t");
	            System.out.print(rs.getTimestamp("birth") + "\t");
	            System.out.println();
	        }
	}
}