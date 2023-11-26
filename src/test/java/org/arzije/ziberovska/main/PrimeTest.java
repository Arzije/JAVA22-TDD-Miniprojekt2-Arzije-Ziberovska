package org.arzije.ziberovska.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    private Prime prime;

    @BeforeEach
    void setUp(){
        prime = new Prime(0, 1000);
    }

    @Test
    @DisplayName("Validates that all prime numbers are correctly identified within the range")
    void allPrimes() {
        List<Integer> expectedPrimes = List.of(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997
        );
        assertEquals(expectedPrimes, prime.getPrimes());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1001",    // End value greater than 1000
            "-1, 1000",   // Start value less than 0
            "1001, 1000", // Start value greater than 1000
            "500, 499",   // Start value greater than end value within range
            "-5, -1",     // Both start and end values are negative
            "0, 2000",    // End value significantly greater than 1000
    })
    @DisplayName("Constructor throws IllegalArgumentException for invalid start and end values")
    void invalidConstructorTest(int start, int end) {
        assertThrows(IllegalArgumentException.class, () -> new Prime(start, end));
    }


    @Test
    @DisplayName("Validates that the exception message is correct for an invalid range")
    void exceptionMessageTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Prime(-1, 1000));
        assertEquals("Hoppsan, fel inmatning!", exception.getMessage());
    }

    @Test
    @DisplayName("Ensures that the sum of primes is accurate")
    void sumOfPrimes() {
        assertEquals(76127, prime.getSum());
    }

    @Test
    @DisplayName("Ensures that the prime counter is accurate")
    void countOfPrimes() {
        assertEquals(168, prime.getCount());
    }

    @Test
    @DisplayName("Ensures the smallest and largest primes within the range are identified")
    void rangePrimes() {
        assertTrue(prime.getPrimes().contains(2));
        assertTrue(prime.getPrimes().contains(997));
    }

    @Test
    @DisplayName("Check if sum and count are of integer type")
    void datatypeCheck() {
        assertInstanceOf(Integer.class, prime.getSum());
        assertInstanceOf(Integer.class, prime.getCount());
    }

    @Test
    @DisplayName("Verifies that printCount outputs the correct count")
    void printCount() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        prime.printCount();
        String expectedOutput = "Hej, det finns " + prime.getCount() + " primtal mellan 0 och 1000!" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
        System.setOut(System.out);
    }

    @Test
    @DisplayName("Verifies that printSum outputs the correct sum")
    void printSumTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        prime.printSum();
        String expectedOutput = "Och den totala summan av dessa primtal är " + prime.getSum() + "." + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
        System.setOut(System.out);
    }

}