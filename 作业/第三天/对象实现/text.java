package 对象实现;

public class text {
	public static void main(String[] args) {
		personcir cir=new personcir(500);
		person p = cir.getFirst();
		int count = 0;
		while(cir.getCount()>1) {
			count++;
			if (count%3==0) {
				cir.delete(p);
				cir.setCount(cir.getCount()-1);
			}
			p=p.getRight();
		}
		System.out.println(cir.getFirst().getId());
	}
}
