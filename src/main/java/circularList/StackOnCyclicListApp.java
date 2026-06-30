package circularList;

public class StackOnCyclicListApp {
    public static void main(String[] args) {
        StackOnCyclicList s = new StackOnCyclicList();
        s.push(2);
        s.push(2);
        s.push(3);
        s.push(24);
        s.push(2222);
        System.out.println(s.isEmpty());
        s.display();
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
