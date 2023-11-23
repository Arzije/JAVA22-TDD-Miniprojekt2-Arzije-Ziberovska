package org.arzije.ziberovska;

import org.arzije.ziberovska.main.Prime;

public class Main {
    public static void main(String[] args) {

        Prime primeNumbers = new Prime(0, 1000);
        System.out.println(primeNumbers.getPrimes());
        primeNumbers.getSum();

    }
}