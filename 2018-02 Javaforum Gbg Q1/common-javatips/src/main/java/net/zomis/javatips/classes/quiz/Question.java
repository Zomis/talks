package net.zomis.javatips.classes.quiz;

/**
 * Example from https://codereview.stackexchange.com/q/185892/31562
 */
public abstract class Question {

    protected int score;
    protected boolean isAnswerRight;

    public Question(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public abstract void ask();

}