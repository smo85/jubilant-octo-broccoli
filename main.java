/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class main {
    public static void main(String[] args) {
        String n = args[0];
        StdOut.println("T: " + args[1]);
        Percolation testPerc = new Percolation(Integer.parseInt(n));
        System.out.println(testPerc.getPercolationArray().length);
        System.out.println(testPerc.isOpen(2, 2));
        testPerc.open(0, 0);
        testPerc.open(1, 1);
        testPerc.open(1, 2);
        testPerc.open(0, 1);
        testPerc.open(2, 2);
        StdOut.println(testPerc.numberOfOpenSites());
    }
}
