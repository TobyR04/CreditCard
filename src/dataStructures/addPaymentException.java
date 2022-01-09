package dataStructures;

public class addPaymentException extends Exception{
	
	public addPaymentException(String message) {
		super(message);
	}
	
	public addPaymentException() {
		super("You are paying too much.");
	}
}
