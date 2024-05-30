The purpose of this project is to practice understanding 2D arrays and union-find.

Conway Game of Life is a cellular discrete model of computation devised by John Horton Conway. The game consists of a game board (grid) of n x m cells, each in one of two states, alive or dead.

The game starts with an initial pattern, then it will change what cells are alive or dead from one generation to the next depending on a set of rules. As the Game of Life continues, the game will keep making a new generation (based on the preceding one) until it reaches one of three states.

Cells
Each cell can be in one of two states, alive or dead, and it has 8 neighboring cells which are the cells that are horizontally, vertically, or diagonally adjacent. The figure below exemplifies neighboring cells on a game board of 4 x 4 cells.

Rules of the Game
The game starts with a initial set of alive cells (this is the first generation). The next generation evolves from applying the following rules simultaneously to every cell on the game board, i.e. births and deaths happen simultaneously. Afterwards, the rules are iteratively applied to create future generations. Each generation depends exclusively on the preceding one.

States for the Game
There are three states that the game can reach in regards to the rules provided.

There are no more living cells for the next generation.
There are living cells, but the next generation is the same as the last (stable game).
The next generation infinitely cycles throughout the game.

Note that there are more scenarios for states 2 and 3, these are just one example for each.

1. GameOfLife – One argument constructor 
This method builds your game board (grid) from the input file (initial game pattern).
You have been provided some input files to test this method (input1.txt, input2.txt, input3.txt). The format is as follows:
One line containing the number of rows in the board game
One line containing the number of columns in the board game
Several lines (one for each row) containing the cell state (false for dead, true for alive) for each column in the board, space separated
Use the StdIn library to read from a file:

StdIn.setFile(filename) opens a file to be read
StdIn.readInt() reads the next integer value from the opened file (weather the value is in the current line or in the next line)
StdIn.readBoolean() read the next boolean value from the opened file (weather the value is in the current line or in the next line)
Submit this method and the getCellState() method under “Early Submission” for extra credit. 

2. getCellState
Given two integers representing the cell row and column this method returns true if the cell is alive and false if the cell is dead.

Test this method using the driver:

upon clicking the button Cell State you will be prompted to select a cell
select a cell by clicking in one square
the selected cell will light up red and the driver will state whether the cell is living or dead.
Submit this method and the one argument constructor under “Early Submission” for extra credit.

Example with default constructor
3. isAlive
Returns true or false based on whether or not there are living cells within the board (grid)

Test this method using the driver. Click on the Is Alive button and the driver will display whether or not there are living cells on the board game.


Example with default constructor
4. numOfAliveNeighbors
Given two integers representing the cell row and column this method returns the cell’s number of alive neighbors of a maximum of 8 neighbors.

Test this method using the driver:

upon clicking the button Alive Neighbors you will be prompted to select a cell
select a cell by clicking in one square
the selected cell will light up red and the driver will state the total number of alive cells around the selected cell

Example with default constructor
5. computeNewGrid
This is where you will be using the rules of the game (stated above) to compute the next generation of cells.

create a new board (grid) to be returned, representing the new generation
for each cell, use the numOfAliveNeighbors method to determine how many cells are alive around a cell
then using the number of alive neighbors with the rules of the game determine if the cell will be set to be alive or dead in the new grid
6. nextGeneration
Update the board (grid) with the board returned by the computeNewGrid method.

Test this and the computeNewGrid methods using the driver by clicking the Next Generation button.

The driver will state Next generation calculated.


Example with default constructor
7. nextGeneration – One argument
The input integer parameter represents the number of generations to compute (fast forward).

Test this methods using the driver: 

upon clicking the Next N Generations button you will be prompted to enter a number
enter a number and click the Submit button
the driver will state that the board has evolved the number of generations requested

Example with default constructor

8. numberOfCommunities
This method computes and returns the number of separate communities of cells in the board. A community is made of connected cells.

Recall that Union-Find keeps track of connected components. In this assignment each connected component is a community of cells (all the cells in the community are connected).
Cells from separate communities are not connected.
In algorithm Weighted Quick Union UF each community (connected component) is a tree. The community’s representative is the root of the tree.

To connect two cells use the union method
To find the root of the tree a cell belongs to use the find method
To find the number of communities count the number of unique roots of trees
Test this methods using the driver by clicking the Communities button.

The driver will state the number of communities currently on the board.



Description Written by Seth Kelly and Maxwell Goldberg, Code implemented by Abhishek Sancheti
