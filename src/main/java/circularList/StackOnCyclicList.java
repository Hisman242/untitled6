package circularList;

public class StackOnCyclicList {
    private CircularList list;
    public StackOnCyclicList() {
        list = new CircularList();
    }
    public void push(long j) // Размещение элемента на вершине стека
    {
        list.insert(j); // Вставка элемента на вершину
    }
    //--------------------------------------------------------------
    public long pop() // Извлечение элемента с вершины стека
    {
        return list.remove(); // Извлечение элемента с вершины
    }
    //--------------------------------------------------------------
    public long peek() // Чтение элемента с вершины стека
    {
        return list.peek(); // Возвращает вершину стека
    }
    //--------------------------------------------------------------
    public boolean isEmpty() // True, если стек пуст
    {
        return list.isEmpty();
    }
    //--------------------------------------------------------------
    public void display() // Выводит все э-ты
    {
        list.displayStack();
    }

//--------------------------------------------------------------
}
