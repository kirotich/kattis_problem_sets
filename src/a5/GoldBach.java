
package a5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class GoldBach{
    public static void   main (String [] args){
        Scanner input = new Scanner(System.in);

        int tests = Integer.parseInt(input.nextLine());

        for( int i=0; i<tests; i++){
            int evenNo = Integer.parseInt(input.nextLine());
            goldBach(evenNo);

        }

    }

    /*
        Generates primes numbers using Sieve of Eratosthenes Algorithm
     */
    static ArrayList<Integer> generatePrime(int n){
        boolean[] primes = new boolean[n+1];
        ArrayList<Integer> res = new ArrayList<>();

        for(int i =2; i<n; i++){
            primes[i] = true;
        }

        //Cancel out multiples of primes
        for(int factor = 2; factor*factor <=n; factor++) {
            if(primes[factor]){
                for(int j=factor; factor*j <=n; j++) {
                    primes[factor * j] = false;
                }
            }

        }

        for(int k = 2; k < primes.length; k++){
            if(primes[k]){
                res.add(k);
            }
        }

        return res;
    }
    /*
        input: evenNumber
        find all unique ways to represent a given even number as the sum of two prime numbers.
     */


    static void goldBach(int evenNum){
        ArrayList<Integer> arr = generatePrime(evenNum);

        Map<Integer,Integer> map = new HashMap<>();

        ArrayList<Integer> num1 = new ArrayList<>();
        ArrayList<Integer> num2 = new ArrayList<>();
        int count = 0;

        //Map prime number with its index
        for(int i=0; i<arr.size(); i++){
            int complement = evenNum - arr.get(i);

            if(map.containsKey(complement) || (complement == arr.get(i))){
                num1.add(complement);
                num2.add(arr.get(i));
                count++;
            }

            map.put(arr.get(i), i);
        }

        System.out.println(evenNum + " has " + count + " representation(s)" );
        for(int j = num1.size()-1; j>=0; j--){

            System.out.println(num1.get(j) + "+" + num2.get(j));

        }
        System.out.println();




    }

}
