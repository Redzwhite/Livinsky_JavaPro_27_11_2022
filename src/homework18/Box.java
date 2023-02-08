package homework18;

import java.util.ArrayList;
import java.util.List;

public class Box {

    List<Fruit> box = new ArrayList<>();


    boolean addToBox(Fruit newFruit) {
        if (box.size() >= 1) {
            Fruit firstElement = box.get(0);
            if (newFruit.getClass().getName().equals(firstElement.getClass().getName())) {
                box.add(newFruit);
                return true;
            } else {
                System.err.println("Wrong type of fruits. " + newFruit.getClass().getSimpleName() +
                        ", type of fruits in box is : " + firstElement.getClass().getSimpleName());
                return false;
            }
        } else {
            box.add(newFruit);
            return true;
        }
    }

    void addManyToBox(Fruit[] listFruits) {
        for (Fruit item : listFruits) {
            addToBox(item);
        }
    }

    float getWeight() {
        if (box.size() > 0) {
            Fruit firstElement = box.get(0);
            System.out.println("This box contains " + firstElement.getClass().getSimpleName() +
                    ", weight of box is: " + box.size() * firstElement.weight);
            return (float) (box.size() * firstElement.weight);
        } else {
            System.err.println("This box is empty");
            return 0.0F;
        }
    }

    boolean compare(Box comparedBox) {
        System.out.println(this.getWeight() == comparedBox.getWeight());
        return this.getWeight() == comparedBox.getWeight();
    }

    void merge(Box fromBox) {
        List<Fruit> fromBoxFruitList = new ArrayList<>(fromBox.box);
        System.out.println(fromBoxFruitList.size());
        for (Fruit item : fromBoxFruitList) {
          boolean a = addToBox(item);
          System.out.println(a);
          if( a ){
              fromBox.box.remove(item);
          }
        }
    }
}
