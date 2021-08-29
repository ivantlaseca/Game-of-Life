import java.util.Random;

public class Life {
    /*
    0 0 0 0 0
    0 1 0 0 0
    0 0 1 0 0
    0 0 0 1 0
    0 0 0 0 0

    Find all the cells that need to be changed and mark them somehow.
    In a second pass, change the values of all the marked cells.
    Print that new grid.
    Do this x times.






     */





    public static void main(String[] args) {



        double startTime = System.nanoTime();

        int[][] grid = new int[5][5];

        //Initializes grid to 0s and 1s
        initGrid(grid);

        //Prints initial grid
        printGrid(grid);
        //Find target values
        findTargets(grid);
        //Apply rules of game to target values
        applyRules(grid);






    }
    public static int[][] initGrid(int[][]grid){
        Random rand = new Random();
        for (int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++){
                grid[row][col] = rand.nextInt(2);
            }
        }
    }
    public static void printGrid(int[][] grid){
        for (int[] ints : grid) {
            for (int col = 0; col < ints.length; col++) {
                System.out.print(ints[col] + " ");
            }
            System.out.println();
        }
    }
    public static int liveNeighbors(int[][] grid, int row, int col){
        int liveNeighbors = 0;
        if(grid[row-1][col-1] == 1) liveNeighbors++;
        if(grid[row-1][col] == 1) liveNeighbors++;
        if(grid[row-1][col+1] == 1) liveNeighbors++;
        if(grid[row][col-1] == 1) liveNeighbors++;
        if(grid[row][col+1] == 1) liveNeighbors++;
        if(grid[row+1][col-1] == 1) liveNeighbors++;
        if(grid[row+1][col] == 1) liveNeighbors++;
        if(grid[row+1][col+1] == 1) liveNeighbors++;
        return liveNeighbors;
    }

    public static int[][] findTargets(int[][] grid){                    //Finds target elements after applying the rules.
        for (int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++){
                int neighbors = liveNeighbors(grid, row, col);
                if(grid[row][col] == 0){
                    if(neighbors == 3) {
                        grid[row][col] = 5;                             //5 will be the key we use to mark the values that need to come alive.
                    }else{
                        continue;
                    }
                }else {
                    if (neighbors == 2 || neighbors == 3) {
                        grid[row][col] = 5;
                    } else {
                        grid[row][col] = 6;
                    }
                }
            }
        }
        return grid;
    }
    public static int[][] applyRules(int[][] grid){
        for (int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == 5) grid[row][col] = 1;
            }
        }
        return grid;
    }
}
