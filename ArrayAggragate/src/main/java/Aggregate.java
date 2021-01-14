public class Aggregate {

    public static int max (int [] arr){
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if (arr[i]>ans)
                ans = arr[i];
        }
        return ans;
    }
    public static int min (int [] arr){
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if (arr[i]<ans)
                ans = arr[i];
        }
        return ans;
    }

    public static int sum (int [] arr){
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            ans += arr[i];
        }
        return ans;
    }

    public static double average (int [] arr){
        return sum(arr)/arr.length;
    }

    public static double standarddeviation(int [] arr){
        double avg = average(arr);
        double sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=Math.pow(avg-arr[i],2);
        }

        double ans = Math.sqrt(sum/(arr.length-1));
        return ans;
    }
}
