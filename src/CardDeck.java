package src;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CardDeck {

    private ArrayList<Card> deck;
    private ArrayList<Card> trash;


    public CardDeck() {
        deck = new ArrayList<Card>();
    }

    public CardDeck(boolean generate) {
        deck = new ArrayList<Card>();
        if(generate) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    deck.add(new Card(rank, suit));
                }
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Card drawCard(CardDeck deck) {
        return deck.deck.get(0);
    }



    public CardDeck shuffle() {
        ArrayList<Card> temp = new ArrayList<>();
        for (Card card : deck) {
            temp.add(deck.get(Math.random(52)));
        }

        return null;
    }


    public String toString(){
        String output = "";
        for(Card card: deck){
            output += card;
            output += "\n";
        }
        return output;
    }

    //ToDo deckShuffle



}

