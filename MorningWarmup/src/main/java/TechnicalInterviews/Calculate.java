package TechnicalInterviews;

public class Calculate {
    public static void main(String[] args) {
//        System.out.println(Calculate("6/6"));
        System.out.println(advCalculate("(3 + (3 + 3))"));
    }

    //rules: left side always a valid integer

    public static int calculate(String expression) {
        int num1=Integer.MAX_VALUE;
        int num2=Integer.MAX_VALUE;
        int ans = 0;
        String symbol = "";
        expression = expression.replace(" ", "");

        for (int i = 0; i < expression.length(); i++) {

            symbol = expression.substring(i, i + 1);

            if (symbol.equals("+") || symbol.equals("-") ||
                    symbol.equals("*") || symbol.equals("/")) {

                num1 = Integer.valueOf(expression.substring(0, i));
                num2 = Integer.valueOf(expression.substring(i+1,expression.length()));
                break;

            }
        }

        if(symbol.equals("+"))
            ans = num1+num2;
        else if(symbol.equals("-"))
            ans = num1-num2;
        else if(symbol.equals("*"))
            ans = num1*num2;
        else if (symbol.equals("/"))
            ans = num1/num2;
        return ans;
    }

    public static int advCalculate(String expression){
        int sum = 0;
        for (int i = 1; i < expression.length(); i++) {
            if(expression.substring(i,i+1).equals("(")){
                advCalculate(expression.substring(i+1,expression.indexOf(")")));
                expression= expression.trim();
            }
        }
        sum+= calculate(expression);
        return sum;
    }
}
