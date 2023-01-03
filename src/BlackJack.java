package src;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {

    private static ArrayList<Player> players = new ArrayList<>();

    public static void main(String[] args) {
        Player player1 = new Player("Alex", 2);
        Player player2 = new Player("Kat", 2);
        Dealer dealer = new Dealer("Dealer");

        Scanner scanner = new Scanner(System.in);

        players.add(player1);
        players.add(player2);

        CardDeck deck = new CardDeck(1);
        deck.shuffle();

        while(true) {
            for(int i = 0; i < players.size(); i++) {
                System.out.println("Möchtest du weiterspielen " + players.get(i).getName());
                // bei J -> hit
                // bei N -> setIsStanding(true)

                deck.addCardFromDeck(players.get(i).getHand()); //player objekt bzw. add für die liste aufrufen

                // setStanding oder hit- konsoleneingabe
            }

            boolean allStanding = true;
            for(int i = 0; i < players.size(); i++) {
                if(!players.get(i).getStanding()) {
                    allStanding = false;
                }
            }

            if(allStanding) {
                break;
            }
            // break ausführen wenn jeder spieler isStanding true hat, dh wenn er keine Karten mehr haben will oder summe >=  21 -> isStanding auf true setzen
        }

        for(int i = 0; i < players.size(); i++) {
//            players.get(i).getVictor();
        }

        Hand testHand = new Hand();
        deck.addCardFromDeck(testHand);
        deck.addCardFromDeck(testHand);
        deck.addCardFromDeck(testHand);

        System.out.println(testHand);
        System.out.println(testHand.getSum());

        deck.addCardsToTrash(testHand.getHand());
        testHand.clearHand();
        System.out.println(testHand);
        System.out.println(testHand.getSum());

    }


}
