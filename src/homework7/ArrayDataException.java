package homework7;

public class ArrayDataException extends RuntimeException{String myMessage;


    public ArrayDataException(String myMessage) {
        this.myMessage = myMessage;
    }

    @Override
    public void printStackTrace() {
        System.err.println(this.myMessage);
        super.printStackTrace();
    }

}
