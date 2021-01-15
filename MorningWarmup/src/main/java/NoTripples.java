public class NoTripples {
    public static void main(String[] args) {
        int[]nums = new int[]{1,1,2,2};

        noTripples(nums);
    }

    public static boolean noTripples(int[] nums){
        boolean noTripples = true;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==nums.length-3) {
                System.out.println("there are no tripples!");
                noTripples = true;
                break;
            }

            if(nums[i]==nums[i+1] && nums[i+1] == nums[i+2]) {
                System.out.println("There are tripples!");
                System.out.println(nums[i]+" "+nums[i+1]+" "+nums[i+2]+" are our tripples!");
                System.out.println("They start at the " + (i+1) + "th int");
                noTripples = false;
                break;
            }
        }
        return noTripples;
    }
}
