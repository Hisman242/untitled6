package ChapterEight.TreeProject8_4;


class Node
{
    public char iData;              // Данные, используемые в качестве ключа
    public Node leftChild;         // Левый потомок узла
    public Node rightChild;        // Правый потомок узла

    public void displayNode()      // Вывод узла
    {
        System.out.print('{');
        System.out.print(iData);

        System.out.print("} ");
    }
}  // Конец класса Node
