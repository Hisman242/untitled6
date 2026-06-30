package PriorityQ;
//insert() переделать так, чтобы он не сортировал массив.
//remove() переделать так, чтобы он сам искал нужный элемент.
//peekMin() тоже надо будет продумать заново, потому что минимальный элемент уже не обязательно лежит в конце массива.
//Добавить display(), чтобы видеть содержимое очереди.
class PriorityQ
{
    // Элементы массива сортируются по значению ключа,
    // от максимума (0) до минимума (maxSize-1)
    private int maxSize;
    private long[] queArray;
    private int nItems;

    //-------------------------------------------------------------
    public PriorityQ(int s) // Конструктор
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    //-------------------------------------------------------------
    public void insert(long item) // Вставка элемента
    {
        queArray[nItems++] = item;
//        int j;
//
//        if(nItems == 0) // Если очередь пуста,
//            queArray[nItems++] = item; // вставляем в ячейку 0
//        else // Если очередь содержит элементы
//        {
//            for(j = nItems - 1; j >= 0; j--) // Перебор в обратном направлении
//            {
//                if(item > queArray[j]) // Если новый элемент больше,
//                    queArray[j + 1] = queArray[j]; // сдвинуть вверх
//                else // Если меньше,
//                    break; // сдвиг прекращается
//            }
//
//            queArray[j + 1] = item; // Вставка элемента
//            nItems++;
//        }
    }

    //-------------------------------------------------------------
    public long remove() // Извлечение минимального элемента
    {
        long min = Long.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0; i < nItems; i++){
            if(queArray[i] < min){
                min = queArray[i];
                minIndex = i;
            }
        }
        nItems--;
        for(int j = minIndex; j < nItems; j++){
            queArray[j] = queArray[j+1];
        }

        return min;
    }

    //-------------------------------------------------------------
    public long peekMin() // Чтение минимального элемента
    {
        long min = Long.MAX_VALUE;
        for(int i = 0; i < nItems; i++){
            if(queArray[i] < min){
                min = queArray[i];
            }
        }
        return min;
    }

    //-------------------------------------------------------------
    public boolean isEmpty() // true, если очередь пуста
    {
        return (nItems == 0);
    }

    //-------------------------------------------------------------
    public boolean isFull() // true, если очередь заполнена
    {
        return (nItems == maxSize);
    }


    //    --------------------------------------------------------------
    public void display() {
        for(int i = 0; i < nItems; i++){
            System.out.print(queArray[i] + " ");

        }
        System.out.println();

    }
//    -------------------------------------------------------------
} // Конец класса PriorityQ
