package HighArray;

import java.util.Collections;

class HighArrayApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;             // Размер массива
        HighArray arr;                 // Ссылка на массив
        arr = new HighArray(maxSize);  // Создание массива

        arr.insert(77);                // Вставка 10 элементов
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();                 // Вывод элементов

        int searchKey = 35;            // Поиск элемента
        if (arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);


//        System.out.println("=====================");
//        arr.display();
//        System.out.println("Max key after ->");
//        System.out.println(arr.removeMax());
//        arr.display();
//        System.out.println("=====================");
//
//        arr.delete(00);                // Удаление трех элементов
//        arr.delete(55);
//        arr.delete(99);
//        System.out.println("======================");
//        arr.display();                 // Повторный вывод
//        System.out.println("Max key before ->");
//        System.out.println(arr.removeMax());
//        arr.display();

        HighArray temp = new HighArray(maxSize);
        long sort;
        long[] s = new long[10];
        int index = 9;
        while ((sort = arr.removeMax()) != -1){
            s[index] = sort;
            index--;
        }
        for(int i = 0; i < 10; i++){
            temp.insert(s[i]);
        }
        temp.display();
    }
} // Конец класса HighArrayApp
