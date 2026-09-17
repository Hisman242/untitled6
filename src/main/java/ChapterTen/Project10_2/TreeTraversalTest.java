package ChapterTen.Project10_2;

public class TreeTraversalTest {
    public static void main(String[] args) {
        long value;
        Tree234 theTree = new Tree234();
        theTree.insert(1);
        theTree.insert(3);

        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(1000);
        theTree.insert(1002);
        theTree.insert(232);

        theTree.insert(30);
        theTree.insert(70);

        theTree.inOrd();
    }
}
