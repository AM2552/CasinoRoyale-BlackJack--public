package src;

import java.util.ArrayList;

public class Player {

    // variables for Player
    private String name;
    private double balance;
    private double bet;
    private Hand hand;
    private boolean isVictor = false;
    private boolean isStanding = false;

    // setter & getter for name
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    // setter & getter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }

    // setter & getter for bet
    public void setBet(double bet) {
        this.bet = bet;
    }
    public double getBet() {
        return bet;
    }

    // setter & getter for hand
    public void setHand(Hand hand) {
        this.hand = hand;
    }
    public Hand getHand() {
        return hand;
    }

    // set & check for isVictor
    public void setVictor(boolean victor) {
        isVictor = victor;
    }
    public boolean getVictor() {
        return isVictor;
    }

    // set & check for isStanding
    public void setStanding(boolean standing) {
        isStanding = standing;
    }
    public boolean getStanding() {
        return isStanding;
    }

    // constructors
    public Player (String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // TODO
    public void hit(Card card, ArrayList<Card> deck) {

    }

    public void stand(Hand hand) {
        setStanding(true);
    }

    public void bet(double amount) {

    }


}