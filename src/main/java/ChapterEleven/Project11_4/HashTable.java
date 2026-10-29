package ChapterEleven.Project11_4;

class HashTable
{
    private DataItem[] hashArray; // Массив ячеек хеш-таблицы
    private int arraySize;
    private DataItem nonItem;
    private int nElements = 0; //Кол-во реальных объектов в таблице
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
    private int getPrime(int min) // Возвращает первое простое число > min
    {
        for(int j = min + 1; true; j++) // Для всех j > min
            if(isPrime(j))               // Число j простое?
                return j;                // Да, вернуть его
    }

    // -------------------------------------------------------------
    private boolean isPrime(int n) // Число n простое?
    {
        for(int j = 2; (j * j <= n); j++) // Для всех j
            if(n % j == 0)                 // Делится на j без остатка?
                return false;              // Да, число не простое

        return true;                       // Нет, число простое
    }
    // -------------------------------------------------------------
    public void insert(DataItem item) // Вставка элемента данных
    {
        // (Метод предполагает, что таблица не заполнена)
        int key = item.getKey();       // Получение ключа
        int hashVal = hashFunc(key);   // Хеширование ключа
        // Пока не будет найдена
        while(hashArray[hashVal] != null && // пустая ячейка или -1,
                hashArray[hashVal].getKey() != -1)
        {
            ++hashVal;                 // Переход к следующей ячейке
            hashVal %= arraySize;      // При достижении конца таблицы
            // происходит возврат к началу
        }
        nElements++;//Увеличиваем эл-ты
        hashArray[hashVal] = item;     // Вставка элемента
        int a = nElements; //число э-тов
        int b = arraySize; //кол-во ячеек
        double result = (double) a / b; // Результат: коэффецент заполнения

        if( result   > 0.5){ //Если больше 0.5 производим перераспределение и расширение таблицы
            rehash();
        }
    }

    // -------------------------------------------------------------
    private void rehash(){//Метод расширения
        System.out.println("Rehashing table...");
        int newSize  = getPrime(arraySize * 2); //Вычисляем новый размер(Примерно в 2 раза больше предидущего)
        DataItem[] newArray = new DataItem[newSize];//Создаем новый пустой массив
        DataItem[] oldArray = hashArray;//Сохраняем старый массив
        hashArray = newArray;//Хеш эррей указывает на новый только что созданный массив
        arraySize = newSize;//Сохраняем новый размер

        for (int i = 0; i < oldArray.length; i++) {//Проходим старый массив от первой до последней ячейки
            if(oldArray[i] != null && oldArray[i].getKey() != -1){ //Если нет эллемента и ключ не равен -1(удаленному)
                int key = oldArray[i].getKey();       // Получение ключа
                int hashVal = hashFunc(key);   // Хеширование ключа

                while(hashArray[hashVal] != null && // пустая ячейка или -1,
                        hashArray[hashVal].getKey() != -1)
                {
                    ++hashVal;                 // Переход к следующей ячейке
                    hashVal %= arraySize;      // При достижении конца таблицы
                    // происходит возврат к началу
                }

                hashArray[hashVal] = oldArray[i];     // Вставка элемента в новый массив
            }
        }
        System.out.println("Finished rehashing...");
    }
    // -------------------------------------------------------------
    public DataItem delete(int key) // Удаление элемента данных
    {
        int hashVal = hashFunc(key); // Хеширование ключа

        while(hashArray[hashVal] != null) // Пока не будет найдена
        {                                 // пустая ячейка
            // Ключ найден?
            if(hashArray[hashVal].getKey() == key)
            {
                DataItem temp = hashArray[hashVal]; // Временное сохранение
                hashArray[hashVal] = nonItem;       // Удаление элемента
                nElements--;//Уменьшаем кол-во эл-тов
                return temp;                        // Метод возвращает элемент
            }

            ++hashVal;               // Переход к следующей ячейке
            hashVal %= arraySize;    // При достижении конца таблицы
            // происходит возврат к началу
        }

        return null;                 // Элемент не найден
    }

    // -------------------------------------------------------------
    public DataItem find(int key) // Поиск элемента с заданным ключом
    {                             // (Метод предполагает, что таблица не заполнена)
        int hashVal = hashFunc(key); // Хеширование ключа

        while(hashArray[hashVal] != null) // Пока не будет найдена
        {                                 // пустая ячейка
            // Ключ найден?
            if(hashArray[hashVal].getKey() == key)
                return hashArray[hashVal]; // Да, вернуть элемент

            ++hashVal;               // Переход к следующей ячейке
            hashVal %= arraySize;    // При достижении конца таблицы
            // происходит возврат к началу
        }

        return null;                 // Элемент не найден
    }

    // -------------------------------------------------------------
} // Конец класса HashTable
