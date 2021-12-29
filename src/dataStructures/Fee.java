package dataStructures;

public class Fee extends Transaction{

	private FeeType feeType;
	
	
	public Fee(double amount, FeeType feeType) {
		super(TransactionType.FEE,amount);
		this.feeType=feeType;
	}
	
	public FeeType getFeeType() {//can I do this??
		return feeType;
	}
}
