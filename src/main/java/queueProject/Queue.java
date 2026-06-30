package queueProject;

import java.nio.Buffer;

class Queue {
    private int maxSize;
    private long[] queArray;
    private int front; //это место, откуда будет удалён следующий элемент.
    private int rear; //это место, куда был вставлен последний элемент.
    private int nItems; //хранит количество элементов в очереди прямо сейчас.

    //--------------------------------------------------------------
    public Queue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    //--------------------------------------------------------------
    public void insert(long j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }

        queArray[++rear] = j;
        nItems++;
    }

    //--------------------------------------------------------------
    public long remove() {
        long temp = queArray[front++];

        if (front == maxSize) {
            front = 0;
        }

        nItems--;
        return temp;
    }

    //--------------------------------------------------------------
    public long peekFront() {
        return queArray[front];
    }

    //--------------------------------------------------------------
    public boolean isEmpty() {
        return nItems == 0;
    }

    //--------------------------------------------------------------
    public boolean isFull() {
        return nItems == maxSize;
    }

    //--------------------------------------------------------------
    public int size() {
        return nItems;
    }

    //--------------------------------------------------------------
    public void display() {
        // TODO:
        // Здесь нужно вывести содержимое очереди
        // от первого вставленного элемента до последнего.
        //
        // Важно:
        // 1. Нельзя просто вывести весь массив queArray.
        // 2. Нужно учитывать front.
        // 3. Нужно учитывать циклический перенос.
        // 4. Пустая очередь должна выводиться корректно.
        // 5. Очередь из одного элемента должна выводиться корректно.
        if (nItems == 0) {
            System.out.print("Queue is empty");

        } else if (nItems == 1) {
            System.out.print(queArray[front] + " ");

        } else {
            int temp = front;
            for (int i = 0; i <nItems; i++) {
                if (temp == maxSize) {
                    temp = 0;
                }
                System.out.print(queArray[temp++] + " ");
            }
        }

    }
}
