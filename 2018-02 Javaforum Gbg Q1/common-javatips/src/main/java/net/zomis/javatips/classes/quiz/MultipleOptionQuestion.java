package net.zomis.javatips.classes.quiz;

import javax.swing.*;

public class MultipleOptionQuestion extends Question {
    private static final int MULTIPLE_OPTION_SCORE = 1;
    private String statement;
    private String[] options;
    private String clue;
    private int rightOption;

    public MultipleOptionQuestion(int score, String statement, String[] options, int rightOption, String clue) {
        super(MULTIPLE_OPTION_SCORE);
        this.statement = statement;
        this.options = options;
        this.clue = clue;
        this.rightOption = rightOption;
    }

    @Override
    public void ask() {
        String answer = (String) JOptionPane.showInputDialog(null, statement, "Question Test", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (answer.equals(options[rightOption])) {
            this.isAnswerRight = true;
        }
    }

}
