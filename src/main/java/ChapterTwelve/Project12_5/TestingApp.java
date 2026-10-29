package ChapterTwelve.Project12_5;

public class TestingApp {
    public static void main(String[] args) {
        Heap theHeap = new Heap();
        System.out.println(theHeap.path(6));
        theHeap.insert(70);
        theHeap.insert(40);
        theHeap.insert(50);
        theHeap.insert(20);
        theHeap.insert(1000);

        theHeap.displayTree();
        System.out.println(theHeap.change(1, 1));
        theHeap.displayTree();
    }
}
