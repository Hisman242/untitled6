package ChapterNine.Project9_1;

public class RedBlackTree {
    public static void main(String[] args) {
        int value;
        Tree theTree = new Tree();

        theTree.insert(50, 1.5);
        theTree.insert(25, 1.2);
        theTree.insert(75, 1.7);
        theTree.insert(12, 1.5);
        theTree.insert(37, 1.2);
        theTree.insert(43, 1.7);

        theTree.displayTree();
    }
}
