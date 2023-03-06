package org.example.homework14;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add("abc",new FileData("a",5,"abc"));
        fileNavigator.add("abe",new FileData("b",3,"abe"));
        fileNavigator.add("ab7",new FileData("d",6,"ab7"));
        fileNavigator.add("ab2",new FileData("d",6,"ab1"));
        System.out.println(fileNavigator.find("abc"));
        System.out.println(fileNavigator.filterBySize(5));
        System.out.println(fileNavigator.find("abc"));
        fileNavigator.remove("acc");
        System.out.println(fileNavigator.find("abc"));
        System.out.println(fileNavigator.sortBySize());

    }
}
