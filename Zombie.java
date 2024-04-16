public class Zombie extends Enemy{

  public Zombie(int hp,int damage,int pointReward)
  {
    super(hp, damage, pointReward);
  }

  public void attack(Player target)
  {
    System.out.println("The zombie bites you");
    target.addDamage(damage);
    setHp(hp + (damage/2));
  }
}
