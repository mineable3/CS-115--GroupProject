import java.util.Scanner;

public class Dungeon0 extends Floor{

  public void run(Player player) {

    boolean fighting = true;
    int timesLooked = 0;
    int itemsPickedUp = 0;
    String command = "";
    Slime slime = new Slime(20, 2,100);
    Scanner keyboard = new Scanner(System.in);

    displayLevelInformation();
    System.out.println();
    System.out.println("A slime appears!");

    while(fighting) {
      System.out.println("==============================");
      System.out.println("Commands: run   use_item   show_items   look   pickup");
      System.out.print("What would you like to do?: ");
      command = keyboard.next();

      switch(command) {
        case "run":
          System.out.println();
          System.out.println("You slip on the slime and fall hitting your head");
          fighting = false;
          break;

        case "use_item":
          System.out.println();
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
          if(timesLooked == 1 && itemsPickedUp == 0) {
            System.out.println("You pickup the short sword");
            player.addItem("short_sword");
            itemsPickedUp += 1;
          } else if(timesLooked == 2 && itemsPickedUp == 1) {
            System.out.println("You pickup the small shield");
            System.out.println("The small shield blocks 5 incoming damage");
            player.addItem("small_shield (passive)");
            itemsPickedUp += 1;
          } else {
            System.out.println("There is nothing to pickup");
          }
          slime.attack(player);
          break;

        default:
          System.out.println("That is not a command");
          break;
      }
      System.out.println();

      System.out.println("HP: " + player.getHp());

      if(slime.getHp() <= 0) {
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
      System.out.println("You defeated the slime!");
      System.out.println("+100 POINTS");
      player.addScore(slime.getPointReward());
    } else {
      System.out.println("You died leaving your bones as a reminder to future adventurers");
    }
  }

}
