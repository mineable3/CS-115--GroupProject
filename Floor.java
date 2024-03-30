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
        System.out.println("You attack the skeleton for 10hp");
        break;

      case "long_sword":
        e.addDamage(20);
        System.out.println("You attack the skeleton for 20hp");
        break;

      case "health_potion":
        p.addDamage(-20);
        p.removeItem("health_potion");
        System.out.println("You gained 20 hp!");
        break;

      case "":
        break;

      default:
        break;
    }
  }

  public abstract void run(Player p);
}
