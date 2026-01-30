/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] percolationArray;
    private int numberOfOpenSites = 0;
    private int arraySize = 0;

    private WeightedQuickUnionUF percolationUnionArray;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        setPercolationArray(new int[n][n]);
        percolationUnionArray = new WeightedQuickUnionUF(n * n);
        arraySize = n;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        // check if open already
        // open
        if (percolationArray[row][col] != 1) {
            percolationArray[row][col] = 1;
        }
        // increment num open sites
        numberOfOpenSites++;
        int openSiteValue = getUnionValue(row, col);
        // connect to all adjacent open sites
        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < arraySize && newCol >= 0 && newCol < arraySize
                    && percolationArray[newRow][newCol] == 1) {

                percolationUnionArray.union(openSiteValue, getUnionValue(newRow, newCol));
            }
        }

        System.out.printf("The are connected: %b%n",
                          percolationUnionArray.find(8) == percolationUnionArray.find(0));
    }

    private int getUnionValue(int row, int col) {
        return row * arraySize + col;  // i think something is fishy here
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return percolationArray[row][col] == 1;
    }

    // // is the site (row, col) full?
    // public boolean isFull(int row, int col)
    //
    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // // does the system percolate?
    // public boolean percolates()

    public static void main(String[] args) {

    }

    public int[][] getPercolationArray() {
        return percolationArray;
    }

    public void setPercolationArray(int[][] percolationArray) {
        this.percolationArray = percolationArray;
    }
}
