package src;

import java.util.ArrayList;
import src.CardDeck;

public class Hand {

    private ArrayList<Card> hand;
    private int sum;


    public Hand(){
        hand = new ArrayList<>();
        sum = 0;
    }

    public int getSum() {
        return sum;
    }

    public int getHandSize() {
        return this.hand.size();
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

//    Programmlogik gehört nicht in Model Klassen rein daher:
    public void clearHand() {
        this.hand = new ArrayList<>();
        this.setSum(0);
    }
//    Ausführung der Logik dann in Game / BlackJack


    @Override
    public String toString() {
        String cardsInHand = "";
        int counter = hand.size();
        for(Card card : hand){
            if (counter <= 1){
            cardsInHand += card;
            } else {
                cardsInHand += card + " - ";
            }
            counter --;
        }
        return cardsInHand;
    }

    public void addCardToHand(Card newCard) {
        this.hand.add(newCard);
    }
}
