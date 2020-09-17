package 对象实现;

public class person {
	private int id;
	private person left;
	private person right;


	public person(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public person getLeft() {
		return left;
	}
	public void setLeft(person left) {
		this.left = left;
	}
	public person getRight() {
		return right;
	}
	public void setRight(person right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "id:"+id;
	}
}
