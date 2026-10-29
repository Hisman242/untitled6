package ChapterEleven.Project11_1;

class HashTable
{
    private DataItem[] hashArray; // Массив ячеек хеш-таблицы
    private int arraySize;
    private DataItem nonItem;

    // -------------------------------------------------------------
    public HashTable(int size) // Конструктор
    {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1); // Ключ удаленного элемента -1
    }

    // -------------------------------------------------------------
    public void displayTable()
    {
        System.out.print("Table: ");

        for(int j = 0; j < arraySize; j++)
        {
            if(hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }

        System.out.println("");
    }

    // -------------------------------------------------------------
    public int hashFunc(int key)
    {
        return key % arraySize; // Хеш-функция
    }

    // -------------------------------------------------------------
    public void insert(DataItem item) // Вставка элемента данных
    {// (Метод предполагает, что таблица не заполнена)
        int degree = 1;
        int key = item.getKey();       // Получение ключа
        int hashVal = hashFunc(key);   // Хеширование ключа
        // Пока не будет найдена
        int index = hashVal;

        while(hashArray[index] != null && // пустая ячейка или -1,
                hashArray[index].getKey() != -1)
        {
            index = (hashVal + degree * degree ) % arraySize;
            degree++;
            hashVal %= arraySize;      // При достижении конца таблицы
            // происходит возврат к началу
        }

        hashArray[index] = item;     // Вставка элемента
    }

    // -------------------------------------------------------------
    public DataItem delete(int key) // Удаление элемента данных
    {
        int degree = 1;
        int hashVal = hashFunc(key); // Хеширование ключа
        int index = hashVal;
        while(hashArray[index] != null) // Пока не будет найдена
        {                                 // пустая ячейка
            // Ключ найден?
            if(hashArray[index].getKey() == key)
            {
                DataItem temp = hashArray[index]; // Временное сохранение
                hashArray[index] = nonItem;       // Удаление элемента
                return temp;                        // Метод возвращает элемент
            }
            index = (hashVal + degree * degree ) % arraySize;
            degree++;
            hashVal %= arraySize;      // При достижении конца таблицы

            // происходит возврат к началу
        }

        return null;                 // Элемент не найден
    }

    // -------------------------------------------------------------
    public DataItem find(int key) // Поиск элемента с заданным ключом
    {                             // (Метод предполагает, что таблица не заполнена)
        int degree = 1;
        int hashVal = hashFunc(key); // Хеширование ключа
        int index = hashVal;

        while(hashArray[index] != null) // Пока не будет найдена
        {                                 // пустая ячейка
            // Ключ найден?
            if(hashArray[index].getKey() == key)
                return hashArray[index]; // Да, вернуть элемент
            index = (hashVal + degree * degree ) % arraySize;
            degree++;
            hashVal %= arraySize;      // При достижении конца таблицы
            // происходит возврат к началу
        }

        return null;                 // Элемент не найден
    }

    // -------------------------------------------------------------
} // Конец класса HashTable
