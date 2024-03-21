/*
 * This class is going to be a super class
 * We will use this to create the levels for the game
 */

public class Floor {

  protected boolean completed = false;
  protected double levelNumber = -1;

  public Floor() {}

  public void displayLevelInformation() {
    System.out.println("The room is dark and dungeon like");
  }

  public double getLevelNumber() {
    return levelNumber;
  }

  public boolean isCompleted() {
    return completed;
  }
}
