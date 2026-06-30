package orderedArray;

class OrdArray
{
    private long[] a;      // Ссылка на массив a
    private int nElems;    // Количество элементов данных

    //-----------------------------------------------------------
    public OrdArray(int max) // Конструктор
    {
        a = new long[max]; // Создание массива
        nElems = 0;
    }
    //-----------------------------------------------------------
    private void add(long value){
        a[nElems] = value;
        nElems++;
    }
    //-----------------------------------------------------------
    public int size()
    {
        return nElems;
    }
    //-----------------------------------------------------------
    public OrdArray merge(OrdArray arr1, OrdArray arr2){
        OrdArray merged =  new OrdArray(arr1.size() + arr2.size());
        int i = 0;
        int j = 0;
        while(i < arr1.size() && j < arr2.size()){
            if (arr1.get(i)  > arr2.get(j)) {
                merged.add(arr2.get(j));
                j++;
            } else {
                merged.add(arr1.get(i));
                i++;
            }
        }
        if(i == arr1.size() &&  j < arr2.size()){
            while(j < arr2.size()){
                merged.add(arr2.get(j));
                j++;
            }
        } else if (i < arr1.size() &&  j == arr2.size()){
            while (i < arr1.size()){
                merged.add(arr1.get(i));
                i++;
            }
        }
        return merged;
    }
    //-----------------------------------------------------------
    private long get(int id){
        long l = a[id];
        return l;
    }
    //-----------------------------------------------------------
    public int find(long searchKey)
    {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true)
        {
            curIn = (lowerBound + upperBound) / 2;

            if (a[curIn] == searchKey)
                return curIn; // Элемент найден
            else if (lowerBound > upperBound)
                return nElems; // Элемент не найден
            else // Деление диапазона
            {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1; // В верхней половине
                else
                    upperBound = curIn - 1; // В нижней половине
            }
        }
    }

    //-----------------------------------------------------------
    public void insert(long value) // Вставка элемента в массив
    {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while(lowerBound <= upperBound){
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] < value)
                lowerBound = curIn + 1; // В верхней половине
            else
                upperBound = curIn - 1; // В нижней половине

        }
        for (int k = nElems; k > lowerBound; k--) // Перемещение последующих элементов
            a[k] = a[k - 1];

        a[lowerBound] = value; // Вставка
        nElems++;     // Увеличение размера
    }

    //-----------------------------------------------------------
    public boolean delete(long value)
    {
        int j = find(value);

        if (j == nElems) // Найти не удалось
            return false;
        else // Элемент найден
        {
            for (int k = j; k < nElems; k++) // Перемещение последующих элементов
                a[k] = a[k + 1];

            nElems--; // Уменьшение размера
            return true;
        }
    }

    //-----------------------------------------------------------
    public void display() // Вывод содержимого массива
    {
        for (int j = 0; j < nElems; j++) // Перебор всех элементов
            System.out.print(a[j] + " "); // Вывод текущего элемента

        System.out.println("");
    }
    //-----------------------------------------------------------

    public void noDups() {
        int i = 0;
        while (i < nElems) {
            int j = i + 1;
            while (j < nElems) {
                if (a[i] == a[j]) {
                    for (int k = j; k < nElems - 1; k++) {
                        a[k] = a[k + 1];
                    }
                    nElems--;
                } else {
                    j++;
                }
            }
            i++;
        }
    }
//-----------------------------------------------------------

}
