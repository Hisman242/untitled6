package ChapterEleven.Project11_5;

class HashTable
{
    private Tree[] hashArray; // Массив деревьев
    private int arraySize;

    // -------------------------------------------------------------
    public HashTable(int size)      // Конструктор
    {
        arraySize = size;
        hashArray = new Tree[arraySize]; // Создание массива

        for(int j = 0; j < arraySize; j++)     // Заполнение массива
            hashArray[j] = new Tree();   // Деревьями
    }

    // -------------------------------------------------------------
    public void displayTable()
    {
        for(int j = 0; j < arraySize; j++) // Для каждой ячейки
        {
            System.out.print(j + ". ");    // Вывод номера ячейки
            hashArray[j].traverse(2);    // Вывод дерева
        }
    }

    // -------------------------------------------------------------
    public int hashFunc(int key)        // Хеш-функция
    {
        return key % arraySize;
    }

    // -------------------------------------------------------------
    public void insert(Node node)    // Вставка элемента
    {


        int key = node.iData;
        int hashVal = hashFunc(key);    // Хеширование ключа
        if((!hashArray[hashVal].isEmpty())){
            boolean noFound = hashArray[hashVal].find(key) == null;
            if (noFound == true){
                hashArray[hashVal].insert(node); // Вставка в позицию hashVal
            } else {
                System.out.println("Duplicate detected");
                return;
            }
        } else{
            hashArray[hashVal].insert(node); // Вставка в позицию hashVal
        }

    }

    // -------------------------------------------------------------
    public void delete(int key)         // Удаление элемента
    {
        int hashVal = hashFunc(key);    // Хеширование ключа
        if((!hashArray[hashVal].isEmpty())){
            hashArray[hashVal].delete(key); // Удаление
        } else{
            System.out.println("Tree is empty");
        }

    }

    // -------------------------------------------------------------
    public Node find(int key)           // Поиск элемента
    {
        int hashVal = hashFunc(key);    // Хеширование ключа
        if(!hashArray[hashVal].isEmpty()){
            Node theNode = hashArray[hashVal].find(key);
            // Поиск
            return theNode;                 // Метод возвращает найденный элемент
        } else{
            System.out.println("Empty tree");
            return null;

        }

    }

    // -------------------------------------------------------------
} // Конец класса HashTable
////////////////////////////////////////////////////////////////
