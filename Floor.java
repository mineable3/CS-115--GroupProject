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

  public abstract void run(Player p);
}
