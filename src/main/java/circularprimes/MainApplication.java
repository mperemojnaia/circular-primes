package circularprimes;

public class MainApplication {
    
    public static void main(String args[]){
        int mln = 1000000;
        MathUtilities mathUtilities = new MathUtilities();

        Long startTime = System.currentTimeMillis();
        System.out.println(mathUtilities.findCircularPrimes(mln));
        
        Long time = System.currentTimeMillis() - startTime;
        System.out.println(time+" ms");

    }
}
