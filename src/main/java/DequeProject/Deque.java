package DequeProject;
public class Deque {
    private int maxSize;
    private long[] deQueArray;
    private int front; //front = левый конец
    private int rear; //rear = правый конец
    private int nItems; //хранит количество элементов в очереди прямо сейчас.
    public Deque(int maxSize) {
        this.maxSize = maxSize;
        deQueArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    public void insertLeft(long j){
        //insertLeft  → двигает front влево по кругу
        if(nItems == 0){
            deQueArray[front] = j;
            rear = front;
            nItems++;
        } else  {
            if (front == 0){
                front = maxSize - 1;
            } else {
                front = front - 1;
            }
            deQueArray[front] = j;
            nItems++;
        }
    }
    public long peekLeft(){
        return deQueArray[front];
    }
    public long peekRight(){
        return deQueArray[rear];
    }
    public long removeLeft(){
        //removeLeft  → удаляет с front
        long temp = deQueArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;

    }
    public long removeRight(){
        //removeRight → удаляет с rear
        long temp = deQueArray[rear--];
        if (rear < 0) {
            rear = maxSize - 1;
        }
        nItems--;
        return temp;
    }
    public void insertRight(long j){
        //insertRight → двигает rear вправо по кругу
        if(nItems == 0){
            deQueArray[front] = j;
            rear = front;
            nItems++;
        } else{
            if (rear == maxSize - 1) {
                rear = -1;
            }
            deQueArray[++rear] = j;
            nItems++;
        }
    }


    public boolean isEmpty(){
        return nItems == 0;
    }
    public boolean isFull(){
        return maxSize == nItems;
    }

}
