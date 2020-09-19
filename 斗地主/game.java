package 斗地主;

import java.util.Arrays;
import java.util.Random;

public class game {
private card [] cards = new card[54];
private player[] players = new player[3];
private card [] dizhuCards = new card[3];
public game(player[] players) {
	if(players.length!=3) {
		System.out.println("玩家数量不匹配");
		System.exit(0);
	}else {
		this.players=players;
		newcard();
	}
}
private void newcard() {
	// TODO Auto-generated method stub
	int index = 0;
	for(cardstyle style:cardstyle.values()) {
		for(int i =3;i<=15;i++) cards[index++] = new card(i, style) ;
	}
	cards[index++]=new card(16, null);
	cards[index]=new card(17, null);
}
public void start() {
	for(int i =0;i<17;i++) {
		for(player player :this.players) {
			int index = new Random().nextInt(cards.length);
			player.getCards()[i] = cards[index];
			cards [index] = cards[cards.length-1];
			card [] newcard = new card[cards.length-1];
			newcard = Arrays.copyOf(cards, cards.length-1);
			cards = newcard;
		}
	}
	for(player player:players) {
		player.setJuese("农民");
	}
	int index2 = new Random().nextInt(3);
	players[index2].setJuese("地主");
	dizhuCards = cards;
	players[index2].getCards()[17] =cards[cards.length-3];
	players[index2].getCards()[18] =cards[cards.length-2];
	players[index2].getCards()[19] =cards[cards.length-1];
	sort();
}
private void sort() {
	// TODO Auto-generated method stub
	for(player player:players) {
		for (int i = 0; i < player.getCards().length; i++) {
			for (int j = i+1; j <  player.getCards().length; j++) {
				if(player.getCards()[i]!=null&&player.getCards()[j]!=null) {
					if(player.getCards()[i].getRealvalue()>player.getCards()[j].getRealvalue()) {
						card temp = player.getCards()[i];
						player.getCards()[i]= player.getCards()[j];
						player.getCards()[j] = temp;
						
					}
				}
			}
		}
	}
}
public card [] geCards() {
	return cards;
}
public String gedizhuCards() {
	StringBuffer stringBuffer = new StringBuffer();
	for(card card:dizhuCards) {
		stringBuffer.append(card).append(",");
	}
	stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
	return stringBuffer.toString();
}
}
