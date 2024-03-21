/*
 * This class is going to be a super class
 * We will use this class when making all of the different enemies
 */

 public class Enemy {

  protected boolean alive;
  protected double hp, damage, pointReward;

  public Enemy() {}

  public boolean isAlive() {
    return alive;
  }

  public double getPointReward() {
    return pointReward;
  }

  public double getDamage() {
    return damage;
  }

  public double getHp() {
    return hp;
  }


}
