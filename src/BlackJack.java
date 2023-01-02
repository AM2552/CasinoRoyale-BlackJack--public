package src;

public class BlackJack {

    public static void main(String[] args) {
        CardDeck deck = new CardDeck(2);

        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);
    }
}
