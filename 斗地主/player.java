package ¶·µØÖ÷;

public class player {
private String name;
private String juese;
private card [] cards=new card[20];
public player (String name) {
	this.name = name;
	this.juese = "Íæ¼Ò";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getJuese() {
	return juese;
}
public void setJuese(String juese) {
	this.juese = juese;
}
public card[] getCards() {
	return cards;
}
public void setCards(card[] cards) {
	this.cards = cards;
}
@Override
public String toString() {
	StringBuffer sBuffer = new StringBuffer();
	for(card card:this.cards) {
		if(null!=card) sBuffer.append(card).append(",");
	}
	sBuffer.deleteCharAt(sBuffer.lastIndexOf(","));
	return name+"    "+juese+"\n"+sBuffer.toString();
}
}
