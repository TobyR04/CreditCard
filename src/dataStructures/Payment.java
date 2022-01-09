package dataStructures;

public class Payment extends Transaction {
	private PaymentType paymentType;
	private BankAccount account;
	private int counter;

	public Payment(double amount, PaymentType paymentType, BankAccount account,int counter) {
		super(TransactionType.PAYMENT, amount);
		this.paymentType = paymentType;
		this.account = account;
		this.counter=counter;

	}

	public boolean withdrawal(double amount) throws cantPayException {
		try {
			boolean pay = account.withdrawal(amount);
			if (pay == false) {
				throw new cantPayException();
			}
		} catch (cantPayException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	
	public int getCounter() {
		return counter;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Payment type: " + paymentType);
		str.append("\nAmount: " + getAmount());
		return str.toString();
	}


}
