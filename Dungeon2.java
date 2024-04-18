import java.util.Random;
import java.util.Scanner;

public class Dungeon2 extends Floor{

  public void run(Player player, Scanner keyboard) {
    boolean fighting = true;
    int timesLooked = 0;
    int itemsPickedUp = 0;
    String command = "";
    Zombie zombie = new Zombie(50, 10,500);
    Random generator = new Random();
    int rng = 0;

    displayLevelInformation();
    System.out.println();
    System.out.println("A zombie appears!");

    while(fighting) {
      System.out.println("Commands: run   use_item   show_items   look   pickup   help");
      System.out.print("What would you like to do?: ");
      do {
        command = keyboard.next();
      } while (command.equals(""));

      switch(command) {
        case "run":
          rng = generator.nextInt(4);
          if(rng == 1)
          {
            System.out.println("\nYou ran away");
            fighting = false;
          }else{
            System.out.println("\nYou fail to run away");
            zombie.attack(player);
          }
          break;

        case "use_item":
          player.displayInventory();
          System.out.print("What item would you like to use?: ");
          String item = keyboard.next();
          if(player.hasItem(item)) {
            useItem(player, zombie, item);
          } else {
            System.out.println("You don't have that item");
          }
          break;

        case "show_items":
          player.displayInventory();
          break;

        case "look":
          System.out.println();
          timesLooked += 1;
          if(itemsPickedUp == 0) {
            System.out.println("A sword has been left in the zombie's chest");
          } else if(itemsPickedUp == 1) {
            System.out.println("Attached to the ceiling is a large shield");
          } else {
            System.out.println("Blood covers the floor");
          }

          zombie.attack(player);
          break;

      case "pickup":
        System.out.println();
        if(timesLooked >= 1 && itemsPickedUp == 0) {
          System.out.println("You pickup the long sword");
          player.addItem("long_sword");
          itemsPickedUp += 1;
        } else if(timesLooked >= 2 && itemsPickedUp == 1) {
          System.out.println("You pickup the large shield");
          System.out.println("The large shield blocks 10 incoming damage");
          player.addItem("large_shield (passive)");
          itemsPickedUp += 1;
        } else {
          System.out.println("There is nothing to pickup");
        }
        zombie.attack(player);
        break;

        case "help":
          System.out.println("info:");
          System.out.println("Run: allows you to flee from battle");
          System.out.println("use_item: allows you to use items you have found");
          System.out.println("show_item: allows you to check the items you have found");
          System.out.println("look: searches the room for anything of use (does not pick up the item)");
          System.out.println("pickup: picks up items you have found in the room (must use look before picking an item up)");
        break;

        default:
          System.out.println("That is not a command");
          break;
      }
      System.out.println("zombie:" + zombie);
      System.out.println("==============================");
      System.out.println(player);
      System.out.println("==============================");

      if(zombie.getHp() <= 0) {
        completed = true;
        fighting = false;
        break;
      }
      if(player.isDead()) {
        fighting = false;
        break;
      }
    }

    if(completed) {
      System.out.println("You defeated the zombie!");
      System.out.println("+" + zombie.getPointReward() + " POINTS");
      player.addScore(zombie.getPointReward());
    } else if(player.isDead()) {
      System.out.println("You died leaving your bones as a reminder to future adventurers");
    }
  }

}
