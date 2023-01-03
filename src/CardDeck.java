package src;

import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CardDeck {

    private ArrayList<Card> deck;
    private ArrayList<Card> trash;

    public CardDeck() {
        this.trash = new ArrayList<>();
    }

    public CardDeck(int numberOfDecks) {
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

    public String toString(){
        String output = "";
        int counter = 1;
        for(Card card: this.deck){
            output += "card" + counter + " ";
            output += card;
            output += "\n";
            counter++;
        }


        return output;
    }



}

