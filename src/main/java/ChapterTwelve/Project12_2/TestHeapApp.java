package ChapterTwelve.Project12_2;

public class TestHeapApp {
    public static void main(String[] args) {
        Heap heap = new Heap(32);
        System.out.println("Application started");
        heap.insert(10);
        heap.insert(2);
        heap.insert(22);
        heap.insert(30);
        System.out.println("Printing the original heap");
        heap.displayHeap();
        heap.toss(4);
        heap.toss(20);
        heap.toss(50);
        heap.toss(32);
        System.out.println("Outputting un-heapified pyramid");
        heap.displayHeap();
        heap.restoreHeap();
        System.out.println("Printing the heapified pyramid");
        heap.displayHeap();
        System.out.println("Application ended");
    }
}
