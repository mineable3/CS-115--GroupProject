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
    // p.addItem("short_sword");
    // p.addItem("small_shield (passive)");
    // p.addItem("health_potion");
    // p.addItem("long_sword");
    // p.addItem("large_shield (passive)");
    if(!p.isDead()) {
      level1.run(p, keyboard);
    }
    if(!p.isDead()) {
      level2.run(p, keyboard);
    }
    if(!p.isDead()) {
      level3.run(p, keyboard);
    }

    if(!p.isDead()) {
      System.out.println("\nYou escaped the dungeon with " + p.getScore() + "points!");
    } else if(p.isDead()) {
      System.out.println("When you died you had " + p.getScore() + "points");
    }

  }
}
