package Matrix;

public class TwoDimensionalLinkedListApp {
    public static void main(String[] args) {
        TwoDimensionalLinkedList twoDimensionalLinkedList = new TwoDimensionalLinkedList(10, 10);
        twoDimensionalLinkedList.insert(2,0,0);
        twoDimensionalLinkedList.insert(2,0,1);
        twoDimensionalLinkedList.insert(2,0,2);
        twoDimensionalLinkedList.insert(2,0,3);
        twoDimensionalLinkedList.insert(2,0,4);
        twoDimensionalLinkedList.insert(2,0,5);
        twoDimensionalLinkedList.insert(2,0,6);
        twoDimensionalLinkedList.insert(3,1,0);
        twoDimensionalLinkedList.insert(2,2,3);

        twoDimensionalLinkedList.insert(6,7,3);
        twoDimensionalLinkedList.insert(5,7,6);
        twoDimensionalLinkedList.insert(9,9,9);

        twoDimensionalLinkedList.display();
    }
}
