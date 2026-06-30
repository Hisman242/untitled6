package DequeProject;



class StackOnDeque {
    private Deque deque;
    private int maxSize;

    public StackOnDeque(int maxSize) {
        this.maxSize = maxSize;
        deque = new Deque(maxSize);
    }


    public void push(long j) // Размещение элемента на вершине стека
    {
        deque.insertLeft(j);
    }
    //--------------------------------------------------------------
    public long pop() // Извлечение элемента с вершины стека
    {
        return deque.removeLeft();  // Извлечение элемента, уменьшение top

    }
    //--------------------------------------------------------------
    public long peek() // Чтение элемента с вершины стека
    {
        return deque.peekLeft();
    }
    //--------------------------------------------------------------
    public boolean isEmpty() // True, если стек пуст
    {
        return deque.isEmpty();
    }
    //--------------------------------------------------------------
    public boolean isFull() // True, если стек полон
    {
        return deque.isFull();
    }
}