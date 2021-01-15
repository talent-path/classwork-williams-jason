public class Balancing {
    public static void main(String[] args) {

        int[] test = new int[] {2,3,3,2};

        System.out.println(canBalance(test));

    }

    public static boolean canBalance(int[] nums){
        boolean balanced = false;
        int left = 0;
        int right = 0;

        for(int i = 0;i<nums.length;i++){
            left = sumLeft(nums,i);
            right = sumRight(nums,i);

            if(left==right){
                balanced=true;
            }
        }

        return balanced;
    }

    public static int sumLeft (int[] nums, int index){
        int sum = 0;

        for(int i=0;i<index;i++){
            sum+=nums[i];
        }

        return sum;
    }

    public static int sumRight (int[] nums, int index){
        int sum = 0;

        for(int i=nums.length-1;i>index;i--){
            sum+=nums[i];
        }

        return sum;
    }
}
