package 斗地主;

public enum cardstyle {
	style_4("黑桃"),
	style_3("红桃"),
	style_2("梅花"),
	style_1("方块");
	private String show;
	private cardstyle(String show) {
		// TODO Auto-generated constructor stub
		this.show=show;
	}
	@Override
	public String toString() {
		return show;
	}
}
