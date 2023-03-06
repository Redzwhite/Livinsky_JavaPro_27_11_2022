package org.example.homework13;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>(Arrays.asList("Cat", "Dog", "Cat", "Dog",
                "Human", "Monkey", "Human"));

        countOccurance(list, "Monkey");
        List<String> a = toList(list);
        System.out.println(a.getClass().getName());

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(5);
        numbers.add(5);

        System.out.println(findUnique(numbers));
        calcOccurance(list);
        findOccurrence(list);

    }


    public static void countOccurance(List<String> arrayList, String string) {
        System.out.println(Collections.frequency(arrayList,string));
    }

    public static List<String> toList(ArrayList<String> array) {
        System.out.println(array.getClass().getName());
        return array.stream().toList();
    }

    public static Set<Integer> findUnique(List<Integer> array) {
        return array.stream().collect(Collectors.toSet());
    }

    public static void calcOccurance(List<String> arrayList) {
        Set<String> set = arrayList.stream().collect(Collectors.toSet());
        for (String i : set) {
            int count = Collections.frequency(arrayList, i);
            System.out.println(i + ": " + count);
        }
    }

    public static void findOccurrence(List<String> arrayList) {
        ArrayList<Hashtable> asd = new ArrayList<Hashtable>();
        Set<String> set = arrayList.stream().collect(Collectors.toSet());
        for (String i : set) {
            Hashtable<Object, Object> map3 = new Hashtable<>();
            Hashtable<String, Integer> occurrence = new Hashtable<>();
            Hashtable<String, String> name = new Hashtable<>();
            occurrence.put("occurrence", Collections.frequency(arrayList, i));
            name.put("name", i);
            map3.putAll(name);
            map3.putAll(occurrence);
            asd.add(map3);
        }
        System.out.println(asd.toString().replace("=",":"));

    }
}






