public class MaxMirror {
    public static void main(String[] args) {
        int[] test = new int[] {5, 9, 9, 4, 5, 4, 9, 9, 2};
        System.out.println(maxMirror(test));
    }
    public static int maxMirror(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int currentSum=0;
        int biggestSum=0;
        int index=0;

        for(int i=0;i<nums.length;i++){
            index=i;

            for(int j=nums.length-1;j>index;j--){

                if(nums[index]==nums[j]){
                    index++;
                    currentSum++;
                }

            }
            if (currentSum > biggestSum) biggestSum = currentSum;
            currentSum = 0;
        }

        return biggestSum;
    }
}
