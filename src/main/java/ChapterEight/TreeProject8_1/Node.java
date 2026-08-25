package ChapterEight.TreeProject8_1;

// tree.java
// Работа с двоичным деревом
// Запуск программы: C>java TreeApp
import java.io.*;
import java.util.*;               // Для использования класса Stack
class Node
{
    public String sData;              // Данные(Содержимое узла)

    public Node leftChild;         // Левый потомок узла
    public Node rightChild;        // Правый потомок узла
    public void displayNode()      // Вывод узла
    {
        System.out.print('{');
        System.out.print(sData);
        System.out.print("} ");
    }
}  // Конец класса Node
