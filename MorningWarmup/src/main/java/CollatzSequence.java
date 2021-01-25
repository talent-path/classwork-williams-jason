public class CollatzSequence {

    static int count=0;
    public static void main(String[] args) {

        int biggestCount=0;
        long bigIndex=0;
        for(long i =10000000;i>i/5;i--){
            sequence(i);





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
