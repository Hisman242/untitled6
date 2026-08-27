package ChapterEight.TreeProject8_4;

class StackX
{
    private int maxSize; //Максимальная вместимость
    private Tree[] stackArray;//Массив деревьев
    private int top;//Индекс верхнего эл-та

    //-------------------------------------------------------------
    public StackX(int size)      // Конструктор
    {
        maxSize = size;
        stackArray = new Tree[maxSize];
        top = -1;
    }

    //-------------------------------------------------------------
    public void push(Tree j)     // Размещение элемента на вершине стека
    {
        stackArray[++top] = j;
    }

    //-------------------------------------------------------------
    public Tree pop()            // Извлечение элемента с вершины стека
    {
        return stackArray[top--];
    }

    //-------------------------------------------------------------
    public Tree peek()           // Чтение элемента на вершине стека
    {
        return stackArray[top];
    }

    //-------------------------------------------------------------
    public boolean isEmpty()    // true, если стек пуст
    {
        return (top == -1);
    }

    //-------------------------------------------------------------
    public boolean isFull()     // true, если стек заполнен
    {
        return (top == maxSize-1);
    }

    //-------------------------------------------------------------
    public int size()           // Текущий размер стека
    {
        return top+1;
    }

    //-------------------------------------------------------------
    public Tree peekN(int n)     // Чтение элемента с индексом n
    {
        return stackArray[n];
    }

    //-------------------------------------------------------------
    public void displayStack(String s)
    {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");

        for(int j=0; j<size(); j++)
        {
            System.out.print( peekN(j) );
            System.out.print(' ');
        }

        System.out.println("");
    }

//-------------------------------------------------------------
}  // Конец класса StackX
////////////////////////////////////////////////////////////////