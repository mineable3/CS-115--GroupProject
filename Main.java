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
    System.out.println("    _           _                _       _   _              __   _                               _");
    System.out.println("   | |         | |              (_)     | | | |            / _| | |                             | |");
    System.out.println("   | |     __ _| |__  _   _ _ __ _ _ __ | |_| |__     ___ | |_  | |     ___  __ _  ___ _ __   __| |___");
    System.out.println("   | |    / _` | '_ \\| | | | '__| | '_ \\| __| '_ \\   / _ \\|  _| | |    / _ \\/ _` |/ _ \\ '_ \\ / _` / __|");
    System.out.println("   | |___| (_| | |_) | |_| | |  | | | | | |_| | | | | (_) | |   | |___|  __/ (_| |  __/ | | | (_| \\__ \\");
    System.out.println("   \\_____/\\__,_|_.__/ \\__, |_|  |_|_| |_|\\__|_| |_|  \\___/|_|   \\_____/\\___|\\__, |\\___|_| |_|\\__,_|___/");
    System.out.println("                       __/ |                                                 __/ |");
    System.out.println("                      |___/                                                 |___/");

    System.out.println("info:");
    System.out.println("Run: allows you to flee from battle");
    System.out.println("use_item: allows you to use items you have found");
    System.out.println("show_item: allows you to check the items you have found");
    System.out.println("look: searches the room for anything of use (does not pick up the item, can be used multiple times)");
    System.out.println("pickup: picks up items you have found in the room (must use look before picking an item up, can be used multiple times)");
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
