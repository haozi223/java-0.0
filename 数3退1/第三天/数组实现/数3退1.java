package ����ʵ��;

public class ��3��1 {
	public static void main (String[] args) {
		boolean [] scir= new boolean[500];
		for(int i = 0 ;i<scir.length;i++) scir[i]=true;
		int left = scir.length,count=0,index=0;
		while(left>1) {
			if(scir[index]) {
				count++;
				if(count % 3==0) {
					scir[index]=false;
					left--;
				}
			}
			index++;
			if(index>=scir.length) index=0;
		}
		for(int i = 0 ;i<scir.length;i++) if(scir[i]) System.out.println(i);
	}
}
