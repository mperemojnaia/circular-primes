package circularprimes;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * MathUtilities class
 * <p/>
 * 23.02.2017
 */
public class MathUtilities {

    /**
     * Finds all circular primes in a given range from 1 to N
     * 
     * @param number - N, limit of a given range
     * 
     * @return the number of all 
     */
    public Integer findCircularPrimes(int number) {

        List<Integer> primes = new ArrayList<>();
        List<Integer> circularPrimes = new ArrayList<>();

        IntStream.range(2, number).forEach(i -> {
            if (isPrime(i)) {
                primes.add(i);
            }
        });
        
        primes.forEach(prime -> {
            int counter = 0;
            for (Integer rotatedPrime : rotateDigits(prime)) {
                if (isPrime(rotatedPrime)) {
                    counter++;
                }
            }
            if (counter == rotateDigits(prime).size()) {
                circularPrimes.add(prime);
            }
        });

        return circularPrimes.size();
    }


    /**
     * <b>Cyclic permutation</b> of the digits of a given number.
     * 
      *@param number number given for digit permutation
     *               
     * @return a list all permutations of a given number
     */
    public List<Integer> rotateDigits(Integer number) {

        List<Integer> rotatedNumbers = new ArrayList<>();
        long originalNumber = number;
        Boolean needsRotation = true;

        int nrOfDigits = (int) Math.log10((double) number);
        int multiplier = (int) Math.pow(10.0, (double) nrOfDigits);

        while (needsRotation) {
            Integer modulo = number % 10;
            number /= 10;
            number += multiplier * modulo;

            rotatedNumbers.add(number);

            if (number == originalNumber)
                needsRotation = false;
        }
        return rotatedNumbers;
    }


    /**
     * Checks if a number is prime
     * 
     * @param number 
     * 
     * @return true in case if number is a prime, else - false
     */
    public Boolean isPrime(Integer number) {
        boolean isPrime = true;
        if (number == 0 || number == 1) {
            isPrime = false;
        }
        for (int i = 2; i*i <= number; i++) {
            if (number % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }
    
}
