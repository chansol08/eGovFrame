package kr.bit.practice.model;

public class MyCalc {

    public int sum(int number1, int number2) {
        int sum = 0;

        for (int i = number1; i <= number2; i++) {
            sum += i;
        }

        return sum;
    }
}
