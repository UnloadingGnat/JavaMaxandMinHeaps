# JavaMaxandMinHeaps
  Max/MinHeap I implemented in Java
  

[Max Heap](src/MaxHeap.java)    
Explaining Code Logic:
[Summary]: Max heap is similar to MinHead, but every parent node, including the root is GREATER than/equal to it's child nodes.
In short: Parent > Child.

 [*] An important feature of MaxHeaps is that the Largest or maximum value will always be the root.

---
[Min Heap](src/MinHeap.java)    
Explaining Code Logic:
[Summary]: Min heap is where every parent node, including the root is LESS than/equal to it's child nodes.
In short: Parent < Child.

[*] An important feature of MinHeaps is that the smallest or minimum value will always be the root.
 
---

       This heap program has multiple functions. I will explain them here:
       1. add(key): pushes node to the bottom level, leftmost node of the heap
       2. heapify(): creates a heap out of given elements, moves the nodes up the tree until the condition that Parent > Child has been satisfied
       3. extract(): removes and returns the min element, followed by moving the last node to the top and "sifting" to maintain the heap
       4. removeLast(): removes the last node in the heap.
       5. getSize(): the most complex function in this program and possibly all of Comp Sci. returns the size of heap.
