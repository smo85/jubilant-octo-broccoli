/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private int[][] percolationArray;
    private int numberOfOpenSites = 0;
    private int nSize = 0;
    private int bottomVirtualSite = 0;

    private WeightedQuickUnionUF percolationUnionArray;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        setPercolationArray(new int[n][n]);
        percolationUnionArray = new WeightedQuickUnionUF(n * n + 2);

        nSize = n;
        bottomVirtualSite = n * n + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkBounds(row, col);
        // check if open already
        if (percolationArray[row][col] != 1) {
            // open
            percolationArray[row][col] = 1;

            int openSiteValue = getUnionValue(row, col);
            // StdOut.printf("open site: %d%n", openSiteValue);
            // connect to virtual site
            if (row == 0) {
                percolationUnionArray.union(openSiteValue, 0);
            }
            if (row == (nSize - 1)) {
                percolationUnionArray.union(openSiteValue, bottomVirtualSite);
            }

            // increment num open sites
            numberOfOpenSites++;

            // connect to all adjacent open sites
            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < nSize && newCol >= 0 && newCol < nSize
                        && percolationArray[newRow][newCol] == 1) {

                    percolationUnionArray.union(openSiteValue, getUnionValue(newRow, newCol));
                }
            }
        }
    }

    private int getUnionValue(int row, int col) {
        return row * nSize + col + 1;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkBounds(row, col);
        return percolationArray[row][col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkBounds(row, col);
        if (isOpen(row, col)) {
            int unionFindValue = getUnionValue(row, col);
            return percolationUnionArray.find(unionFindValue) == percolationUnionArray.find(0);
        }
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return percolationUnionArray.find(bottomVirtualSite)
                == percolationUnionArray.find(0);
    }

    public static void main(String[] args) {

    }

    public int[][] getPercolationArray() {
        return percolationArray;
    }

    public void setPercolationArray(int[][] percolationArray) {
        this.percolationArray = percolationArray;
    }

    private void checkBounds(int row, int col) {
        if (row < 0 || row >= nSize || col < 0 || col >= nSize) {
            throw new IllegalArgumentException("row or col must be within range");
        }
    }
}
