package ChapterEight.TreeProject8_3;

class Node
{
    public String sData;              // Данные
    public Node leftChild;         // Левый потомок узла
    public Node rightChild;        // Правый потомок узла

    public void displayNode()      // Вывод узла
    {
        System.out.print('{');
        System.out.print(sData);
        System.out.print("} ");
    }
}  // Конец класса Node