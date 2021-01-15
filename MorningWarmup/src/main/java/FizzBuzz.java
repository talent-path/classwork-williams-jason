public class FizzBuzz {
    public static void main(String[] args) {

        fizzBuzz();
    }

    public static int middleOfThree(int a, int b, int c){

        int ans=a;

        if ( b > a && b > c)
            ans = b;

        if ( c > a && c > b)
            ans = c;

        return ans;
    }

    public static void fizzBuzz(){

        for(int i=1;i<100;i++){

            if(i%3==0 && i%5==0){
                System.out.println("fizzbuzz");
            } else if( i%3==0){
                System.out.println("fizz");
            } else if (i%5==0){
                System.out.println("buzz");
            } else
                System.out.println(i);


        }
    }
}
