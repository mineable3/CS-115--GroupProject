import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Player p = new Player(100);
    Scanner keyboard = new Scanner(System.in);
    // p.addItem("short_sword");
    // p.addItem("long_sword");
    // p.addItem("health_potion");
    Dungeon0 tutorial = new Dungeon0();
    Dungeon1 level1 = new Dungeon1();
    Dungeon2 level2 = new Dungeon2();
    Dungeon3 level3 = new Dungeon3();
    tutorial.run(p, keyboard);
    level1.run(p, keyboard);
    level2.run(p, keyboard);
    level3.run(p, keyboard);

    System.out.println("\nYou escaped the dungeon with " + p.getScore() + "points!");
  }
}
