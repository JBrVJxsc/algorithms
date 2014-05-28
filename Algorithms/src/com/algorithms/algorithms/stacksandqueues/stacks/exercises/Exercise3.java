package com.algorithms.algorithms.stacksandqueues.stacks.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.stacksandqueues.stacks.implementations.ArithmeticExpressionEvaluator;
import com.algorithms.base.Parameter;
import com.algorithms.interfaces.IAlgorithm;

/**
 * Created by Who on 2014/4/20.
 */
public class Exercise3 extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return 1398003465718l;
    }

    @Override
    public String getName() {
        return "Arithmetic Expression Evaluator";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        ArithmeticExpressionEvaluator arithmeticExpressionEvaluator = new ArithmeticExpressionEvaluator();
        String string1 = "((((((10+((4+1)*(8/4)))/5)+1)*20)+0.5)+0.5)";
        String string2 = "(1+((2+3)*(4*5)))";
        Parameter<String> expression = new Parameter<String>(string1, "Expression");
        set(expression);
        double value = arithmeticExpressionEvaluator.evaluate(expression.getValue());
        print(value);
    }
}
