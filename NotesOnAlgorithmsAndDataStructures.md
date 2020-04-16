# Notes on Algorithms and Data Structures

| Name | type | Best Case Time Complexity | Average Case Time Complexity | Worse Case Time Complexity|Auxiliary Space | Stable | Adaptive |
|----|----|-------------------------|----------------------------|--------------------------|---------------|------|--------|
|C’s qsort()|Quicksort|O(NlogN)|O(NlogN)|O(N2)|O(log N)|Depends on the implementation of the comparator function|No|
|C++’s sort()|Introsort (Hybrid of Quicksort, Heap Sort and Insertion Sort)|O(NlogN)|O(NlogN)|O(NlogN)|O(logN)|No|No|
|C++’s stable_sort()|Mergesort|O(NlogN)|O(NlogN)|O(NlogN)|O(N)|Yes|Yes|
|Java 6’s Arrays.sort()|Quicksort|O(NlogN)|O(NlogN)|O(N2)|O(logN)|Depends|No|
|Java 7’s Arrays.sort()|Timsort (Hybrid of Mergesort and Insertion Sort)|O(N)|O(NlogN)|O(NlogN)|O(N)|Yes|Yes|
|Java’s Collections.sort()|Mergesort|O(NlogN)|O(NlogN)|O(NlogN)|O(N)|Yes|Yes|

|type|Average Access|Average Search|Average Insertion|Average Deletion|Worst Access|Worst Search|Worst Insertion|Worst Deletion|Space Complexity|
|--------|--------|--------|--------|--------|--------|--------|--------|--------|--------|
|Array|O(1)|O(n)|O(n)|O(n)|O(1)|O(n)|O(n)|O(n)|O(n)|
|Stack|O(n)|O(n)|O(1)|O(1)|O(n)|O(n)|O(1)|O(1)|O(n)|
|Queue|O(n)|O(n)|O(1)|O(1)|O(n)|O(n)|O(1)|O(1)|O(n)|
|Singly-Linked List|O(n)|O(n)|O(1)|O(1)|O(n)|O(n)|O(1)|O(1)|O(n)|
|Doubly-Linked List|O(n)|O(n)|O(1)|O(1)|O(n)|O(n)|O(1)|O(1)|O(n)|
|Hash Table|N/A|O(1)|O(1)|O(1)|N/A|O(n)|O(n)|O(n)|O(n)|
|Binary Search Tree|O(log(n))|O(log(n))|O(log(n))|O(log(n))|O(n)|O(n)|O(n)|O(n)|O(n)|
|B-Tree|O(log(n))|O(log(n))|O(log(n))|O(log(n))|O(log(n))|O(log(n))|O(log(n))|O(log(n))|O(n)|
|AVL Tree|O(log(n))|O(log(n))|O(log(n))|O(log(n))|O(log(n))|O(log(n))|O(log(n))|O(log(n))|O(n)|

|Type|Best Time|Average Time|Worst Time|Worst Space|
|---|---|---|---|---|
|Quicksort|Ω(n log(n))|O(n log(n))|O(n^2)|O(log(n))|
|Mergesort|Ω(n log(n))|O(n log(n))|O(n log(n))|O(n)|
|Timsort|Ω(n)|O(n log(n))|O(n log(n))|O(n)|
|Heapsort|Ω(n log(n))|O(n log(n))|O(n log(n))|O(1)|
|Bubble Sort|Ω(n)|O(n^2)|O(n^2)|O(1)|
|Insertion Sort|Ω(n)|O(n^2)|O(n^2)|O(1)|
|Selection Sort|Ω(n^2)|O(n^2)|O(n^2)|O(1)|
|Tree Sort|Ω(n log(n))|O(n log(n))|O(n^2)|O(n)|

Stability:
A sorting algorithm is said to be stable if two objects with equal keys appear in the same order in sorted output as they appear in the input array to be sorted.

Adaptive:
If order of the elements to be sorted of an input array matters (or) affects the time complexity of a sorting algorithm.
