package src;

import java.util.*;

public class BlackJack {

    private static ArrayList<Player> players = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // **Game Start**
        System.out.print("Welcome to Black Jack!\n" +
                "How many players will join this game? Please type in a number from 1-10: ");
        Player[] player = new Player[input.nextInt()];
        for (int i = 0; i < player.length; i++) {
            System.out.print("Please enter your name Player" + (i + 1) + ": ");
            String name = input.next();
            System.out.print("Please type in your starting balance: ");

            boolean isValid = false;
            while (!isValid) {
                if (input.hasNextDouble()) {
                    double balance = input.nextDouble();
                    player[i] = new Player(name, balance);
                    isValid = true;
                } else {
                    input.next();
                    System.out.print("Please enter a valid number for your starting balance: ");
                }
            }
        }

        Dealer dealer = new Dealer("Dealer");
        players.addAll(List.of(player));

        System.out.println("Das spiel Startet mit folgenden Spielern: ");
        System.out.println(players);


        CardDeck deck = new CardDeck();
        deck.shuffle();

//
//      1. Enter your Bet
        for (Player p : players) {
            System.out.print("Place your bet "+p.getName()+" or type 0 to skip this round: ");
            double currentBet = input.nextDouble();
            if (currentBet == 0) {
                p.setStanding(true);
            } else {
                p.setBet(currentBet);
                p.setBalance(p.getBalance() - currentBet);
            }
            //erste Karte

//            karten austeilen
        }

//      2. Erste Karten austeilen
        for (int i = 0; i < 2; i++) {
            for (Player p : players) {
                deck.addCardFromDeck(p.getHand());
            }
            deck.addCardFromDeck(dealer.getHand());
        }
        for (Player p : players) {
            System.out.println(p.getName()+" "+p.getHand());
        }

//        3. Durchlauf nur Player - Player

//        4. Dealer spielt


//        while(true) {
//            for(int i = 0; i < players.size(); i++) {
//                System.out.println("Möchtest du weiterspielen " + players.get(i).getName());
//                // bei J -> hit
//                // bei N -> setIsStanding(true)
//
//                deck.addCardFromDeck(players.get(i).getHand()); //player objekt bzw. add für die liste aufrufen
//
//                // setStanding oder hit- konsoleneingabe
//            }
//
//            boolean allStanding = true;
//            for(int i = 0; i < players.size(); i++) {
//                if(!players.get(i).getStanding()) {
//                    allStanding = false;
//                }
//            }
//
//            if(allStanding) {
//                break;
//            }
//            // break ausführen wenn jeder spieler isStanding true hat, dh wenn er keine Karten mehr haben will oder summe >=  21 -> isStanding auf true setzen
//        }
//
//        for(int i = 0; i < players.size(); i++) {
////            players.get(i).getVictor();
//        }
//
//        Hand testHand = new Hand();
//        deck.addCardFromDeck(testHand);
//        deck.addCardFromDeck(testHand);
//
//        System.out.println(testHand);
//        System.out.println(testHand.getSum());
//
////        deck.addCardsToTrash(testHand.getHand());
//        testHand.clearHand();
//        System.out.println(testHand);
//        System.out.println(testHand.getSum());

    }


}
