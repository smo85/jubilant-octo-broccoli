## Description
Working through the [Algorithms I course on Coursera](https://www.coursera.org/learn/algorithms-part1)

## Modules

### Module 1 - Course Intro
✅ TODO Wednesday - Finish HelloGoodbye program and submit; start Module 2 video

### Module 2 - Union-Find
- Dynamic Connectivity - introdueced a problem where we want to be able to connect and see if connected a set of numbers
- Quick-find
    - data structure - integer array of size n
    - find - check if p & q have same id
    - union - the merge componenets p and q, change all entries whose id equals id[p] to id[q]
    - this is n^2 time complexity -> quadratic algorothms do not scale
- Quick-union
    - data structure - integer array size n
    - find - check if p and q have same root
    - union - to merge p and q, set id of p's root to q's root
    - this is n time, so still too slow for large amounts of data
✅ TODO: Monday - finish module 2 lectures
- Quick-union improvements
    - weighted quick union
        - always put smaller tree to root of larger tree; need extra array to tracks size of trees
        - at most, lgN
    - path compression - make every node point to its grandparent
        - for a billion operations - reduces time from 30 years to 6 seconds
- Union find applications
    - dynamic connectivity for networks, image processing
✅ TODO: Wednesday - read interview questions
✅ TODO Friday - answer interview questions
✅ TODO Monday (Tuesday since we have Monday off) - read through HW and develop a plan
Percolation HW
- PROBLEM: write a program to estimate p* - the threshold value that determines whether or not a system will percolate
- main: takes two command line args n and T, performs T experiments on n-by-n grid and prints:
  - sample mean, sample standard deviation, and the 95% confidence interval for the percolation threshold
  - Use StdRandom to generate random numbers; use StdStats to compute the sample mean and sample standard deviation
- data type:
  - Percolation
    - implement the Percolation data type using the weighted quick union algorithm in WeightedQuickUnionUF
  - PercolationStats
- corner case: Throw an IllegalArgumentException if any argument to open(), isOpen(), or isFull() is outside its prescribed range. Throw an IllegalArgumentException in the constructor if n ≤ 0.
- monte carlo: all sites are blocked, add 1 random open until the system percolates - fraction of open sites is p*; repeating the experiment many times gives a rough p*
- optional: analyze run time and mem
- may not call library functions except those in StdIn, StdOut, StdRandom, StdStats, WeightedQuickUnionUF, and java.lang.

✅ TODO Wednesday - create main and start on percolation data type
create main to take in two command line args

TODO Friday - continue implementing the percolation data type
implement the percolation data type
implement the stats
