package ChapterTen.Project10_1;

public class MinimumTest {
    public static void main(String[] args) {
        long value;
        Tree234 theTree = new Tree234();

        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);
        System.out.println("Displaying the minimum: " + theTree.findMin());
    }
}
