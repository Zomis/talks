package net.zomis.javatips;

public class MyObject {

    private int state;

    public int modifySomeState() {
        state++;
        return state;
    }

    public int getState() {
        return state;
    }

}
