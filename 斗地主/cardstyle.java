package ������;

public enum cardstyle {
	style_4("����"),
	style_3("����"),
	style_2("÷��"),
	style_1("����");
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
