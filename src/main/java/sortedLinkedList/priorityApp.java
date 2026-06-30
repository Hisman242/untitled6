package sortedLinkedList;

public class priorityApp {
    public static void main(String[] args) {
        PriorityQueSortList list = new PriorityQueSortList();
        list.insert(11);
        list.insert(234);
        list.insert(3342);
        list.insert(4);
        list.insert(53);
        list.insert(6);
        list.insert(8);
        list.insert(9);
        list.insert(18);
        list.insert(29);
        list.insert(43);
        list.display();
        System.out.println(list.peekMin());
        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list.remove());
        list.display();
        System.out.println(list.isEmpty());
    }
}
