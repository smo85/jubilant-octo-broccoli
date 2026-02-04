/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] percolationThreshold;
    private int numTrials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        percolationThreshold = new double[trials];
        numTrials = trials;
        for (int i = 0; i < trials; i++) {
            Percolation experiment = new Percolation(n);
            while (!experiment.percolates()) {
                int randomRowToOpen = StdRandom.uniformInt(n);
                int randomColToOpen = StdRandom.uniformInt(n);
                experiment.open(randomRowToOpen, randomColToOpen);
            }
            percolationThreshold[i] = (double) experiment.numberOfOpenSites() / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(percolationThreshold);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(percolationThreshold);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return this.mean() - ((1.96 * this.stddev()) / Math.sqrt(numTrials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return this.mean() + ((1.96 * this.stddev()) / Math.sqrt(numTrials));
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats testStats = new PercolationStats(n, t);
        StdOut.printf("mean:                    = %f\n", testStats.mean());
        StdOut.printf("stddev:                  = %f\n", testStats.stddev());
        StdOut.printf("95%% confidence interval: = [%f, %f]\n", testStats.confidenceLo(),
                      testStats.confidenceHi());
    }

}
