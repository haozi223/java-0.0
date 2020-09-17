package 对象实现;

public class personcir {
	private int count;
	private person first;
	private person last;

	public personcir(int count) {
		for(int i = 0;i<count ;i++) add(new person(i));
	}
	public void add(person p) {
		// TODO Auto-generated method stub
		if(this.count==0) {
			this.first=p;
			this.last = p;
			p.setLeft(p);
			p.setRight(p);
		}else {
			this.last.setRight(p);
			p.setLeft(this.last);
			p.setRight(this.first);
			this.first.setLeft(p);
			this.last = p;
		}
		this.count++;
	}

	public void delete(person p) {
		if(p.equals(this.first)) {
			this.last.setRight(p.getRight());
			p.getRight().setLeft(this.last);
			this.first=p.getRight();
		}else if(p.equals(this.last)) {
			p.getLeft().setRight(this.first);
			this.first.setLeft(p.getLeft());
			this.last = p.getLeft();
		}else {
			p.getLeft().setRight(p.getRight());
			p.getRight().setLeft(p.getLeft());
		}
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public person getFirst() {
		return first;
	}
	public void setFirst(person first) {
		this.first = first;
	}
	public person getLast() {
		return last;
	}
	public void setLast(person last) {
		this.last = last;
	}
}
