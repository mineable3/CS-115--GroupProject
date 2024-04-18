public class Player {

  private int hp, score;
  private String[] inventory;

  public Player(int hp) {
    this.hp = hp;
    inventory = new String[0];
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public void addDamage(int damage)
  {
    if(hasItem("large_shield (passive)")) {
      damage = damage - 10;
      if(damage < 0) {
        damage = 0;
      }
    } else if(hasItem("small_shield (passive)")) {
      damage = damage - 5;
      if(damage < 0) {
        damage = 0;
      }
    }
    hp -= damage;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void addScore(int score) {
    this.score += score;
  }

  public String[] getInventory() {
    return inventory;
  }

  public void displayInventory() {
    for(String item : inventory) {
      System.out.print(item + "\t");
    }
    System.out.println();
  }

  public boolean hasItem(String target) {
    for(String item : inventory) {
      if(target.equals(item)) {
        return true;
      }
    }
    return false;
  }

  public void addItem(String loot) {
    String[] tempInventory = new String[inventory.length+1];

    for(int i = 0; i < inventory.length; i++) {
      tempInventory[i] = inventory[i];
    }

    tempInventory[tempInventory.length - 1] = loot;
    inventory = tempInventory;
  }

  public void removeItem(String target) {
    String[] tempInventory = new String[inventory.length-1];
    boolean removedItem = false;

    for(int i = 0; i < inventory.length; i++) {
      if(!target.equals(inventory[i]) && !removedItem) {
        tempInventory[i] = inventory[i];
      } else if(!target.equals(inventory[i]) && removedItem) {
        tempInventory[i - 1] = inventory[i - 1];
      } else if(target.equals(inventory[i]) && !removedItem){
        removedItem = true;
      }
    }
    inventory = tempInventory;
  }

  public String toString() {
    return "HP: " + hp + " Points: " + score;
  }

  public boolean isDead() {
    if(hp <= 0) {
      return true;
    } else {
      return false;
    }
  }
}
