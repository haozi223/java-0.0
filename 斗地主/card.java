package ������;

public class card {
private String showcard;
private int realvalue;
private cardstyle style;
public String getShowcard() {
	return showcard;
}
public void setShowcard(String showcard) {
	this.showcard = showcard;
}
public int getRealvalue() {
	return realvalue;
}
public void setRealvalue(int realvalue) {
	this.realvalue = realvalue;
}
public cardstyle getStyle() {
	return style;
}
public void setStyle(cardstyle style) {
	this.style = style;
}
public card(int realvalue, cardstyle style2) {
	setvalue(realvalue);
	if(realvalue==16||realvalue==17) {
		this.style=null;
	}else {
		this.style = style2;
	}
}
private void setvalue(int realvalue2) {
	// TODO Auto-generated method stub
	if(realvalue2>=3||realvalue2<=17) {
		this.realvalue = realvalue2;
		switch(realvalue2) {
		case 11:
			this.showcard="J";
			break;
		case 12:
			this.showcard="Q";
			break;
		case 13:
			this.showcard="K";
			break;
		case 14:
			this.showcard="A";
			break;
		case 15:
			this.showcard="2";
			break;
		case 16:
			this.showcard="С��";
			break;
		case 17:
			this.showcard="����";
			break;
		default:{
			this.showcard=realvalue2+"";
		}
			
		}
	}else {
		System.out.println("��ֵ���ô���");
		System.exit(0);
	}
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return (style==null?"":style)+this.showcard;
}
}
