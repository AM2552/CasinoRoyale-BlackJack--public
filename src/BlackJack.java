package src;

public class BlackJack {

    public static void main(String[] args) {
        CardDeck deck = new CardDeck(1);
        CardDeck trash = new CardDeck();
        deck.shuffle();

        Hand testHand = new Hand();
        testHand.addCardFromDeck(deck);
        testHand.addCardFromDeck(deck);
        testHand.addCardFromDeck(deck);

        System.out.println(testHand);
        System.out.println(testHand.getSum());
        //System.out.println(trash.getTrash());

        //trash.addCardsToTrash(testHand.clearHand());
        testHand.clearWholeHand(trash);

        System.out.println(testHand.getSum());
        System.out.println(testHand);
        System.out.println(trash);


    }


}
