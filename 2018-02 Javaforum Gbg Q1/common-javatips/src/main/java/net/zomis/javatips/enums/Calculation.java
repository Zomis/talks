package net.zomis.javatips.enums;

import java.util.function.IntBinaryOperator;

public enum Calculation implements IntBinaryOperator {

    ADD((a, b) -> a + b),
    SUBTRACT((a, b) -> a - b),
    MULTIPLY((a, b) -> a * b),
    DIVIDE((a, b) -> a / b),
    ;

    private final IntBinaryOperator operator;

    Calculation(IntBinaryOperator operator) {
        this.operator = operator;
    }

    @Override
    public int applyAsInt(int left, int right) {
        return operator.applyAsInt(left, right);
    }

}
