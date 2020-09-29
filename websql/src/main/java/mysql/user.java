package mysql;

import java.util.Date;

public class user {
	private int id;
	private String username;
	private int age;
	private Date birth;
	
	public user() {}
	public user(String username,int age,Date birth) {
		this.age = age;
		this.username = username;
		this.birth = birth;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
}
