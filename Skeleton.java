public class Skeleton extends Enemy{

  public Skeleton(int hp,int damage,int pointReward)
  {
    super(hp, damage, pointReward);
  }

  public void attack(Player target)
  {
    System.out.println("The skeleton attacks you");
    target.addDamage(getDamage());
  }
}
