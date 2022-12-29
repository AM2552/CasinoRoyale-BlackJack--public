package src;

public class Dealer extends Person {

    private Hand hand;
    private boolean isVictor = false;
    private boolean isStanding = false;

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

    public void dealCard() {}


}
