package homework11;

import java.util.Arrays;

public class ValueCalculator {

    static float[] baseArray = new float[1000000];
    static int size = baseArray.length;
    static int halfSize = (size + 1) / 2;

    public static void main(String[] args) {
        methodToValueCalc();

    }

    public static void methodToValueCalc() {
        long start = System.currentTimeMillis();
        Arrays.fill(baseArray, 50);
        float[] fal = Arrays.copyOfRange(baseArray, 0, halfSize);
        float[] sal = Arrays.copyOfRange(baseArray, halfSize, baseArray.length);

        System.arraycopy(fal, 0, baseArray, 0, fal.length);
        System.arraycopy(sal, 0, baseArray, fal.length, sal.length);
        MyThread thread = new MyThread("a", fal);
        thread.start();

        MyThread thread2 = new MyThread("b", sal);
        thread2.start();

        float[] result = new float[baseArray.length];
        System.arraycopy(fal, 0, result, 0, fal.length);
        System.arraycopy(sal, 0, result, fal.length, sal.length);
        long end = System.currentTimeMillis();
        long timeRunning = end - start;
        System.out.println("Current running time in milliseconds = " + timeRunning);
    }
}

