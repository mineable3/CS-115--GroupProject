public class Orc extends Enemy {

  public Orc(int hp,int damage,int pointReward)
  {
    super(hp, damage, pointReward);
  }

  public void attack(Player target)
  {
    System.out.println("The Orc attacks you twice");
    target.addDamage(getDamage());
    target.addDamage(getDamage());
  }
}
