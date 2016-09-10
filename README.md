Brainz (Programming puzzle, Common algorithms repository)
=========================================================
1. ProjectEuler: Contains solutions for projecteuler.net puzzles.
2. Leetcode: Solution to leetcode.com algorithm problems.
3. InterviewBits: Solution to inteviewbits.com puzzles.
4. sorting: C++ implementation of few simple sorting algorithms.

Important Java methods and techniques to solve problems faster
==============================================================
1. Fill an array with a single value
    Arrays.fill(intArray,1);

2. Convert an array to Linked list

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
    Character.forDigit(int_value, 10);