public class NumReverser {

    public static void main(String[] args) {

        System.out.println(toReverse(-123));

    }

    public static int toReverse(int input) {
        int ans = 0;
        int temp = input;

        while (temp != 0) {
            ans *= 10;
            temp %= 10;
            ans += temp;
            temp = input /= 10;
        }

        return ans;
    }
}
