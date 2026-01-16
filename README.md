## Description
Working through the [Algorithms I course on Coursera](https://www.coursera.org/learn/algorithms-part1)

## Modules

### Module 1 - Course Intro
✅ TODO Wednesday - Finish HelloGoodbye program and submit; start Module 2 video

### Module 2 - Union-Find
- Dynamic Connectivity - introdueced a problem where we want to be able to connect and see if connected a set of numbers
- Quick-find
    - data structure - intefer array of size n
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
