package conwaygame;
import java.util.ArrayList;
/**
 * Conway's Game of Life Class holds various methods that will
 * progress the state of the game's board through it's many iterations/generations.
 *
 * Rules 
 * Alive cells with 0-1 neighbors die of loneliness.
 * Alive cells with >=4 neighbors die of overpopulation.
 * Alive cells with 2-3 neighbors survive.
 * Dead cells with exactly 3 neighbors become alive by reproduction.

 * @author Seth Kelley 
 * @author Maxwell Goldberg
 */
public class GameOfLife {

    // Instance variables
    private static final boolean ALIVE = true;
    private static final boolean  DEAD = false;

    private boolean[][] grid;    // The board has the current generation of cells
    private int totalAliveCells; // Total number of alive cells in the grid (board)

    /**
    * Default Constructor which creates a small 5x5 grid with five alive cells.
    * This variation does not exceed bounds and dies off after four iterations.
    */
    public GameOfLife() {
        grid = new boolean[5][5];
        totalAliveCells = 5;
        grid[1][1] = ALIVE;
        grid[1][3] = ALIVE;
        grid[2][2] = ALIVE;
        grid[3][2] = ALIVE;
        grid[3][3] = ALIVE;
    }

    /**
    * Constructor used that will take in values to create a grid with a given number
    * of alive cells
    * @param file is the input file with the initial game pattern formatted as follows:
    * An integer representing the number of grid rows, say r
    * An integer representing the number of grid columns, say c
    * Number of r lines, each containing c true or false values (true denotes an ALIVE cell)
    */
    public GameOfLife (String file) {
        // WRITE YOUR CODE HERE
        StdIn.setFile(file);
        int r = StdIn.readInt();
        int c = StdIn.readInt();
        grid = new boolean[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                boolean temp = StdIn.readBoolean();
                grid[i][j] = temp;
                if(grid[i][j]==true) {
                    totalAliveCells++;
                }
                
            }
        }


    }

    /**
     * Returns grid
     * @return boolean[][] for current grid
     */
    public boolean[][] getGrid () {


        return grid;
    }
    
    /**
     * Returns totalAliveCells
     * @return int for total number of alive cells in grid
     */
    public int getTotalAliveCells () {
        // WRITE YOUR CODE HERE





        return totalAliveCells;
    }

    /**
     * Returns the status of the cell at (row,col): ALIVE or DEAD
     * @param row row position of the cell
     * @param col column position of the cell
     * @return true or false value "ALIVE" or "DEAD" (state of the cell)
     */
    public boolean getCellState (int row, int col) {
        // WRITE YOUR CODE HERE
        return grid[row][col];
    }

    /**
     * Returns true if there are any alive cells in the grid
     * @return true if there is at least one cell alive, otherwise returns false
     */
    public boolean isAlive () {

        // WRITE YOUR CODE HERE
        boolean alive = false;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == ALIVE) {
                    alive = true;
                } 
            }
        }
        return alive; // update this line, provided so that code compiles
    }

    /**
     * Determines the number of alive cells around a given cell.
     * Each cell has 8 neighbor cells which are the cells that are 
     * horizontally, vertically, or diagonally adjacent.
     * 
     * @param col column position of the cell
     * @param row row position of the cell
     * @return neighboringCells, the number of alive cells (at most 8).
     */
    public int numOfAliveNeighbors (int row, int col) {

        // WRITE YOUR CODE HERE
        /* 
        int numRows = grid.length;
        int numCols = grid[0].length;

        int aliveNeighbors = 0;
        //vertical
        //up
        if(grid[row-1][col] == ALIVE) {
            aliveNeighbors++;

        }  else if (IndexOutOfBoundsException){
            if(grid[numRows][col] == ALIVE) {
                aliveNeighbors++;
            }
        }
        //down
        if(grid[row+1][col] == ALIVE) {
            aliveNeighbors++;
        } else if (IndexOutOfBoundsException){
            if(grid[0][col] == ALIVE) {
                aliveNeighbors++;
            }
        }
        //horizontal
        //right
        if(grid[row][col+1] == ALIVE) {
            aliveNeighbors++;
        } else if (IndexOutOfBoundsException){
            if(grid[row][0] == ALIVE) {
                aliveNeighbors++;
            }
        }
        //left
        if(grid[row][col-1] == ALIVE) {
            aliveNeighbors++;
        } else if (IndexOutOfBoundsException){
            if(grid[row][numCols] == ALIVE) {
                aliveNeighbors++;
            }
        }
        //diagonals
        //topleft
        if(grid[row-1][col-1] == ALIVE) {
            aliveNeighbors++;
        } else if (IndexOutOfBoundsException){
            if(grid[numRows][numCols] == ALIVE) {
                aliveNeighbors++;
            }
        }
        //topright
        if(grid[row+1][col+1] == ALIVE) {
            aliveNeighbors++;
        } else if (IndexOutOfBoundsException){
            if(grid[numRows][numCols] == ALIVE) {
                aliveNeighbors++;
            }
        }
        */
        int aliveNeighbors = 0;
        int numRows = grid.length;
        int numCols = grid[0].length;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                int wrappedRow = (i + numRows) % numRows;
                int wrappedCol = (j + numCols) % numCols;

                if (!(wrappedRow == row && wrappedCol == col) && grid[wrappedRow][wrappedCol]) {
                    aliveNeighbors++;
                }
            }
        }
        return aliveNeighbors;



    }

    /**
     * Creates a new grid with the next generation of the current grid using 
     * the rules for Conway's Game of Life.
     * 
     * @return boolean[][] of new grid (this is a new 2D array)
     */
    public boolean[][] computeNewGrid () {
        // WRITE YOUR CODE HERE
        boolean [][] newGrid = getGrid();
        boolean [][] ruleOne = new boolean[grid.length][grid[0].length];
        boolean [][] ruleTwo = new boolean[grid.length][grid[0].length];
        boolean [][] ruleFour = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(numOfAliveNeighbors(i, j) <=1 ) {
                    ruleOne[i][j] = true;
                }
                if(!grid[i][j]) {
                    if(numOfAliveNeighbors(i, j) == 3) {
                        ruleTwo[i][j] = true; 
                    }
                }
                if(numOfAliveNeighbors(i, j) >= 4 ) {
                    ruleFour[i][j] = true;
                }
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(ruleOne[i][j]==true) {
                    newGrid[i][j] = false;
                }
                if(ruleTwo[i][j]==true) {
                    newGrid[i][j] = true;
                }
                if(ruleFour[i][j]==true) {
                    newGrid[i][j] = false;
                }
            }
        }

        return newGrid;// update this line, provided so that code compiles
    }

    /**
     * Updates the current grid (the grid instance variable) with the grid denoting
     * the next generation of cells computed by computeNewGrid().
     * 
     * Updates totalAliveCells instance variable
     */
    public void nextGeneration () {

        // WRITE YOUR CODE HERE
        grid = computeNewGrid();


    }

    /**
     * Updates the current grid with the grid computed after multiple (n) generations. 
     * @param n number of iterations that the grid will go through to compute a new grid
     */
    public void nextGeneration (int n) {

        // WRITE YOUR CODE HERE
        for(int i = 0; i < n; i++){

            grid = computeNewGrid();

        }

    }

    /**
     * Determines the number of separate cell communities in the grid
     * @return the number of communities in the grid, communities can be formed from edges
     */
    public int numOfCommunities() {

        // WRITE YOUR CODE HERE
        int rows = grid.length;
        int cols = grid[0].length;
        WeightedQuickUnionUF find = new WeightedQuickUnionUF(rows, cols);
        // for (int i = rows - 1; i <= rows + 1; i--) {
        //     for (int j = cols - 1; j <= cols + 1; j--) {
        //         int wrappedRow = (i + rows) % rows;
        //         int wrappedCol = (j + cols) % cols;
        //         if (!(wrappedRow == rows && wrappedCol == cols) && grid[wrappedRow][wrappedCol]) {
        //             if(grid[i][j]){
        //                 find.union(i, j, wrappedRow, wrappedCol);
        //             }
        //         }
        //     }
        // }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        int wrappedRow = (k + rows) % rows;
                        int wrappedCol = (l + cols) % cols;
                        if (!(wrappedRow == i && wrappedCol == j) && grid[wrappedRow][wrappedCol]) {
                            if(grid[i][j]){
                                find.union(i, j, wrappedRow, wrappedCol);
                            }
                        }
                    }
                }
            }
        }

        int numOfCommunities = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j]==true) {
                    int node = find.find(i,j);
                    if(node == i*cols+j) {
                        numOfCommunities++;

                    }
                    
                }
            }
        }
    
        return numOfCommunities; // update this line, provided so that code compiles
    }
}
