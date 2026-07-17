package ChapterSeven.ShellSort;


public class ArrayShIntermediateOutputApp {
    public static void main(String[] args) {
        int maxSize = 10; // Размер массива
        ArrayShIntermediateOutput arr;
        arr = new ArrayShIntermediateOutput(maxSize); // Создание массива
        for(int j=0; j<maxSize; j++) // Заполнение массива
        { // случайными числами
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }
        System.out.println("->From main -> outputting an unsorted array" );
        arr.display(); // Вывод несортированного массива
        System.out.println("-> From main ->We perform a Shell sort");
        arr.shellSort(); // Сортировка массива по алгоритму Шелла
        System.out.println("->From main -> outputting the sorted array" );
        arr.display(); // Вывод отсортированного массива
    }
}
