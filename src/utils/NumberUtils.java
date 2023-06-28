package utils;

import java.util.HashMap;
import java.util.Map;

public class NumberUtils {

    public static boolean isPrime(int number) {
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

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }

        int reversed = 0;
        int original = number;

        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return original == reversed;
    }

    public static Map<Integer, Integer> primeFactorization(int number) {
        Map<Integer, Integer> factors = new HashMap<>();
        for (int factor = 2; factor <= number; factor++) {
            while (number % factor == 0) {
                factors.put(factor, factors.getOrDefault(factor, 0) + 1);
                number /= factor;
            }
        }
        return factors;
    }
}
