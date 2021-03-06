Brainz (Programming puzzle, Common algorithms repository)
=========================================================
1. ProjectEuler: Contains solutions for projecteuler.net puzzles.
2. Leetcode: Solution to leetcode.com algorithm problems.
3. InterviewBits: Solution to inteviewbits.com puzzles.
4. Sorting: C++ implementation of few simple sorting algorithms.

Important Java methods and techniques to solve problems faster
==============================================================
1. Fill an array with a single value
    ```java
    Arrays.fill(intArray,1);
    ```

2. Convert an array to linked list
    ```java
    Integer[] arr = {1, 2, 3};
    List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
    ```
    Notice arr of Integer array not int array
    
3. Print an array
    ```java
    System.out.println(Arrays.asString(arr));
    ```

Must know data structure in java
================================
1. List : ArrayList, LinkedList
2. HashTable
3. Stack
4. Deque: ArrayDeque, ConcurrentLinkedDeque, LinkedBlockingDeque, LinkedList

Iterating collection:
=====================
1. Iterate a HashMap
2. Iterate a PriorityQueue

Java Generics
=============
1. Implement a QuickSort using the java API to sort a custom object.
2. Implement Heap data structure.
3. [Difference](http://stackoverflow.com/questions/40471/differences-between-hashmap-and-hashtable) between HashTable and HashMap. 
4. Concrete [implementation](https://docs.oracle.com/javase/tutorial/collections/implementations/index.html) of interface collections.
5. Read the [Collections](https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html) APIs.
 
C++ Pair equivalent in Java
===========================
Pair is not natively supported in Java but we can use Map.Entry object to achieve the same objective.

Concrete implementations of Map.Entry.
1. AbstractMap.SimpleEntry<K,V>
2. AbstractMap.SimpleImmutableEntry<K,V>

Finding length/size of various Collection objects
=================================================
1. Array: array.length
2. String: string.length()
3. Collection object(Stack, Queue, List): object.size()

String and character
====================
* Convert a integer to character
    ```java
    Character.forDigit(int_value, 10);
    ```
* Convert a String to character array
    ```java
    string.toCharArray()
    ```

Reference examples
==================
1. [Combination sum](https://discuss.leetcode.com/topic/44037/combination-sum-i-ii-and-iii-java-solution-see-the-similarities-yourself)
2. [Search an element in rotated array](https://github.com/abnayak/brainz/blob/master/Leetcode/SearchRotatedSortedArray.java)

String problems
===============
1. [Multiply to strings (only containing number) to generate a string](https://github.com/abnayak/brainz/blob/master/InterviewBit/Strings/MultiplyStrings.java)

Two Pointers
============
1. [Count the number of possible triangles](http://www.geeksforgeeks.org/find-number-of-triangles-possible/)
2. [Biggest rectangle in a histogram](https://github.com/abnayak/brainz/blob/master/InterviewBit/TwoPointer/ContainerWithMostWater.java)

Parenthesis Validation
======================

BackTrack
=========
1. https://www.interviewbit.com/problems/palindrome-partitioning/

Hashing
=======
1. [Find the length of the longest consecutive elements sequence in a given array](https://www.interviewbit.com/problems/longest-consecutive-sequence/)

Integer conversions
===================
String to int: Integer.parseInt("1");
Char to int: Character.getNumericValue('1');
int to String: Integer.toString(1);

Problem Collection
==================
Find all unique combinations in an array where sum equals to a value
https://leetcode.com/problems/combination-sum-ii/

Find subsets of set with unique elements
https://www.interviewbit.com/problems/subset/

Find unique subsets with duplicates:
https://www.interviewbit.com/problems/subsets-ii/

Find unique permutations with duplicates:
https://www.interviewbit.com/problems/all-unique-permutations/

Find all the permutations of a set
https://www.interviewbit.com/problems/permutations/

Find the largest continuous sequence in a array which sums to zero.
https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/

Dynamic Problem collection

Find Bitonic (first increasing then decreasing) subsequence in an Array
https://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/

