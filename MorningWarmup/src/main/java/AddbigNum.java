public class AddbigNum {

    public static void main(String[] args) {
        int[] left ={1,2,3};    //321
        int[] right = {6,7,8};  //876

        int[] sum = addBigNum(left,right);

        for(int i=sum.length-1;i>-1;i--){
            System.out.print(sum[i]);
        }

    }

    // given two arrays of size 100 each representing a 100 digit number
    public static int[] addBigNum(int[] left, int[] right) {

        int[] ans = new int[left.length+1];
        int sum = 0;
        boolean carryAOne = false;

        for (int i = 0; i < left.length; i++) {
            sum += left[i];
            sum += right[i];

            if (carryAOne){
                sum += 1;
                carryAOne = false;
            }

            if (sum >= 10) {
                sum %= 10;
                carryAOne = true;
            }

            ans[i] = sum;
            sum = 0;

        }

        if (carryAOne) ans[ans.length-1] = 1;
        return ans;
    }
}
