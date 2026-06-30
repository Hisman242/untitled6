package circularList;

public class CircularListApp {
    public  static void main(String[] args) {
        CircularList list = new CircularList();
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(10);
        list.insert(55);
        list.display();
        list.remove(20);
        list.display();
        list.step();
        list.display();
        list.step();
        list.display();
    }
}
