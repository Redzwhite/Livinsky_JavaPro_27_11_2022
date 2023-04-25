package org.example.homework29;

public class Main {


    public static void main(String[] args) {
      CoffeeOrderBoard coffeeBoard = new CoffeeOrderBoard();
      coffeeBoard.add(12,"bob");
      coffeeBoard.add(663,"bob");
      coffeeBoard.add(33111,"bob");
      coffeeBoard.add(1111,"bob");
      coffeeBoard.add(1221,"bob");
      coffeeBoard.add(1111111,"bob");
      coffeeBoard.add(1441,"bob");
      coffeeBoard.add(122111,"bob");
      coffeeBoard.add(15521111,"bob");
      coffeeBoard.add(1111,"bob");
      coffeeBoard.deliver(1111);
      coffeeBoard.draw();
    }
}
