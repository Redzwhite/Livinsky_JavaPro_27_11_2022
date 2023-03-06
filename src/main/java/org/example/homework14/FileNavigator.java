package org.example.homework14;

import java.util.*;

public class FileNavigator {
    public HashMap<String, List<FileData>> map;

    public FileNavigator() {
        this.map = new HashMap<>();
    }

    public void add(String path, FileData fileData) {
        if (path.equals(fileData.path)) {
            System.err.println("Object invalid key " + path + " different with file pass " + fileData.path);
            return;
        }
        List<FileData> data;
        if (this.map.containsKey(path)) {
            data = this.map.get(path);
            data.add(fileData);
        } else {
            data = Arrays.asList(fileData);
        }
        this.map.put(path, data);
    }

    public List<FileData> find(String path) {
        if (this.map.containsKey(path)) {
            return this.map.get(path);
        } else {
            System.err.println("Error.Key " + path + " not found");
            return null;
        }
    }

    public List<String> filterBySize(int size) {
        List<String> resultFileNameArray = new ArrayList<>();
        for (String key : this.map.keySet()) {
            List<FileData> vals = this.map.get(key);
            for (FileData v : vals) {
                if (v.size <= size) {
                    resultFileNameArray.add(v.name);
                }
            }
        }
        return resultFileNameArray;

    }

    public void remove(String key) {
        if (this.map.containsKey(key)) {
            this.map.remove(key);
        } else {
            System.err.println("Key " + key + " not exists");
        }
    }

    public List<String> sortBySize() {
        List<String> filesNames = new ArrayList<>();
        List<Integer> filesSizes = new ArrayList<>();
        this.map.forEach((key, value) -> {
            for (FileData v : value) {
                filesNames.add(v.name);
                filesSizes.add(v.size);
            }
        });
        List<Integer> copyFilesSizes = new ArrayList<>(filesSizes);
        Collections.sort(copyFilesSizes);
        List<String> result = new ArrayList<>();
        for (int c : copyFilesSizes) {
            int index = filesSizes.indexOf(c);
            result.add(filesNames.get(index));
        }
        return result;

    }
}
