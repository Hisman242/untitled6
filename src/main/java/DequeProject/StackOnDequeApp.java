package DequeProject;

public class StackOnDequeApp {
    public static void main(String[] args) {
        StackOnDeque stackOnDeque = new StackOnDeque(10);
        stackOnDeque.push(5);
        stackOnDeque.push(3);
        stackOnDeque.push(2);
        stackOnDeque.push(1);
        stackOnDeque.push(4);
        stackOnDeque.push(6);
        stackOnDeque.push(7);
        stackOnDeque.push(8);
        stackOnDeque.push(9);
        stackOnDeque.push(10);
        System.out.println(stackOnDeque.pop());
        System.out.println(stackOnDeque.peek());
        System.out.println(stackOnDeque);
    }
}
