package ChapterSeven.PartitionMedianProject7_3;


class PartitionApp
{
    public static void main(String[] args)
    {
        int maxSize = 16; // Размер массива
        ArrayPar arr; // Ссылка на массив
        arr = new ArrayPar(maxSize); // Создание массива
        for(int j=0; j<maxSize; j++) // Заполнение массива
        { // случайными числами
            long n = (int)(Math.random()*199);
            arr.insert(n);
        }
        arr.display(); // Вывод массива
        System.out.println(arr.findMedian());

    }
}