package src;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;
    private int sum;


    public Hand(ArrayList<Card> hand, int sum){
        this.hand = hand;
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void addCardFromDeck(CardDeck deck) {
        Card newCard = deck.drawCard();
        setSum(sum+newCard.getValue());
        hand.add(newCard);
    }

    public ArrayList<Card> clearHand() {
        ArrayList<Card> trash = new ArrayList<>(this.hand);
        this.hand.clear();
        this.sum = 0;
        return trash;
    }

    public void clearWholeHand(CardDeck trash) {
        trash.addCardsToTrash(hand);
        hand.clear();
        this.sum = 0;
    }


    @Override
    public String toString() {
        String cardsInHand = "";
        for(Card card : hand){
            cardsInHand += card + " - ";
        }
        return cardsInHand;
    }
}
