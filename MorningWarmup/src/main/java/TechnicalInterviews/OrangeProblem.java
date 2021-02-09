package TechnicalInterviews;

public class OrangeProblem {

    public static void main(String[] args) {
//        System.out.println(minDays(10) + "\texpect \t4");
//        System.out.println(minDays(6) + "\texpect \t3");
//        System.out.println(minDays(1) + "\texpect \t1");
//        System.out.println(minDays(56) + "\texpect \t6");
        System.out.println(minDays(46) + "\texpect \t12");
    }

    public static double minDays(double numOfOranges) {
        if(numOfOranges==1)
            return 1;
        double days = 0;


        while(numOfOranges>0){

            if (numOfOranges%3==0){
                numOfOranges = eatTwoThirds(numOfOranges);
                days++;

            } else if((numOfOranges-1)%3==0 && (numOfOranges==15)){
                numOfOranges = eatOne(numOfOranges);
                days++;
            } else if((numOfOranges-1)%3==0 && (numOfOranges%15==0)){

            } else if(numOfOranges%2==0){
                numOfOranges = eatHalf(numOfOranges);
                days++;

            } else {
                numOfOranges = eatOne(numOfOranges);
                days++;
            }
        }

        return days;
    }

    public static double eatHalf(double numOfOranges){
        return numOfOranges/2;
    }

    public static double eatOne(double numOfOranges){
        return numOfOranges-1;
    }

    public static double eatTwoThirds(double numOfOranges){
        return numOfOranges - 2*(numOfOranges/3);
    }
}
