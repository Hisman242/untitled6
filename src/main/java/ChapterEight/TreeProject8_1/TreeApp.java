package ChapterEight.TreeProject8_1;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class TreeApp {

    // Главный метод, с которого начинается выполнение программы.
    // throws IOException позволяет не обрабатывать ошибку ввода внутри main.
    public static void main(String[] args) throws IOException {

        // Создаём главное дерево.
        // В конструкторе Tree его поле root получит значение null.
        Tree tree = new Tree();

        // Просим пользователя ввести строку.
        System.out.println("Please enter a string");

        // Вызываем getString(), считываем введённую строку
        // и сохраняем её в переменной text.
        String text = getString();

        // Индекс, по которому следующий созданный узел
        // будет записан в массив nodeArr.
        int indexOfNodeArr = 0;

        // Разделяем введённую строку по одиночным пробелам.
        // Например, "A B C" превратится в массив ["A", "B", "C"].
        String[] characterString = text.split(" ");

        // Создаём массив ссылок на узлы.
        // Его размер равен количеству полученных строковых элементов.
        // Сразу после создания все ячейки массива содержат null.
        Node[] nodeArr = new Node[characterString.length];

        // Перебираем все элементы массива characterString.
        // i начинается с 0, увеличивается после каждой итерации,
        // а цикл заканчивается, когда i достигнет длины массива.
        for (int i = 0; i < characterString.length; i++) {

            // Создаём новый временный узел.
            // Его потомки leftChild и rightChild пока равны null.
            Node temp = new Node();

            // Записываем в узел текущий элемент введённой строки.
            // Например, при i = 0 сюда попадёт characterString[0].
            temp.sData = characterString[i];

            // Сохраняем созданный узел в массиве nodeArr.
            // Постфиксный ++ означает:
            // сначала используется текущее значение indexOfNodeArr,
            // а после записи оно увеличивается на единицу.
            nodeArr[indexOfNodeArr++] = temp;
        }

        // Передаём заполненный массив листовых узлов
        // в метод, который построит из них одно дерево.
        tree.treeByRow(nodeArr);

        // Выводим готовое дерево по уровням.
        tree.displayTree();
    }

    // Метод считывает из консоли целую строку.
    // Возвращаемый тип String означает,
    // что результатом метода будет строка.
    public static String getString() throws IOException {

        // System.in получает данные из консоли как поток байтов.
        // InputStreamReader преобразует байты в символы.
        InputStreamReader isr = new InputStreamReader(System.in);

        // BufferedReader оборачивает InputStreamReader
        // и предоставляет удобный метод readLine().
        BufferedReader br = new BufferedReader(isr);

        // readLine() ждёт, пока пользователь введёт строку
        // и нажмёт Enter, после чего возвращает введённую строку.
        return br.readLine();
    }

    // Метод считывает строку и возвращает её первый символ.
    // В текущем main этот метод не вызывается,
    // но он остался от исходной программы.
    public static char getChar() throws IOException {

        // Считываем целую строку с помощью getString().
        String value = getString();

        // Возвращаем символ, находящийся на позиции 0,
        // то есть первый символ введённой строки.
        return value.charAt(0);
    }

    // Метод считывает строку и преобразует её в целое число.
    // В текущем main этот метод также не вызывается.
    public static int getInt() throws IOException {

        // Считываем строковое представление числа.
        String value = getString();

        // Преобразуем строку в значение типа int
        // и возвращаем получившееся число.
        return Integer.parseInt(value);
    }
}