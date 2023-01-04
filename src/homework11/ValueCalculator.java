package homework11;

import java.util.Arrays;

public class ValueCalculator {

    static int[] str = new int[10];
    static int size = str.length;
    static int halfSize = (size + 1) / 2;


    public static void main(String[] args) {

        MyThread thread = new MyThread();
        thread.start();

        MyThread thread2 = new MyThread();
        thread2.start();
    }

    public static void methodToValueCalc() {
        long start = System.currentTimeMillis();
        System.out.println("Current start time in milliseconds = " + start);

        Arrays.fill(str, 50);
        System.out.println(Arrays.toString(str));

        int[] a = Arrays.copyOfRange(str, 0, halfSize);
        int[] b = Arrays.copyOfRange(str, halfSize, str.length);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        for (int i = 0; i < a.length; ++i) {
            a[i] = (byte) (a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        for (int i = 0; i < b.length; ++i) {
            b[i] = (byte) (a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        int fal = a.length;
        int sal = b.length;
        int[] result = new int[fal + sal];
        System.arraycopy(a, 0, result, 0, fal);
        System.arraycopy(b, 0, result, fal, sal);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(result));
        long end = System.currentTimeMillis();
        System.out.println("Current end time in milliseconds = " + end);
        long timeRunning = end - start;
        System.out.println("Current running time in milliseconds = " + timeRunning);

    }
}
