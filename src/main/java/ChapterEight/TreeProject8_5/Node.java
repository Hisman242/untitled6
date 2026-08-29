package ChapterEight.TreeProject8_5;

class Node
{
    public char cData;              // Данные, используемые в качестве ключа
    public int frequency;           // Частота(Насколько часто тот или иной символ повторяется
    public Node leftChild;         // Левый потомок узла
    public Node rightChild;        // Правый потомок узла

    public void displayNode()      // Вывод узла
    {
        System.out.print('{');
        System.out.print(cData);
        System.out.print(", ");
        System.out.print(frequency);
        System.out.print("} ");
    }
}  // Конец класса Node
