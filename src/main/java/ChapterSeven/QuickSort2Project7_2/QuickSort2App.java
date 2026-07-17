package ChapterSeven.QuickSort2Project7_2;

class QuickSort2App
{
    public static void main(String[] args)
    {
        int maxSize = 12; // Размер массива
        ArrayIns arr; // Ссылка на массив
        arr = new ArrayIns(maxSize); // Создание массива

        for(int j=0; j<maxSize; j++) // Заполнение массива
        {
            // случайными числами
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }

        arr.display(); // Вывод элементов
        arr.quickSort(); // Быстрая сортировка
        arr.display(); // Повторный вывод
    }
} // Конец класса QuickSort2App
