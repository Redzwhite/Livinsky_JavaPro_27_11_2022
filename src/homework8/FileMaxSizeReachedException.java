package homework8;

public class FileMaxSizeReachedException extends RuntimeException{
    String myMessage;

    public FileMaxSizeReachedException(String myMessage) {
        this.myMessage = myMessage;
    }

    @Override
    public void printStackTrace() {
        System.err.println(this.myMessage);
        super.printStackTrace();
    }
}
