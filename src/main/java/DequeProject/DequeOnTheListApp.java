package DequeProject;

public class DequeOnTheListApp {
    public static void main(String[] args) {
        DequeOnTheList  myList = new DequeOnTheList();
        myList.insertLeft(10);
        myList.insertRight(20);
        myList.display();
        myList.insertRight(42);
        myList.insertRight(92);
        myList.insertRight(34);
        myList.insertRight(92);
        myList.insertRight(44);
        myList.insertRight(32);
        myList.display();
        System.out.println(myList.removeLeft());
        System.out.println(myList.removeLeft());
        System.out.println(myList.removeLeft());
        myList.display();
    }
}
