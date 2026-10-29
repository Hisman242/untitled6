package ChapterEleven.Project11_3;

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


    public int convolution(int key){
        String keyInString = String.valueOf(key); //Получаем представление ключа в виде строки
        int groupSize = String.valueOf( hashArray.length - 1).length();//Находим длину групп(Сначала парсится в строку и потом мы возвращаем кол-во символов этой строки)
        String groupe;//Временная строка группы
        int result = 0;//Результат
        int index = 0;//Индекс
        for (int i = 0; i <= keyInString.length() - groupSize; i = i + groupSize) {//Цикл идет от нуля, до того пока помещается одна группа, на каждой итерации у нас прибавляется
            //размер группы
            groupe = keyInString.substring(i,  i + groupSize); //Получаем нужные символы в строковом представлении
            result+=Integer.parseInt(groupe);//Суммируем в результат группу и
            index += groupSize;//Увеличиваем индекс для проверки оставшихся эл-тов на размер группы
        }if(index != keyInString.length()){//Если остались эл-ты
            result += Integer.parseInt(keyInString.substring(index));//Добавляем остаток в результат
        }
        return result % arraySize;//Приводим индекс в допустимый диапазон таблицы
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
    {                                 // (Метод предполагает, что таблица не заполнена)
        int key = item.getKey();       // Получение ключа
        int hashVal = convolution(key);   // Хеширование ключа
        // Пока не будет найдена
        while(hashArray[hashVal] != null && // пустая ячейка или -1,
                hashArray[hashVal].getKey() != -1)
        {
            ++hashVal;                 // Переход к следующей ячейке
            hashVal %= arraySize;      // При достижении конца таблицы
            // происходит возврат к началу
        }

        hashArray[hashVal] = item;     // Вставка элемента
    }

    // -------------------------------------------------------------
    public DataItem delete(int key) // Удаление элемента данных
    {
        int hashVal = convolution(key); // Хеширование ключа

        while(hashArray[hashVal] != null) // Пока не будет найдена
        {                                 // пустая ячейка
            // Ключ найден?
            if(hashArray[hashVal].getKey() == key)
            {
                DataItem temp = hashArray[hashVal]; // Временное сохранение
                hashArray[hashVal] = nonItem;       // Удаление элемента
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
        int hashVal = convolution(key); // Хеширование ключа

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
