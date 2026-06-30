package insertSort;

import java.util.Arrays;

class ArrayIns
{
    private long[] a;      // Ссылка на массив a
    private int nElems;    // Количество элементов данных

    //--------------------------------------------------------------
    public ArrayIns(int max) // Конструктор
    {
        a = new long[max]; // Создание массива
        nElems = 0;        // Пока нет ни одного элемента
    }

    //--------------------------------------------------------------
    public void insert(long value) // Вставка элемента в массив
    {
        a[nElems] = value; // Собственно вставка
        nElems++;          // Увеличение размера
    }

    //--------------------------------------------------------------
    public void display() // Вывод содержимого массива
    {
        for(int j = 0; j < nElems; j++) // Для каждого элемента
            System.out.print(a[j] + " "); // Вывод

        System.out.println("");
    }

    //--------------------------------------------------------------
    public void insertionSort()
    {
        long min = Long.MIN_VALUE;
        int copying = 0;
        int compare = 0;
        int in, out;

        for(out = 1; out < nElems; out++) // out - разделительный маркер
        {
            long temp = a[out]; // Скопировать помеченный элемент
            copying++;
            in = out;           // Начать перемещения с out

            while(in > 0 ) // Пока не найден меньший элемент
            {

                compare++;
                if(a[in - 1] >= temp){
                    if(a[in - 1] == temp){
                        temp = min;
                    }
                    a[in] = a[in - 1]; // Сдвинуть элемент вправо
                    copying++;
                    --in;              // Перейти на одну позицию влево
                } else{
                    break;
                }

            }

            a[in] = temp; // Вставить помеченный элемент
            copying++;



        }
        System.out.println("Всего копирований: " + copying );
        System.out.println("Всего сравнений: " + compare);
        int work = 0;
        for(int j = 0; j < nElems; j++){
            if(a[j] != min){
                a[work] = a[j];
                work++;
            }
        }
        nElems = work;
    }

    //--------------------------------------------------------------
    public long median(){
        int size = nElems;
        if(size  % 2 == 1){
            return a[size/2];
        } else{
            return (a[size/2 - 1] + a[size/2])/2;
        }
    }
    //--------------------------------------------------------------
    public void swap(int one, int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
    //--------------------------------------------------------------
    public void noDups() {
        int pos = 0; //на какое место мы сейчас ставим элемент, его позиция
        a[pos] = a[0];
        for (int i = 1; i < nElems; i++) { //идёт по массиву слева - направо и читает по одному индексу
            if(a[pos] != a[i]){
                pos++;
                a[pos] = a[i];

            }
        }
        nElems =  pos + 1;
    }
}
//--------------------------------------------------------------

