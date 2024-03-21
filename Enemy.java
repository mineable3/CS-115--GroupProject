/*
 * This class is going to be a super class
 * We will use this class when making all of the different enemies
 */

 public abstract class Enemy {

  protected boolean alive;
  protected int hp, damage, pointReward;

  public Enemy(int hp, int damage, int pointReward) {
    this.hp = hp;
    this.damage = damage;
    this.pointReward = pointReward;
  }

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
