import java.util.Scanner;

public class Dungeon1 extends Floor{

  public Dungeon1() {
    levelNumber = 1;
  }

  public void run(Player player) {
    boolean fighting = true;
    boolean lookedAround = false;
    String command = "";
    Enemy skeleton = new Skeleton(100, 10,200);
    Scanner keyboard = new Scanner(System.in);

    displayLevelInformation();
    System.out.println();
    System.out.println("A skeleton appears!");

    while(fighting) {
      System.out.println("==============================");
      System.out.println("Commands: run   item   look   pickup");
      System.out.print("What would you like to do?: ");
      command = keyboard.next();

      switch(command) {
        case "run":
          System.out.println();
          fighting = false;
          break;

        case "item":
          System.out.println();
          player.displayInventory();
          System.out.print("What item would you like to use?: ");
          String item = keyboard.next();
          if(player.hasItem(item)) {
            useItem(player, skeleton, item);
          } else {
            System.out.println("You don't have that item");
          }
          // managing inventory method?
          break;

        case "look":
          System.out.println();
          lookedAround = true;
          System.out.println("A health potion sits on the shelf");
          break;

        case "pickup":
          System.out.println();
          if(lookedAround) {
            System.out.println("You pickup the health potion");
            player.addItem("health_potion");
          } else {
            System.out.println("There is nothing to pickup");
          }
      }
      System.out.println();

      System.out.println("The skeleton attacks you for 10hp!");
      player.setHp(player.getHp() - 10);

      System.out.println("HP: " + player.getHp());

      if(skeleton.getHp() <= 0) {
        player.setScore(player.getScore() + skeleton.getPointReward());
        completed = true;
        fighting = false;
        break;
      }
    }

    keyboard.close();

    if(completed) {
      System.out.println("You defeated the skeleton!");
      System.out.println("+200 POINTS");
      player.setScore(player.getScore() + skeleton.getPointReward());
    } else {
      System.out.println("You didn't defeat the skeleton");
    }
  }

  public void displayLevelInformation() {
    super.displayLevelInformation();
    System.out.println("You see bones lying all around");
    System.out.println("A cold dead wind blows through the room");
  }

  private void useItem(Player p, Enemy e, String item) {
    switch (item) {
      case "short_sword":
        e.setHp(e.getHp() - 10);
        System.out.println("You attack the skeleton for 10hp");
        break;

      case "long_sword":
        e.setHp(e.getHp() - 20);
        System.out.println("You attack the skeleton for 20hp");
        break;

      case "health_potion":
        p.setHp(p.getHp() + 20);
        p.removeItem("health_potion");
        System.out.println("You gained 20 hp!");
        break;

      case "":
        break;

      default:
        break;
    }
  }
}
