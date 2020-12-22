// The goal of this problem is to find the sum of last digits of Fibonacci numbers


import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        //The newest submission

        n++;// count 0s
        if (n <= 1)
            return 0;

        long sum =0;
        ArrayList<Long> fib = new ArrayList<>();
        fib.add(0,0l);
        fib.add(1,1l);
        //pattern we are looking for
        int a = 0;
        int b = 1;
        //variables for pattern search.
        int c = -1;
        int d = -1;
        //Find the period of mod 10;
        int i =2;
        while(i<=n+1){
            long current = fib.get(i-1) + fib.get(i-2);
            c = d;
            d = (int) (current % 10);
            if(a==c && b ==d){
                --i;
                fib.remove(i);
                //System.out.println("The length of the sequence is " + i);
                //System.out.println("The length of the array is " + fib.size());
                break;
            }
            fib.add(i,current);
            i++;
        }
        int remainder = (int) (n % 60); // how many digits to be added
        int numberOfSequences = (int) (n/60); // how many group of 60's do we have

        if( numberOfSequences >0){
            for( int j = 0; j<i;j++){
                sum = (sum +fib.get(j))%10;
            }

            for( int j =0; j<numberOfSequences;j++){
                sum = (sum*2)%10;
            }

        }

        if(remainder>0){
            for(int j =0; j<remainder;j++){
                sum = (sum +fib.get(j))%10;
            }
        }

        return sum ;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(832564823476l);


        System.out.println(getFibonacciSumNaive(s));
    }
}


