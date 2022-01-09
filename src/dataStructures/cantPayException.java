package dataStructures;

public class cantPayException extends Exception {

	public cantPayException(String message) {
		super(message);
	}

	public cantPayException() {
		super("You don't have enough money in your bank account.");
	}

}
