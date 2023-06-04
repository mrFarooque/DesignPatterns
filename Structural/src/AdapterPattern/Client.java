package AdapterPattern;
/**
 * Note:
 * Here ICalculator is a simple interface which only adds two numbers at a time but as a third party code
 * there exists AdvanceCalculator class which can add multiple values at a time, to use the methods of
 * AdvanceCalculator class with my existing ICalculator interface I need an Adapter class which can act as a
 * mediator between my ICalculator interface and AdvanceCalculator class. Thus, you see AdvanceCalculatorAdapter
 * class.
 */

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        AdvanceCalculator advanceCalculator = new AdvanceCalculator();
        ICalculator calculatorAdapter = new AdvanceCalculatorAdapter(advanceCalculator);
        int sum = calculatorAdapter.sum(1,2);
        System.out.println("sum:\t" + sum);
    }
}

// my created interface
interface ICalculator {
    int sum(int a, int b);
}

// third party code
class AdvanceCalculator {
    int addition(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        return sum;
    }
}

// Adapter
class AdvanceCalculatorAdapter implements ICalculator {
    private AdvanceCalculator advanceCalculator;
    AdvanceCalculatorAdapter(AdvanceCalculator calculator) {
        advanceCalculator = calculator;
    }
    @Override
    public int sum(int a, int b) {
        return advanceCalculator.addition(new int[]{a, b});
    }
}

