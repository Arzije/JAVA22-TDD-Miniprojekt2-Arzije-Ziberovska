package org.arzije.ziberovska;

import org.arzije.ziberovska.main.Prime;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ange startintervallet 0: ");
            int start = scanner.nextInt();
            System.out.println("Ange slutintervallet 1000: ");
            int end = scanner.nextInt();

            Prime prime = new Prime(start, end);
            prime.printCount();
            prime.printSum();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

}