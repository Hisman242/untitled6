package queueProject;
public class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(5);

        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        System.out.println("Initial queue:");
        theQueue.display();

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        System.out.println("After removing 3 elements:");
        theQueue.display();

        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        System.out.println("After inserting 4 more elements:");
        theQueue.display();

        System.out.println("Removing all elements:");
        while (!theQueue.isEmpty()) {
            long n = theQueue.remove();
            System.out.print(n + " ");
        }

        System.out.println();
    }
}
