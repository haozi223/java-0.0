package ������;

public class run {
public static void main(String[] args) {
player p1 = new player("����");
player p2 = new player("����");
player p3 = new player("����");
player [] players = new player [] {p1,p2,p3};
game game = new game(players);
game.start();
System.out.println("������: "+game.gedizhuCards());
System.out.println(p1);
System.out.println(p2);
System.out.println(p3);
}
}
