package src;

import java.util.*;

public class BlackJack {

    private static ArrayList<Player> players = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // **Game Start**
        System.out.print("Welcome to Black Jack!\n" +
                "How many players will join this game? Please type in a number from 1-10: ");
        boolean isValid = false;
        int playerCount = 0;
        while (!isValid) {
            if (input.hasNextInt()) {
                isValid = true;
                playerCount = input.nextInt();
                if (!(playerCount < 11 && playerCount > 0)) {
                    System.out.print("Please enter a valid number from 1-10: "); isValid = false;
                }
            } else {
                input.next();
                System.out.print("Please enter a valid number from 1-10: ");
            }
        }

        Player[] player = new Player[playerCount];

        //Idee: Start balance für alle Spieler gleich?

        for (int i = 0; i < player.length; i++) {
            System.out.print("Please enter your name Player" + (i + 1) + ": ");
            String name = input.next();
            System.out.print("Please type in your starting balance: ");

            isValid = false;
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

        System.out.println();
        System.out.println(players);
        System.out.println();

        CardDeck deck = new CardDeck();
        deck.shuffle();
//      1.
        for (Player p : players) {
            System.out.print(p.getName()+", place your bet or type 0 to skip this round: ");
            isValid = false;
            while (!isValid) {
                if (input.hasNextDouble()) {
                    double currentBet = input.nextDouble();
                    if (currentBet <= 0) {
                        // ?
                        p.setStanding(true);
                        isValid = true;
                    } else {
                        // Sufficient Balance?
                        if (currentBet < p.getBalance() + 1) {
                            p.setBet(currentBet);
                            p.setBalance(p.getBalance() - currentBet);
                            isValid = true;
                        } else {
                            System.out.print("Insufficient balance, please try again: ");
                        }
                    }
                } else {
                    input.nextDouble();
                    System.out.print("Please enter a valid number for your bet: ");
                }
            }
        }
        System.out.println();
            //2. Erste Karten austeilen
        for (int i = 0; i < 2; i++) {
            for (Player p : players) {
                deck.addCardFromDeck(p.getHand());
            }
            deck.addCardFromDeck(dealer.getHand());
        }
        String dealersFirst = dealer.getName()+" "+dealer.getHand();
        int indexOfMinus = dealersFirst.indexOf("-");
        System.out.println(dealersFirst.substring(0, indexOfMinus) + " - [Hidden] (?)"); // Zweite Karte verdeckt
        for (Player p : players) {
            System.out.println(p.getName()+" "+p.getHand());
        }
        System.out.println();
        for (Player p : players) {
            if (p.getHand().getBlackjack()) {
                p.setStanding(true);
                System.out.println("Blackjack!");
            }
            System.out.print(p.getName()+", type 'h' to hit or 's' to stand: ");
            while (!p.getStanding()) {
                if (input.hasNext()) {
                    String standOrHit = input.next();
                    switch (standOrHit) {
                        case "h":
                            //fetch a new card
                            deck.addCardFromDeck(p.getHand());
                            //print hand
                            System.out.println(p.getName() + " " + p.getHand());
                            //new choice
                            System.out.print(p.getName()+", type 'h' to hit or 's' to stand: ");
                            break;
                        case "s":
                            p.setStanding(true);
                            break;
                        default:
                            System.out.print("Only valid inputs are h / s : ");
                        }
                } else {
                    System.out.print("Please enter a valid input: ");
                }
            }
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
