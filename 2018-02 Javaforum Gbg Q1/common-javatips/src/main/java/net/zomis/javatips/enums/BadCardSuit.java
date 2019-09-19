package net.zomis.javatips.enums;

public enum BadCardSuit {

    SPADES, HEARTS, DIAMONDS, CLUBS;

    public boolean isBlack() {
        return ordinal() % 2 == 0;
    }

    public boolean isRed() {
        return !isBlack();
    }

}
