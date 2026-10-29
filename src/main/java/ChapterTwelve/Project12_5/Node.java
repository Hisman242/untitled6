package ChapterTwelve.Project12_5;

class Node
{
    public int iData; // Данные (ключ)
    public Node leftChild;         // Левый потомок узла
    public Node rightChild;        // Правый потомок узла
    public Node parent;
    // -------------------------------------------------------------
    public Node(int key) // Конструктор
    {
        iData = key;
    }

    // -------------------------------------------------------------
    public int getKey()
    {
        return iData;
    }

    // -------------------------------------------------------------
    public void setKey(int id)
    {
        iData = id;
    }

    // -------------------------------------------------------------
} // Конец класса Node
////////////////////////////////////////////////////////////////
