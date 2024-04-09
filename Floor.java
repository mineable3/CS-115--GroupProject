import java.util.Scanner;

/*
 * This class is going to be a super class
 * We will use this to create the levels for the game
 */

public abstract class Floor {

  protected boolean completed = false;
  protected int levelNumber = -1;

  public Floor() {}

  public void displayLevelInformation() {
    System.out.println("The room is dark and dungeon like");
  }

  public int getLevelNumber() {
    return levelNumber;
  }

  public boolean isCompleted() {
    return completed;
  }

  protected void useItem(Player p, Enemy e, String item) {
    switch (item) {
      case "short_sword":
        e.addDamage(10);
        System.out.println("You attack for 10hp");
        e.attack(p);
        break;

      case "long_sword":
        e.addDamage(20);
        System.out.println("You attack for 20hp");
        e.attack(p);
        break;

      case "small_shield":
        break;

      case "health_potion":
        p.addDamage(-20);
        p.removeItem("health_potion");
        System.out.println("You gained 20 hp!");
        e.attack(p);
        break;

      case "":
        break;

      default:
        break;
    }
  }

  public abstract void run(Player p, Scanner keyboard);
}
