import java.util.Scanner;

public class Dungeon3 extends Floor{

  public void run(Player player, Scanner keyboard) {
    boolean fighting = true;
    String command = "";
    Orc orc = new Orc(100, 15,1000);

    displayLevelInformation();
    System.out.println();
    System.out.println("A orc appears!");

    while(fighting) {
      System.out.println("Commands: run   use_item   show_items   look   pickup   help");
      System.out.print("What would you like to do?: ");
      do {
        command = keyboard.next();
      } while (command.equals(""));

      switch(command) {
        case "run":
          System.out.println("You're too deep in the dungeon to run now. You have to kill the orc!");
          break;

        case "use_item":
          player.displayInventory();
          System.out.print("What item would you like to use?: ");
          String item = keyboard.next();
          if(player.hasItem(item)) {
            useItem(player, orc, item);
          } else {
            System.out.println("You don't have that item");
          }
          break;

        case "show_items":
          player.displayInventory();
          break;

        case "look":
          System.out.println("It's just you and the scary orc");
          break;

        case "pickup":
          System.out.println("There is nothing to pickup");
          break;

        case "help":
          System.out.println("info:");
          System.out.println("Run: It's all or nothing. Running is not an option");
          System.out.println("use_item: allows you to use items you have found");
          System.out.println("show_item: allows you to check the items you have found");
          System.out.println("look: searches the room for anything of use (does not pick up the item)");
          System.out.println("pickup: picks up items you have found in the room (must use look before picking an item up)");
        break;

        default:
          System.out.println("That is not a command");
          break;
      }
      System.out.println("orc:" + orc);
      System.out.println("==============================");
      System.out.println(player);
      System.out.println("==============================");

      if(orc.getHp() <= 0) {
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
      System.out.println("You defeated the orc!");
      System.out.println("+" + orc.getPointReward() + " POINTS");
      player.addScore(orc.getPointReward());
    } else if(player.isDead()) {
      System.out.println("You died leaving your bones as a reminder to future adventurers");
    }
  }

}
