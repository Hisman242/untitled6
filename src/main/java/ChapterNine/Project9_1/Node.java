package ChapterNine.Project9_1;

class Node
{
    public int iData;              // Данные, используемые в качестве ключа
    public double dData;           // Другие данные
    public Node leftChild;         // Левый потомок узла
    public Node rightChild;        // Правый потомок узла
    public boolean isRed = false;  //Красный или черный узел(Цвет узла, )
    public void displayNode()      // Вывод узла
    {
        System.out.print('{');
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(dData);
        System.out.print("} ");
    }
}  // Конец класса Node