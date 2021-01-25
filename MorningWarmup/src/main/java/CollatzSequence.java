public class CollatzSequence {

    static int count=0;
    public static void main(String[] args) {

        int biggestCount=0;
        long bigIndex=0;
        for(long i =10000000;i>i/5;i--){
            sequence(i);
            if(i==10){
                System.out.println("checking 10s");
            } else if(i==100){
                System.out.println("checking 100s");
            } else if(i==1000){
                System.out.println("checking 1000s");
            } else if(i==10000){
                System.out.println("checking 10000s");
            } else if(i==100000){
                System.out.println("checking 100000s");
            } else if(i==1000000){
                System.out.println("checking 1000000s");
            } else if(i==10000000){
                System.out.println("checking 10000000s");
            } else if(i==100000000){
                System.out.println("checking 100000000s");
            } else if(i==1000000000){
                System.out.println("checking 1000000000s");
            }





            if (count > biggestCount){
                biggestCount = count;
                bigIndex = i;
                //System.out.println("new biggest count: " + biggestCount + " at number " + i);
            }

            count =0;
        }
        System.out.println(bigIndex);

    }

    public static long sequence(long currentNum){
        if(currentNum==1){
            count++;
            return 1;
        }
        if(currentNum%2==0){
            count++;
            return sequence(currentNum/2);
        }
        else {
            count++;
            return sequence(3 * currentNum + 1);
        }
    }
}
