package selectSort;



class SelectSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 100000; // Размер массива
        ArraySel arr;      // Ссылка на массив

        arr = new ArraySel(maxSize); // Создание массива

//        arr.insert(77); // Вставка 10 элементов
//        arr.insert(99);
//        arr.insert(44);
//        arr.insert(55);
//        arr.insert(22);
//        arr.insert(88);
//        arr.insert(11);
//        arr.insert(00);
//        arr.insert(66);
//        arr.insert(33);




        for (int i = 0; i < maxSize; i++) {
            long n =  (i);
            arr.insert(n);
        }
//        arr.display();              // Вывод элементов
        long startTime = System.currentTimeMillis();
        arr.selectionSort();
        long endTime = System.currentTimeMillis();
        double seconds = (endTime - startTime) / 1000.0;
        System.out.println();
        System.out.println();
        System.out.println("Время выполнения: " + seconds + " секунд");
        System.out.println();
        System.out.println();
//        arr.display();              // Вывод элементов
    }
}