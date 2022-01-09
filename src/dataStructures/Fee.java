package dataStructures;

public class Fee extends Transaction {

	private FeeType feeType;

	public Fee(double amount, FeeType feeType) {
		super(TransactionType.FEE, amount);
		this.feeType = feeType;
	}

	public FeeType getFeeType() {// can I do this??
		return feeType;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Fee type : " + feeType);
		str.append("\nAmount: " + getAmount());

		return str.toString();
	}
}
