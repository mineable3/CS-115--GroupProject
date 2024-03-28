/*
 * This class is going to be a super class
 * We will use this class when making all of the different enemies
 */

 public class Enemy {

  protected boolean alive;
  protected int hp, damage, pointReward;

  public Enemy(int hp,int damage,int pointReward) {
    this.hp = hp;
    this.damage = damage;
    this.pointReward = pointReward;
  }

  public boolean isAlive() {
    return alive;
  }

  public int getPointReward() {
    return pointReward;
  }

  public int getDamage() {
    return damage;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }
}
