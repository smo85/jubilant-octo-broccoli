/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class HelloGoodbye {
    public static void main(String[] args) {
        String[] nameArray = args;
        StdOut.println("Hello" + Arrays.toString(args));
        StdOut.println("Goodbye" + Arrays.toString(args));
    }
}
