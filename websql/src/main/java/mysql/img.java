package mysql;

public class img {
private int id;
private String img_url;
private String img_desc;
private String img_page;
private int img_order;
public img() {}
public img(int id,String img_url,String img_desc,String img_page,int img_order) {
	this.id = id;
	this.img_url = img_url;
	this.img_order = img_order;
	this.img_page = img_page;
	this.img_desc = img_desc;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getImg_url() {
	return img_url;
}
public void setImg_url(String img_url) {
	this.img_url = img_url;
}
public String getImg_desc() {
	return img_desc;
}
public void setImg_desc(String img_desc) {
	this.img_desc = img_desc;
}
public String getImg_page() {
	return img_page;
}
public void setImg_page(String img_page) {
	this.img_page = img_page;
}
public int getImg_order() {
	return img_order;
}
public void setImg_order(int img_order) {
	this.img_order = img_order;
}

}
