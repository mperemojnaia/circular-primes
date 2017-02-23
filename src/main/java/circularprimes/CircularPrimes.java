package circularprimes;


import java.util.ArrayList;
import java.util.List;

public class CircularPrimes {

    public static Integer findCircularPrimes(Long number) {

        //finding simple primes
        List<Long> primes = new ArrayList<>();
        List<Long> circularPrimes = new ArrayList<>();

        for (int i = 1; i < number; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                primes.add((long) i);
            }
        }

        for (Long prime : primes) {
            for (Long rotatedPrime : rotateDigits(prime)) {
                for (long i = 1; i < rotatedPrime; i++) {
                    boolean isPrime = true;
                    for (long j = 2; j < i; j++) {
                        if (i % j == 0) {
                            isPrime = false;
                        }
                    }
                    if (isPrime) {
                        circularPrimes.add(prime);
                    }
                }
            }
        }

        return circularPrimes.size();
    }

    private static List<Long> rotateDigits(Long number) {

        List<Long> rotatedNumbers = new ArrayList<>();

        long start = number;

        Boolean needsRotation = true;

        int nrOfDigits = (int) Math.log10((double) number);
        int multiplier = (int) Math.pow(10.0, (double) nrOfDigits);

        while (needsRotation) {
            Long modulo = number % 10;
            number /= 10;
            number += multiplier * modulo;

            rotatedNumbers.add(number);

            if (number == start)
                needsRotation = false;
        }
        return rotatedNumbers;
    }
}
