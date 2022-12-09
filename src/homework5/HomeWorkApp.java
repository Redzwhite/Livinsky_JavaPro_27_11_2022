package homework5;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        numberComparison20to10Boolean();
        positiveOrNegativeNumber();
        positiveOrNegativeNumberReturnTrueOrFalse();
        stringAndNumber("Hello World ", 5);
        leapYearOrNot(2000);

    }

    private static void printThreeWords() {
        System.out.println("""
                Orange
                Banana
                Apple""");
    }

    private static void checkSumSign() {
        int a = (int) (Math.random() * (600 + 1)) - 200;
        int b = (int) (Math.random() * (600 + 1)) - 200;
        int c = a + b;
        if (c >= 0) {
            System.out.println(c + ": Сума позитивна");
        } else {
            System.out.println(c + ": Сума негативна");
        }
    }

    private static void printColor() {
        int value = (int) (Math.random() * 140);
        if (value <= 0) {
            System.out.println("Червоний");
        } else if (value <= 100) {
            System.out.println("Жовтий");
        } else {
            System.out.println("Зелений");
        }
    }

    private static void compareNumbers() {
        int a = (int) (Math.random() * (600 + 1)) - 200;
        int b = (int) (Math.random() * (600 + 1)) - 200;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    private static void numberComparison20to10Boolean() {
        int a = (int) (Math.random() * 20);
        int b = (int) (Math.random() * 20);
        int c = a + b;
        System.out.println(c >= 10 && c <= 20);
    }

    private static void positiveOrNegativeNumber() {
        int min = -10;
        int max = 100;
        int a = min + (int) (Math.random() * max);
        if (a >= 0) {
            System.out.println(a + ": додатнє число");
        } else {
            System.out.println(a + ": від'ємне число");
        }
    }

    private static void positiveOrNegativeNumberReturnTrueOrFalse() {
        int min = -100;
        int max = 1;
        int a = min + (int) (Math.random() * max);
        if (a < 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    private static void stringAndNumber(String string, int number) {
        var s = string.repeat(number);
        System.out.println(s);
    }

    public static void leapYearOrNot(int year) {
        boolean leap;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            } else
                leap = true;
        } else
            leap = false;
        if (leap)
            System.out.println(year + " is a leap year.");
        else
            System.out.println(year + " is not a leap year.");

    }
}

