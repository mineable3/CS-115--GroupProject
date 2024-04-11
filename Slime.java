public class Slime extends Enemy{

  public Slime(int hp,int damage,int pointReward)
  {
    super(hp, damage, pointReward);
  }

  public void attack(Player target)
  {
    System.out.println("The slime attacks you");
    target.addDamage(getDamage());
  }
}
