package org.example.homework7;

public class ArraySizeException extends RuntimeException {

    String myMessage;

    public ArraySizeException(String myMessage) {
        this.myMessage = myMessage;
    }

    @Override
    public void printStackTrace() {
        System.err.println(this.myMessage);
        super.printStackTrace();
    }

}
