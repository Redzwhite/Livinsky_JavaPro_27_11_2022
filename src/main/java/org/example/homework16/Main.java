package org.example.homework16;

import java.util.Arrays;
import java.util.Random;

public class Main {
    static int[] arr = fillTheArrayWithRandom(100000);

    public static void main(String[] args) {
        int low = 0;
        int high = arr.length - 1;

        int[] arr1 = Arrays.copyOf(arr, arr.length);
        long getTimeStart1 = System.currentTimeMillis();
        quickSort(arr1, low, high);
        long getTimeFinish1 = System.currentTimeMillis();
        System.out.println("Quick sorting time running = " + (getTimeFinish1 - getTimeStart1) + "ms");
        System.out.println("Sorted  : " + Arrays.toString(arr1));

        int[] arr2 = Arrays.copyOf(arr, arr.length);
        long getTimeStart2 = System.currentTimeMillis();
        cocktailSort(arr2);
        long getTimeFinish2 = System.currentTimeMillis();
        System.out.println("Cocktail sorting time running = " + (getTimeFinish2 - getTimeStart2) + "ms");
        System.out.println("Sorted  : " + Arrays.toString(arr2));
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int opora = array[middle];
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }
            while (array[j] > opora) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    private static int[] fillTheArrayWithRandom(int length) {
        int minVal = 0;
        int maxVal = 100;
        int[] arr = new int[length];
        Random rand = new Random();
        for (int i = 0; i < length; ++i) {
            arr[i] = rand.nextInt(maxVal - minVal) + minVal;
        }
        return arr;
    }

    public static void cocktailSort(int[] arr) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i <= arr.length - 2; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
