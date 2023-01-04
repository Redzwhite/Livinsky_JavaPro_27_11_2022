package homework11;

public class MyThread extends Thread {
    public float[] newArray;

    MyThread(String name, float[] arr) {
        super(name);
        this.newArray = arr;
    }

    @Override
    public void run() {
        calculate();
    }

    private void calculate() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < this.newArray.length; ++i) {
            this.newArray[i] = (float) (this.newArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
        System.out.println("Thread: " + this.getName() + " finish the job.");
//        System.out.println("Result: " + Arrays.toString(this.newArray) + " thread name " + this.getName());
        long end = System.currentTimeMillis();
        long timeRunning = end - start;
        System.out.println("Current " + this.getName() + " running time in milliseconds = " + timeRunning);

    }
}