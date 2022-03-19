
/**
 * MinHeap (Recursive)
 * This is a minHeap (smallest value is the top of the heap)
 *
 * <p>
 *     Min Heap
 *     Explaining Code Logic:
 *     [Summary]: Min heap is where every parent node, including the root is LESS than/equal to it's child nodes.
 *     In short: Parent < Child.
 *
 *      [*] An important feature of MinHeaps is that the smallest or minimum value will always be the root.
 *
 *      This MinHeap program has multiple functions. I will explain them abstractly here in the header:
 *      1. add(key): pushes node to the bottom level, leftmost node of the heap
 *      2. heapify(): creates a heap out of given elements, moves the nodes up the tree until the condition that Parent < Child has been satisfied
 *      3. extract(): removes and returns the min element, followed by moving the last node to the top and "sifting" to maintain the heap
 *      4. removeLast(): removes the last node in the heap.
 *      5. getSize(): the most complex function in this program and possibly all of ICS4U. returns the size of heap.
 * </p>
 *
 * @author UnloadingGnat
 * @date 2022/01/14
 */

public class MinHeap {
    // Attributes
    boolean empty = true;
    int data = 0;
    int size = 0;
    MinHeap left = null;
    MinHeap right = null;

    /**
     * Constructor
     */
    public MinHeap() {
        this.data = 0;
        this.size = 0;
        this.empty = true;
    }

    /**
     * Constructor
     * @param key data
     */
    public MinHeap(int key) {
        this.data = key;
        this.size = 1;
        this.empty = false;
    }

    /**
     * Add a node to the tree - add the key to the  bottom of the heap, then bubble up with heapify
     * @param key data
     */
    public void add(int key) {
        // Is the tree empty
        if (this.empty) {
            this.data = key;
            this.empty = false;
        }
        // adds child to left/right lead of root
        else if (this.size == 1) {
            this.left = new MinHeap(key);
        }
        else if (this.size == 2) {
            this.right = new MinHeap(key);
        }
        // recurse to add a key to the heaps bottom level and leftmost node.
        else {
            // Neat math trick to determine the direction to go
            double logI = Math.log(this.size+1)/Math.log(2);
            logI = logI - Math.floor(logI);
            if (logI < 0.5) {
                this.left.add(key);
            } else {
                this.right.add(key);
            }
        }
        this.size++;

        // Need to reHeapify
        this.heapify();
    }

    /**
     *  Fix the heap from the top down. if a node is smaller than it's parent, swap the elements.
     */
    public void heapify() {
        // check if either children are smaller
        MinHeap smallest = null;
        if (this.left != null && this.left.data < this.data) {
            smallest = this.left;
        }
        if (this.right != null && this.right.data <  this.data && this.right.data < this.left.data) {
            smallest = this.right;
        }

        // Swap the smallest to the top
        if (smallest != null) {
            // We will cheat a little by only swapping the data and not the entire node
            int temp = this.data;
            this.data = smallest.data;
            smallest.data = temp;

            // Recursively
            smallest.heapify();
        }
    }

    /**
     * extract - Extract the smallest number in the heap
     * @return result the element extracted from heap
     */
    public int extract() {
        // get smallest element, and replace with last element, then sink down/shift the tree downwards
        int result = this.data;
        int last = this.removeLast();

        // replace the lowest level right most node, with the top node.
        if (this.size > 0) {
            this.data = last;
            // sink down/ shifts the tree down
            this.heapify();
        }
        return result;
    }

    /**
     * removeLast - Remove the lowest level of the heap's, right most node.
     *
     * @return the last node of the heap
     */
    private int removeLast() {
        int result = -1;

        // remove if node has no children,
        if (this.size == 1) {
            result = this.data;
            this.data = 0;
            this.empty = true;
        }
        // remove left child and return child's data
        else if (this.size == 2) {
            result = this.left.data;
            this.left = null;
        }
        // remove right child and return child's data
        else if (this.size == 3) {
            result = this.right.data;
            this.right = null;
        }
        // recurse to lowest level, right most node of the heap
        else {
            // determine which direction to go
            double logI = Math.log(this.size)/Math.log(2);
            logI = logI - Math.floor(logI);
            if (logI < 0.5) {
                result = this.left.removeLast();
            } else {
                result = this.right.removeLast();
            }
        }
        this.size--;
        return result;
    }

    /**
     * Return the size of the Heap
     * @return size
     */
    public int getSize() {
        return this.size;
    }
}
