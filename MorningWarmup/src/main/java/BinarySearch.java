public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {-1,0,3,5,9,12};
        System.out.println("number occurs at index " + search(nums,0));
    }

    public static int search(int[] nums, int target) {
        int index = nums.length/2;

        if(target == nums[index])
            return index;

        else if (target < nums[index]){
            int[]smallerNums = new int[nums.length/2+1];

            for (int i=0;i<smallerNums.length;i++){
                smallerNums[i] = nums[i];

            }

            index -= search(smallerNums,target);

        } else if (target > nums[index]){

            int[]biggerNums = new int[nums.length/2+1];
            for (int i=0;i<nums.length/2;i++){
                biggerNums[i] = nums[index+i];

            }

            index += search(biggerNums,target);

        } else if(target != nums[index])
            return -1;

        return index;
    }
}
