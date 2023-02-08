package homework18;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<String> toList(String str[]) {
        List<String> list = Arrays.asList(str);
        System.out.println("The list is: " + list);
        return list;
    }

    public static void main(String[] args) {
        String[] array1 = new String[]{"1", "2", "3"};
        List<String> list1 = toList(array1);

        Box box = new Box();
        Fruit[] fruitbox = new Fruit[]{
                new Orange(1, 1.5),
                new Orange(1, 1.5),
                new Apple(1, 1.0),
                new Orange(1, 1.5)
        };
        box.addToBox(new Orange(1, 1.5));
        box.addToBox(new Orange(1, 1.5));
        box.addManyToBox(fruitbox);
        box.getWeight();
        Box appleBox = new Box();
        Box orangeBox = new Box();
        Fruit[] appleFruitBox = new Fruit[]{
                new Apple(1, 1.0),
                new Apple(1, 1.0),
                new Apple(1, 1.0)
        };
        appleBox.addManyToBox(appleFruitBox);
        Fruit[] orangeFruitBox = new Fruit[]{
                new Orange(1, 1.5),
                new Orange(1, 1.5),
                new Orange(1, 1.5)
        };
        orangeBox.addManyToBox(orangeFruitBox);

        System.out.println(orangeBox.compare(appleBox));
        Fruit[] orangeFruitBox2 = new Fruit[]{
                new Orange(1, 1.5),
                new Orange(1, 1.5),
                new Orange(1, 1.5)
        };
        orangeBox.merge(appleBox);
        Box orangeBox2 = new Box();
        orangeBox2.addManyToBox(orangeFruitBox2);
        orangeBox.getWeight();
        orangeBox.merge(orangeBox2);
        orangeBox.getWeight();
        orangeBox2.getWeight();

    }
}
