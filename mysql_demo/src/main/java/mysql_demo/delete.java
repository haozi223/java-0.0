package mysql_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class delete {
	 public static void main(String[] args) throws  Exception {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false",
	                "root", "");
		 PreparedStatement pstmt = conn.prepareStatement("delete from user where id = ?");
		 pstmt.setInt(1, 5);
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
