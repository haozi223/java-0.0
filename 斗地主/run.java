package 斗地主;

public class run {
public static void main(String[] args) {
player p1 = new player("张三");
player p2 = new player("李四");
player p3 = new player("王五");
player [] players = new player [] {p1,p2,p3};
game game = new game(players);
game.start();
System.out.println("地主牌: "+game.gedizhuCards());
System.out.println(p1);
System.out.println(p2);
System.out.println(p3);
}
}
