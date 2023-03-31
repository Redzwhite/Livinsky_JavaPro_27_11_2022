package org.example.homework27;

public class ArrayUtils {

    public static boolean checkArray(int[] arr) {
        boolean hasOne = false;
        boolean hasFour = false;
        for (int j : arr) {
            if (j == 1) {
                hasOne = true;
            } else if (j == 4) {
                hasFour = true;
            } else {
                return false;
            }
        }
        return hasOne && hasFour;
    }

    public static int[] extractAfterLastFour(int[] array) {
        int lastIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                lastIndex = i;
            }
        }

        if (lastIndex == -1) {
            throw new RuntimeException("Массив не содержит четверок");
        }

        int[] result = new int[array.length - lastIndex - 1];
        System.arraycopy(array, lastIndex + 1, result, 0, result.length);
        return result;
    }
}
