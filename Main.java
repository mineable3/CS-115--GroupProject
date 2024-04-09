public class Main {

  public static void main(String[] args) {
    Player p = new Player(100);
    // p.addItem("short_sword");
    // p.addItem("long_sword");
    // p.addItem("health_potion");
    Dungeon0 tutorial = new Dungeon0();
    Dungeon1 level1 = new Dungeon1();
    tutorial.run(p);
    level1.run(p);
  }
}
