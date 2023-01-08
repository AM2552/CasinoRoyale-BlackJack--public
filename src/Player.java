package src;

import java.util.ArrayList;
import java.util.Collections;

public class Player extends Person {

    // variables for Player
    private double balance;
    private double bet;
    private boolean isStanding = false;



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


    // set & check for isStanding
    public void setStanding(boolean standing) {
        isStanding = standing;
    }
    public boolean getStanding() {
        return isStanding;
    }

//    public int getCardSum() {
//        return
//    }

    // constructors
    public Player (String name, double balance) {
        super(name);
        this.balance = balance;
    }


    public void stand(Hand hand) {
        setStanding(true);
    }

    public void bet(double amount) {

    }

    @Override
    public String toString() {
       return (this.getName()+" "+this.getBalance()+"$");
    }

}