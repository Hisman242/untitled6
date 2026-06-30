package insertSort;


class InsertSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 100000; // Размер массива
        ArrayIns arr;      // Ссылка на массив

        arr = new ArrayIns(maxSize); // Создание массива

        arr.insert(1); // Вставка 10 элементов
        arr.insert(1);
        arr.insert(10);
        arr.insert(10);
        arr.insert(50);
        arr.insert(50);
        arr.insert(20);
        arr.insert(60);
        arr.insert(60);
        arr.insert(88);

        arr.display(); // Вывод элементов
//
//        arr.insertionSort(); // Сортировка методом вставки
//
//        arr.display(); // Повторный вывод
//        for (int i = 0; i < maxSize; i++) {
//            long n =  (i);
//            arr.insert(n);
//        }
//        arr.display();              // Вывод элементов
//        long startTime = System.currentTimeMillis();
        arr.insertionSort();
//        long endTime = System.currentTimeMillis();
//        double seconds = (endTime - startTime) / 1000.0;
//        System.out.println();
//        System.out.println();
//        System.out.println("Время выполнения: " + seconds + " секунд");
//        System.out.println();
//        System.out.println();

//        System.out.println(arr.median());
//        arr.noDups();
        arr.display();
    }
}