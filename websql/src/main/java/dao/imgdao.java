package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mysql.img;

public class imgdao {
	public List<img> getList(){
		List<img> list =new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			 Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false",
		                "root", "");
			 String sql = "SELECT * FROM adimg ORDER BY img_order ASC LIMIT 0,4";
		        PreparedStatement pstmt =  conn.prepareStatement(sql);
		        ResultSet rs =  pstmt.executeQuery();
		        while (rs.next()){
		        	img img = new img();
		        	img.setId(rs.getInt("id"));
		        	img.setImg_desc(rs.getString("img_desc"));
		        	img.setImg_order(rs.getInt("img_order"));
		        	img.setImg_page(rs.getString("img_page"));
		        	img.setImg_url(rs.getString("img_url"));
		        	list.add(img);		        
		        	}
		        conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
