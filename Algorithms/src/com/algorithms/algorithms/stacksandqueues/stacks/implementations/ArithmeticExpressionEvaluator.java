package com.algorithms.algorithms.stacksandqueues.stacks.implementations;

import com.algorithms.algorithms.stacksandqueues.stacks.LinkedListStack;
import com.algorithms.algorithms.stacksandqueues.stacks.LinkedListStackPlus;

/**
 * Created by Who on 2014/4/20.
 */
public class ArithmeticExpressionEvaluator {
    private LinkedListStackPlus<Double> valueStack = new LinkedListStackPlus<Double>();
    private LinkedListStack operatorStack = new LinkedListStack();
    private String number = "";

    public double evaluate(String expression) {
        expression = expression.trim();
        int length = expression.length();
        String operators = "+-*/";
        String allSymbol = "+-*/)(";
        for (int i = 0; i < length; i++) {
            char c = expression.charAt(i);
            if (allSymbol.indexOf(String.valueOf(expression.charAt(i))) != -1) {
                pushNumber();
            }
            if (c == '(') {
                continue;
            } else if (c == ')') {
                operate();
            } else if (operators.indexOf(String.valueOf(c)) != -1) {
                operatorStack.push(String.valueOf(c));
            } else {
                number += String.valueOf(c);
            }
        }
        return valueStack.pop();
    }

    private void pushNumber() {
        if (number == "") {
            return;
        }
        double value = Double.parseDouble(number);
        valueStack.push(value);
        number = "";
    }

    private void operate() {
        double value = 0;
        double value1 = valueStack.pop();
        double value2 = valueStack.pop();
        String operator = operatorStack.pop();
        if (operator.equals("+")) {
            value = value1 + value2;
        } else if (operator.equals("-")) {
            value = value2 - value1;
        } else if (operator.equals("*")) {
            value = value1 * value2;
        } else if (operator.equals("/")) {
            value = value2 / value1;
        }
        valueStack.push(value);
    }
}
