import java.util.Scanner;

public class Dungeon1 extends Floor{

  public Dungeon1() {
    levelNumber = 1;
  }

  public void run(Player player) {
    boolean fighting = true;
    boolean lookedAround = false;
    int itemsPickedUp = 0;
    String command = "";
    Skeleton skeleton = new Skeleton(100, 10,200);
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
          System.out.println("The skeleton lunges and stabs you in the back");
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
          break;

        case "look":
          System.out.println();
          lookedAround = true;
          if(itemsPickedUp < 1) {
            System.out.println("A health potion sits on the shelf");
          } else {
            System.out.println("There is an empty shelf across the room");
          }

          skeleton.attack(player);
          break;

        case "pickup":
          System.out.println();
          if(lookedAround && itemsPickedUp < 1) {
            System.out.println("You pickup the health potion");
            player.addItem("health_potion");
            itemsPickedUp += 1;
          } else {
            System.out.println("There is nothing to pickup");
          }
          skeleton.attack(player);
          break;

        default:
          System.out.println("That is not a command");
          break;
      }
      System.out.println();

      System.out.println("HP: " + player.getHp());

      if(skeleton.getHp() <= 0) {
        completed = true;
        fighting = false;
        break;
      }
      if(player.getHp() <= 0) {
        fighting = false;
        break;
      }
    }

    keyboard.close();

    if(completed) {
      System.out.println("You defeated the skeleton!");
      System.out.println("+200 POINTS");
      player.addScore(skeleton.getPointReward());
    } else {
      System.out.println("You died leaving your bones as a reminder to future adventurers");
    }
  }
}
