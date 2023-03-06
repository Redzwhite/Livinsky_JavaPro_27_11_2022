package org.example.homework13.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PhoneBook {
    static List<Record> multipleRecords = new ArrayList<>();

    public static void main(String[] args) {
        add(new Record("Anton", "50505050"));
        add(new Record("Anton", "50s505050"));
        System.out.println(find("Anton",false));
        System.out.println("*************************");
        System.out.println(findAll("Anton"));

    }

    public static void add(Record newRecord) {
        multipleRecords.add(newRecord);
    }

    public static Object find(String personName, boolean findMany) {
        ArrayList<HashMap<String,String>> listPersonNumbers = new ArrayList<HashMap<String, String>>();
        for (Record multipleRecord : multipleRecords) {
            if (multipleRecord.name.contains(personName)) {
                if (findMany) {
                    HashMap<String, String> personNumbers = new HashMap<String, String>();
                    personNumbers.put(multipleRecord.name, multipleRecord.phone);
                    listPersonNumbers.add(personNumbers);
                } else {
                    HashMap<String, String> user = new HashMap<String, String>();
                    user.put(multipleRecord.name, multipleRecord.phone);
                    return user;
                }
            }
        }
        if (listPersonNumbers.size() > 0) {
            return listPersonNumbers.toString();
        }
        return null;
    }

    public static Object findAll(String personName) {
        return find(personName, true);
    }
}


