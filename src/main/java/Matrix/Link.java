package Matrix;

public class Link {
    public Link next;
    public Link down;
    public long dData;          // Данные

    //    public Link previous;       // Предыдущий элемент в списке
    // -------------------------------------------------------------
    public Link(long d)         // Конструктор
    {
        dData = d;
    }
    // -------------------------------------------------------------
    public void displayLink()   // Вывод содержимого элемента
    {
        System.out.print(dData + " ");
    }
}



