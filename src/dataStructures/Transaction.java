package dataStructures;

import java.time.LocalDate;

public class Transaction {

	private long transactionID;
	private long lastTransactionID = 0;
	private LocalDate transactionDate;
	private TransactionType transactionType;
	private double amount;

	public Transaction(TransactionType transactionType, double amount) {
		transactionID = lastTransactionID + 1;
		lastTransactionID = transactionID;
		transactionDate = LocalDate.now();
		this.transactionType = transactionType;
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public TransactionType getType() {
		return transactionType;
	}

}
