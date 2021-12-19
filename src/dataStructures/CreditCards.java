package dataStructures;

import java.util.ArrayList;

public class CreditCards {
	private ArrayList<CreditCard> cards;

	public CreditCards() {
		cards = new ArrayList<CreditCard>();
	}

	public ArrayList<CreditCard> activeCards() {
		ArrayList<CreditCard> activeCards = new ArrayList<CreditCard>();
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getCreditCardStatus().equals(CreditCardStatus.ACTIVE)) {
				activeCards.add(cards.get(i));
			}
		}
		return activeCards;
	}

	public double totalBalance() {
		double totBalance = 0;
		for (int i = 0; i < cards.size(); i++) {
			totBalance += cards.get(i).getCurrentBalance();
		}
		return totBalance;
	}

	public double totalAvailCredit() {
		double totCredit = 0;
		for (int i = 0; i < cards.size(); i++) {
			totCredit += cards.get(i).getAvailCredit();
		}
		return totCredit;
	}

	public void addCard(CreditCard creditCard) {
		if (!cards.contains(creditCard)) {
			cards.add(creditCard);
		}
	}

	public void removeCard(CreditCard creditCard) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).equals(creditCard)) {
				cards.remove(i);
			}
		}
	}

	public CreditCard findCard(String id) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getCreditCardID().equals(id)) {
				return cards.get(i);
			}
		}
		return null;// check if right
	}

	public void addPurchase(CreditCard creditCard, Purchase purchase) {
		creditCard.addPurchase(purchase);
		// why do we need this?
	}

	public void addFee(CreditCard creditCard, Fee fee) {
		creditCard.addFee(fee);
	}

	public void addPayment(CreditCard creditCard, Payment payment) throws addPaymentException, cantPayException {
		creditCard.addPayment(payment);
	}

}
