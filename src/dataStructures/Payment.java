package dataStructures;

public class Payment extends Transaction {
	private PaymentType paymentType;
	private BankAccount account;

	public Payment(double amount, PaymentType paymentType, BankAccount account) {
		super(TransactionType.PAYMENT, amount);
		this.paymentType = paymentType;
		this.account = account;

	}

	public void withdrawal(double amount) throws cantPayException {
		try {
			boolean pay = account.withdrawal(amount);
			if (pay == false) {
				throw new cantPayException();
			}
		} catch (cantPayException e) {
			e.getMessage();
		}
	}


}
