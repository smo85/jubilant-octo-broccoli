/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static final int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private boolean[][] percolationArray;
    private int numberOfOpenSites = 0;
    private int nSize;
    private int bottomVirtualSite;

    private WeightedQuickUnionUF percolationUnionArray;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        setPercolationArray(new boolean[n][n]);
        percolationUnionArray = new WeightedQuickUnionUF(n * n + 2);

        nSize = n;
        bottomVirtualSite = n * n + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkBounds(row, col);
        int r = row - 1;
        int c = col - 1;
        // check if open already
        if (!percolationArray[r][c]) {
            // open
            percolationArray[r][c] = true;

            int openSiteValue = getUnionValue(r, c);
            // StdOut.printf("open site: %d%n", openSiteValue);
            // connect to virtual site
            if (r == 0) {
                percolationUnionArray.union(openSiteValue, 0);
            }
            if (r == (nSize - 1)) {
                percolationUnionArray.union(openSiteValue, bottomVirtualSite);
            }

            // increment num open sites
            numberOfOpenSites++;

            // connect to all adjacent open sites
            for (int[] dir : DIRECTIONS) {

                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if (newRow >= 0 && newRow < nSize && newCol >= 0 && newCol < nSize
                        && percolationArray[newRow][newCol]) {

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
        int r = row - 1;
        int c = col - 1;
        return percolationArray[r][c];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkBounds(row, col);
        int r = row - 1;
        int c = col - 1;
        if (isOpen(row, col)) {
            int unionFindValue = getUnionValue(r, c);
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

    public boolean[][] getPercolationArray() {
        return percolationArray;
    }

    public void setPercolationArray(boolean[][] percolationArray) {
        this.percolationArray = percolationArray;
    }

    private void checkBounds(int row, int col) {
        if (row < 1 || row > nSize || col < 1 || col > nSize) {
            throw new IllegalArgumentException("row or col must be within range");
        }
    }
}
