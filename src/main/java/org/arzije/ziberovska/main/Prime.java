package org.arzije.ziberovska.main;

import java.util.ArrayList;
import java.util.List;

/**
 * This program counts the sum and the number of prime (int) numbers in interval 0-1000
 */
public class Prime {
    private List<Integer> primes;
    private int count = 0;
    private int sumOfPrimes = 0;

    public Prime(int firstNumber, int lastNumber) {
        validateInterval(firstNumber, lastNumber);
        primes = new ArrayList<>();
        calculatePrimes(firstNumber, lastNumber);
    }

    private void validateInterval(int start, int end) {
        if (start != 0 || end != 1000) {
            throw new IllegalArgumentException("Hoppsan, fel inmatning!");
        }
    }

    private boolean numIsPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void calculatePrimes(int current, int stop) {
        if (current > stop) {
            return;
        }
        if (numIsPrime(current)) {
            primes.add(current);
            count++;
            sumOfPrimes += current;
        }
        calculatePrimes(current + 1, stop);
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    public int getCount() {
        return count;
    }

    public int getSum() {
        return sumOfPrimes;
    }

    public void printCount() {
        System.out.println("Hej, det finns " + getCount() + " primtal mellan 0 och 1000!");
    }

    public void printSum() {
        System.out.println("Och den totala summan av dessa primtal är " + getSum() + ".");
    }

}