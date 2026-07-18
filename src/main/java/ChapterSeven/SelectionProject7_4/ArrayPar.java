package ChapterSeven.SelectionProject7_4;

class ArrayPar
{
    private long[] theArray; // Ссылка на массив
    private int nElems; // Количество элементов
    //--------------------------------------------------------------
    public ArrayPar(int max) // Конструктор
    {
        theArray = new long[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
    }
    //--------------------------------------------------------------
    public void insert(long value) // Вставка элемента в массив
    {
        theArray[nElems] = value; // Собственно вставка
        nElems++; // Увеличение размера
    }
    //--------------------------------------------------------------
    public int size() // Получение количества элементов
    {
        return nElems;
    }
    //--------------------------------------------------------------
    public void display() // Вывод содержимого массива
    {
        System.out.print("A=");
        for(int j=0; j<nElems; j++) // Для каждого элемента
            System.out.print(theArray[j] + " "); // Вывод
        System.out.println("");
    }
    //--------------------------------------------------------------
    public int partitionIt(int left, int right) {
        if(left > right){
            System.out.println("The array is empty");
            return -1;
        } else if(left == right){
            return left;
        }
        int leftPtr = left - 1; // Справа от первого элемента
        int rightPtr = right; // Ставится на идекс опорного э-та(pivot)
        long pivot = theArray[right];
        while(true)
        {
            while(leftPtr < right && // Поиск большего элемента
                    theArray[++leftPtr] < pivot)
                ; // (пустое тело цикла)

            while(rightPtr > left && // Поиск меньшего элемента
                    theArray[--rightPtr] > pivot)
                ; // (пустое тело цикла)

            if(leftPtr >= rightPtr) // Если указатели сошлись,
                break; // разбиение закончено
            else // В противном случае
                swap(leftPtr, rightPtr); // поменять элементы местами
        }
        swap(leftPtr, right);
        return leftPtr; // Позиция разбиения
    }
    //--------------------------------------------------------------
    public void swap(int dex1, int dex2) // Перестановка двух элементов
    {
        long temp;
        temp = theArray[dex1]; // A копируется в temp
        theArray[dex1] = theArray[dex2]; // B копируется в A
        theArray[dex2] = temp; // temp копируется в B
    }
    //--------------------------------------------------------------
    public long median(int left, int right, int middle){
        int index = partitionIt(left,right);
        if(index  == middle){
            return theArray[middle];
        }if(index > middle){
            System.out.println(index + ">" + middle);
            return median(left,index - 1,middle);
        }else{
            System.out.println(index + "<" + middle);
            return median(index + 1,right,middle);
        }

    }
    //--------------------------------------------------------------
    public double findMedian(){
        if(nElems % 2 == 0){
            long  median1 = median(0,nElems - 1,nElems / 2 - 1);
            long  median2 = median(0,nElems - 1,nElems / 2);
            double result = (median1 + median2) / 2.0;
            return result;
        } else{
            return median(0,nElems-1,nElems / 2);
        }
    }
    //--------------------------------------------------------------
    public long smallest(int k){
        if(k > nElems || k < 1){
            System.out.println("Incorrect value");
            return -1;
        }else {
            return choice(0, nElems - 1, k -1);
        }
    }
    //--------------------------------------------------------------
    public long biggest(int k){
        if(k > nElems || k < 1){
            System.out.println("Incorrect value");
            return -1;
        }else {
            return choice(0, nElems-1, nElems - k);
        }

    }
    //--------------------------------------------------------------
    public long choice(int left, int right, int targetIndex){
        int index = partitionIt(left,right);
        if(index == -1){
            return -1;
        }
        if(index  == targetIndex){
            return theArray[targetIndex];
        }if(index > targetIndex){
            System.out.println(index + ">" + targetIndex);
            return choice(left,index - 1,targetIndex);
        }else{
            System.out.println(index + "<" + targetIndex);
            return choice(index + 1,right,targetIndex);
        }
    }
    //--------------------------------------------------------------
} // Конец класса ArrayPar