import java.util.ArrayList;

public class PerfectNumber {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //perfect numbers:
        //numbers that adds up to doulbe its self from all of its factors

        for(int i=0;i<10000000;i++){
            if(perfectNumber(i))
                System.out.println(i + " is a perfect number");

            if(i%10000==0)
                System.out.println(i);

        }
        long endTime = System.currentTimeMillis();

        System.out.println("it took " + ((endTime-startTime) * 0.001) + " seconds");
        //9.477 seconds slowest
        //7.131 seconds without checking even numbers
        //3.707 seconds only checking half
    }

    public static boolean perfectNumber(int input) {
        boolean isPerfect = false;
        ArrayList<Integer> factors = allFacotrs(input);
        int sum = 0;
        for (int i = 0; i < factors.size(); i++) {
            sum+= factors.get(i);
        }

        if(sum == input)
            isPerfect = true;

        return isPerfect;
    }

    public static ArrayList<Integer> allFacotrs(int input) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
            //if even check all numbers
        if(input%2==0) {
            for (int i = 1; i <= input/2; i++) {
                if (input % i == 0)
                    factors.add(i);
            }
        }
            //if odd skip all even numbers
        else {
            for (int i = 1; i <= input/2; i+=2) {
                if (input % i == 0)
                    factors.add(i);
            }
        }
        return factors;
    }
}
