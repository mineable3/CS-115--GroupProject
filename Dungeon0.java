import java.util.Scanner;

public class Dungeon0 extends Floor{

  public void run(Player player, Scanner keyboard) {

    boolean fighting = true;
    int timesLooked = 0;
    int itemsPickedUp = 0;
    String command = "";
    Slime slime = new Slime(20, 2,100);

    displayLevelInformation();
    System.out.println();
    System.out.println("A slime appears!");

    while(fighting) {
      System.out.println("Commands: run   use_item   show_items   look   pickup   help");
      System.out.print("What would you like to do?: ");
      do {
        command = keyboard.next();
      } while (command.equals(""));

      switch(command) {
        case "run":
          System.out.println();
          fighting = false;
          break;

        case "use_item":
          player.displayInventory();
          System.out.print("What item would you like to use?: ");
          String item = keyboard.next();
          if(player.hasItem(item)) {
            useItem(player, slime, item);
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
            System.out.println("A short sword is lying in the corner");
          } else if(itemsPickedUp == 1) {
            System.out.println("Behind the door lays a small shield");
          } else {
            System.out.println("Dust and cobwebs fill the corners of the room");
          }

          slime.attack(player);
          break;

        case "pickup":
          System.out.println();
          if(timesLooked >= 1 && itemsPickedUp == 0) {
            System.out.println("You pickup the short sword");
            player.addItem("short_sword");
            itemsPickedUp += 1;
          } else if(timesLooked >= 2 && itemsPickedUp == 1) {
            System.out.println("You pickup the small shield");
            System.out.println("The small shield blocks 5 incoming damage");
            player.addItem("small_shield (passive)");
            itemsPickedUp += 1;
          } else {
            System.out.println("There is nothing to pickup");
          }
          slime.attack(player);
          break;

          case "help":
            System.out.println(info:);
            System.out.println("Run: allows you to flee from battle");
            System.out.println("use_item: allows you to use items you have found");
            System.out.println("show_item: allows you to check the items you have found");
            System.out.println("look: searches the room for anything of use (does not pick up the item)");
            System.out.println("pickup: picks up items you have found in the room (must use look before picking an item up)");

        default:
          System.out.println("That is not a command");
          break;
      }
      System.out.println("Slime:" + slime);
      System.out.println("==============================");
      System.out.println(player);
      System.out.println("==============================");

      if(slime.getHp() <= 0) {
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
      System.out.println("You defeated the slime!");
      System.out.println("+" + slime.getPointReward() + " POINTS");
      player.addScore(slime.getPointReward());
    } else if(player.isDead()) {
      System.out.println("You died leaving your bones as a reminder to future adventurers");
    }
  }
}
