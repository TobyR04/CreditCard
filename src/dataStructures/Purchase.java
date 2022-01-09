package dataStructures;

public class Purchase extends Transaction {

	private PurchaseType purchaseType;
	private Vendor vendor;

	

	public Purchase(double amount, PurchaseType purchaseType, Vendor vendor) {
		super(TransactionType.PURCHASE, amount);
		this.purchaseType = purchaseType;
		this.vendor = vendor;


	}

	public PurchaseType getPurchaseType() {
		return purchaseType;
	}


	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Purchase type : " + purchaseType);
		str.append("\nAmount: " + getAmount());
		str.append("\n" + vendor);
		
		
		return str.toString();
	}
	
	

}
