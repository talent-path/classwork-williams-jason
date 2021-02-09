import java.util.ArrayList;
import java.util.List;

public class PermiFinder {

    public static void main(String[] args) {
        int[] test = {1,2,3};

        for (int i = 0; i < test.length-1; i++) {
            for (int j = 0; j < test.length; j++) {
                printArray(test);
                digitSwapper(test,j);
            }

        }

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allPerms = new ArrayList<>();
        List<Integer> currentPerm = new ArrayList<>();

        for (int i = 0; i < permsLeft(nums.length); i++) {
            for (int j = 0; j < nums.length; j++) {
                currentPerm.add(nums[i]);
            }
            digitSwapper(nums,i);
            allPerms.add(currentPerm);


        }

    return allPerms;

    }
    public static int permsLeft(int x){
        int total = 1;
        for (int i = x; i > 0; i--) {
            total*=i;
        }
        return total;
    }
    public static int[] digitSwapper(int[] nums, int index){

        int temp = nums[index];

        nums[index] = nums[index+1];

        nums[index+1] = temp;

        return nums;


    }

    public static void printArray(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
