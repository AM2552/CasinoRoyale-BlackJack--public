package src;

import java.util.ArrayList;

public class CardDeck {

    private ArrayList<Card> deck;
    private ArrayList<Card> trash;

    /* redundant constructor
    public CardDeck() {
        deck = new ArrayList<Card>();
    }
    */

    public CardDeck() {
        deck = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Card drawCard(CardDeck deck) {
        return deck.deck.get(0);
    }



    public void shuffle() {
        ArrayList<Card> temp = new ArrayList<>(this.deck);
        ArrayList<Card> shuffled = new ArrayList<>();
        int range = 51;
        for (Card card : temp) {
            int index = (int) (Math.random()*range);
            shuffled.add(this.deck.get(index));
            deck.remove(index);
            range--;
        }
        this.deck.addAll(shuffled);
    }

    public String toString(){
        String output = "";
        for(Card card: deck){
            output += card;
            output += "\n";
        }
        return output;
    }



}

