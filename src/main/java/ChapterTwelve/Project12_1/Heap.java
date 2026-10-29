package ChapterTwelve.Project12_1;
class Heap {
    private Node[] heapArray;
    private int maxSize;        // Размер массива
    private int currentSize;    // Количество узлов в массиве

    // -------------------------------------------------------------
    public Heap(int mx)         // Конструктор
    {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize]; // Создание массива
    }

    // -------------------------------------------------------------
    public boolean isEmpty()
    {
        return currentSize == 0;
    }

    // -------------------------------------------------------------
    public boolean insert(int key)//insert() добавляет узел на следующее свободное место.
    {
        if(currentSize == maxSize)
            return false;

        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    // -------------------------------------------------------------
    public void trickleUp(int index)//trickleUp() поднимает маленький ключ вверх.
    {
        int parent = (index - 1) / 2;//Находим родителя.
        Node bottom = heapArray[index];//Сохраняем узел, который собираемся поднимать.

        while(index > 0 && heapArray[parent].getKey() > bottom.getKey()) { //Продолжаем движение, пока мы ещё не дошли до корня и родитель больше поднимаемого узла.
            heapArray[index] = heapArray[parent]; // Узел смещается вниз
            index = parent;//Теперь рассматриваем прежнее место родителя
            parent = (parent - 1) / 2;//Находим родителя следующего уровня.
        }

        heapArray[index] = bottom;//Когда цикл закончился, записываем сохранённый узел на найденное место.
    }

    // -------------------------------------------------------------
    public Node remove() // Удаление элемента с наименьшим ключом
    {                    // (Предполагается, что список не пуст)
        Node root = heapArray[0];//Сохраняем старый корень
        heapArray[0] = heapArray[--currentSize];//Уменьшаем количество узлов и переносим прежний последний узел в корень
        trickleDown(0);//восстанавливаем порядок, начиная с индекса 0
        return root;//Возвращаем старый корень.
    }

    // -------------------------------------------------------------
    public void trickleDown(int index)//trickleDown() выбирает меньшего ребёнка и поднимает его.
    {
        int smallerChild;//Переменная для индекса меньшего ребёнка.
        Node top = heapArray[index]; // Сохранение корня

        while(index < currentSize / 2) // Пока у узла имеется хотя бы один потомок
        {
            int leftChild = 2 * index + 1;//Вычисляем индекс левого ребёнка.
            int rightChild = leftChild + 1;//Вычисляем индекс правого.

            // Определение меньшего потомка
            if(rightChild < currentSize && // (Правый потомок существует?)
                    heapArray[leftChild].getKey() > heapArray[rightChild].getKey())
                smallerChild = rightChild;
            else
                smallerChild = leftChild;

            // top <= largerChild? Проверяем, подходит ли сохранённый узел на рассматриваемое место.
            if(top.getKey() <= heapArray[smallerChild].getKey())
                break;

            // Потомок сдвигается вверх
            heapArray[index] = heapArray[smallerChild];//Если сохранённый узел слишком большой, поднимаем меньшего ребёнка.
            index = smallerChild; // Переход вниз
        }

        heapArray[index] = top; // index <- корень/Записываем сохранённый узел на окончательное место.
    }

    // -------------------------------------------------------------
    public boolean change(int index, int newValue)
    {
        if(index < 0 || index >= currentSize)
            return false;

        int oldValue = heapArray[index].getKey(); // Сохранение старого ключа
        heapArray[index].setKey(newValue); // Присваивание нового ключа

        if(oldValue > newValue) // Если Ключ уменьшился,
            trickleUp(index);   // выполняется смещение вверх.
        else                    // Если Ключ увеличился или остался прежним,
            trickleDown(index); // выполняется смещение вниз.

        return true;
    }

    // -------------------------------------------------------------
    public void displayHeap()
    {
        System.out.print("heapArray: "); // Формат массива

        for(int m = 0; m < currentSize; m++)
            if(heapArray[m] != null)
                System.out.print(heapArray[m].getKey() + " ");
            else
                System.out.print("-- ");

        System.out.println();

        // Формат пирамиды
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0; // Текущий элемент
        String dots = "...............................";

        System.out.println(dots + dots); // Верхний пунктир

        while(currentSize > 0) // Для каждого элемента пирамиды
        {
            if(column == 0) // Первый элемент в строке?
                for(int k = 0; k < nBlanks; k++) // Предшествующие пробелы
                    System.out.print(' ');

            // Вывод элемента
            System.out.print(heapArray[j].getKey());

            if(++j == currentSize) // Вывод завершен?
                break;

            if(++column == itemsPerRow) // Конец строки?
            {
                nBlanks /= 2;       // Половина пробелов
                itemsPerRow *= 2;   // Вдвое больше элементов
                column = 0;         // Начать заново
                System.out.println(); // Переход на новую строку
            }
            else // Следующий элемент в строке
                for(int k = 0; k < nBlanks * 2 - 2; k++)
                    System.out.print(' '); // Внутренние пробелы
        }

        System.out.println("\n" + dots + dots); // Нижний пунктир
    }

    // -------------------------------------------------------------
} // Конец класса Heap
////////////////////////////////////////////////////////////////
