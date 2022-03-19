
/**
 * Max/Min Heap Driver program
 *
 * @author UnloadingGnat
 * @date 2022/01/14
 *
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Heap Test!");
        MaxHeap myHeap = new MaxHeap();
//        MinHeap myHeap = new MinHeap();

        // 6 values to the heap
        myHeap.add(12);
        myHeap.add(10);
        myHeap.add(23);
        myHeap.add(10);
        myHeap.add(10);
        myHeap.add(69);
        myHeap.add(101);
        myHeap.add(6);
        myHeap.add(1);

        // Remove them all (heapSort)
        while(myHeap.getSize() > 0) {
            System.out.print(myHeap.extract()+" ");
        }
        System.out.println();

        System.out.println("All Done");
    }
}

