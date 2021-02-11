public class IslandPerimeter {

    public static void main(String[] args) {
        int[][] island = {{1},{1}};
        //int[][] island = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int y = island.length; // 1
        int x = island[0].length; //2


        System.out.println(islandPerimeter(island));

    }

    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1){
                    if(isWaterEast(grid,i,j))
                        perimeter++;
                    if(isWaterWest(grid,i,j))
                        perimeter++;
                }
                if(grid[i][j]==1 && grid[i].length > 0){
                    if(isWaterNorth(grid,i,j))
                        perimeter++;
                    if(isWaterSouth(grid,i,j))
                        perimeter++;
                }
            }
        }
        return perimeter;
    }

    public static boolean isWaterNorth(int[][] grid, int y, int x){
        boolean isWater = false;
        if((y<=0) || (grid[y-1][x]==0)){
            isWater=true;
        }
        return isWater;
    }

    public static boolean isWaterEast(int[][] grid, int y, int x){
        boolean isWater = false;
        if( (grid[y].length-1 <= x) || (grid[y][x+1]==0)){
            isWater=true;
        }
        return isWater;
    }

    public static boolean isWaterSouth(int[][] grid, int y, int x){
        boolean isWater = false;
        if((grid[y].length-1 == y) || grid.length==1 || grid[y+1][x]==0){
            isWater=true;
        }
        return isWater;
    }

    public static boolean isWaterWest(int[][] grid, int y, int x){
        boolean isWater = false;
        if((x <= 0) || (grid[y][x-1]==0)){
            isWater=true;
        }
        return isWater;
    }
}
