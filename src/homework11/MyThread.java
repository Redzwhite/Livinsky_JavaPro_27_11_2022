package homework11;

import static homework11.ValueCalculator.methodToValueCalc;

public class MyThread extends Thread {


    @Override
    public void run() {
        methodToValueCalc();

    }


}