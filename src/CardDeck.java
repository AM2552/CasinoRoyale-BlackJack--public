package src;

import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CardDeck {

    private ArrayList<Card> deck;

    public CardDeck() {
        this.deck = new ArrayList<>();
        for (int i = 0; i < numberOfDecks; i++)
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    deck.add(new Card(rank, suit));
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<Card> getTrash() {
        return trash;
    }

    public void addCardsToTrash(ArrayList<Card> cards){
        this.trash.addAll(cards);
    }


    public Card drawCard() {
        Card nextCard = this.deck.get(0);
        this.deck.remove(0);
        return nextCard;
    }

//    Logik nach Deck verschoben -> "Seperation of Concern"
//    Model Klassen (Hand) sollten so wenig Logik wie möglich enthalten,
    public void addCardFromDeck(Hand hand) {
        Card newCard = this.drawCard();
        hand.setSum(hand.getSum()+newCard.getValue());
        hand.addCardToHand(newCard);
    }

    public void shuffle() {
        ArrayList<Card> shuffled = new ArrayList<>();
        int range = this.deck.size();
        for (int i = 0; i < range; i++) {
            int index = (int) (Math.random()*deck.size());
            shuffled.add(this.deck.get(index));
            this.deck.remove(index);
        }
        this.deck.addAll(shuffled);
    }

    @Override
    public String toString(){
        String output = "";
        int counter = 1;
        for(Card card: this.deck){
            output += "card" + counter + " ";
            output += card;
            output += "\n";
            counter++;
        }
        for(Card card: this.trash){
            output += "card" + counter + " ";
            output += card;
            output += "\n";
            counter++;
        }


        return output;
    }



}

