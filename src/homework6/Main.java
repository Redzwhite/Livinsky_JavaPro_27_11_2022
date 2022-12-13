package homework6;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", " pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
            "potato"};

    public static void main(String[] args) {
        findSymbolOccurance("pop", 'p');
        findWordPosition("Coffee", "fee");
        stringReverse("Hello World");
        isPalindrome("abba");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String randomWord = words[random.nextInt(words.length)];
        System.out.println(" Guess a word " + randomWord);
        System.out.println(" Guess a word : ");
        String word = scanner.next().toLowerCase();
        int hintCharacter = 2;
        while (!randomWord.equals(word)) {
            StringBuilder stringBuilder = new StringBuilder(randomWord.substring(0, hintCharacter));
            System.out.println(stringBuilder.append("###############"));
            System.out.println(" Try again ! ");
            word = scanner.next().toLowerCase();
            if (hintCharacter + 2 <= randomWord.length()) {
                hintCharacter += 2;
            }
        }
        if (randomWord.equals(word)) {
            System.out.println("Correct! You won !!!");
        }
    }

    private static void findSymbolOccurance(String string, char ch) {
        int count = 0;
        for (char element : string.toCharArray()) {
            if (element == ch) count++;
        }
        System.out.println(count);
    }

    private static void findWordPosition(String source, String target) {
        boolean isContains = source.contains(target);
        if (isContains) {
            source.indexOf(target);
            System.out.println("Source: " + source + "\n" +
                    "Target: " + target + "\n" + "Result: " + source.indexOf(target));
        } else {
            System.out.println("Source: " + source + "\n" +
                    "Target: " + target + "\n" + "Result: " + -1);
        }
    }

    private static String stringReverse(String string) {
        StringBuilder sb = new StringBuilder(string);
        sb.reverse();
        System.out.println(sb);
        return sb.toString();
    }

    private static void isPalindrome(String string) {
        String reverse = "";
        int length = string.length();
        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + string.charAt(i);
        if (string.equals(reverse)) {
            System.out.println(true + ": Entered string/number: " + string + " is a palindrome.");
        } else {
            System.out.println(false + ": Entered string/number: " + string + " isn't a palindrome.");
        }
    }
}




