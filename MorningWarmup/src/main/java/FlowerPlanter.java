public class FlowerPlanter {
    public static void main(String[] args) {
        int[] bed = {0,0,1,0,1};


        System.out.println(canPlaceFlowers(bed,1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i]!=1&&plantableSpot(flowerbed,i)) {
                count++;
                i++;
            }
        }
        if(count<n)
            return false;

        return true;
    }

    public static boolean plantableSpot(int[] flowerbed, int index){
        boolean isPlantable = false;
        boolean left = false;
        boolean right = false;

        if(flowerbed.length==1&&flowerbed[index]==0){
            return true;
        }
        if(flowerbed.length==1&&flowerbed[index]==1){
            return false;
        }

        if(index>0){
            left = checkLeft(flowerbed,index);
        }

        if(index<flowerbed.length-1){
            right = checkRight(flowerbed,index);
        }

        if((left&&right)||(right&&index==0)||(left&&index==flowerbed.length-1)){
            isPlantable=true;
        }

        return isPlantable;
    }

    public static boolean checkLeft(int[] flowerbed, int index){

        if(flowerbed[index-1]==0){
            return true;
        }
        return false;
    }

    public static boolean checkRight(int[] flowerbed, int index){

        if(flowerbed[index+1]==0){
            return true;
        }
        return false;
    }
}
