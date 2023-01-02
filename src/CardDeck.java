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

    public CardDeck(int decks) {
        deck = new ArrayList<>();
        for (int i = 0; i < decks; i++)
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
        ArrayList<Card> shuffled = new ArrayList<>();
        int range = this.deck.size();
        for (int i = 0; i < range; i++) {
            int index = (int) (Math.random()*deck.size());
            shuffled.add(this.deck.get(index));
            deck.remove(index);
        }
        this.deck.addAll(shuffled);
    }

    public String toString(){
        String output = "";
        int counter = 1;
        for(Card card: deck){
            output += "card" + counter + " ";
            output += card;
            output += "\n";
            counter++;
        }
        return output;
    }



}

