package dataStructures;

public class Purchase  extends Transaction{

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

	public int compareTo(Purchase mostRecentPurchase) {//do I need this?????
		// TODO Auto-generated method stub
		return 0;
	}
}
