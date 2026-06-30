package DequeProject;

public class DeQueApp {
    public static void main(String[] args) {
        Deque deque = new Deque(5);
        deque.insertLeft(10);
        deque.insertLeft(20);
        System.out.println(deque.removeLeft()); // должно быть 20
        Deque d = new Deque(5);
        d.insertRight(10);
        System.out.println(d.removeRight()); // должно быть 10
    }
}
