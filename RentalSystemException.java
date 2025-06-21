public class RentalSystemException extends Exception{
    public RentalSystemException (String message){
        super(message);
    }

    static class EmailAlreadyExists extends RentalSystemException{
    public EmailAlreadyExists(){
        super("Email already exists.");
        }
    }

    static class  InvalidFormatEmail extends RentalSystemException{
    public InvalidFormatEmail(){
        super("Email must contain '@'.");
        }
    }
}