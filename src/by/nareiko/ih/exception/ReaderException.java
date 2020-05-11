package by.nareiko.ih.exception;

public class ReaderException extends Exception {
    public ReaderException(){
        super();
    }
    public ReaderException(String message){
        super(message);
    }
    public ReaderException(Exception e){
        super(e);
    }
    public ReaderException(String message, Exception e){
        super(message, e);
    }

}
