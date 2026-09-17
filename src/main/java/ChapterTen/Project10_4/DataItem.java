package ChapterTen.Project10_4;

class DataItem
{
    public long dData; // Один объект данных

    //--------------------------------------------------------------
    public DataItem(long dd) // Конструктор
    {
        dData = dd;
    }

    //--------------------------------------------------------------
    public void displayItem() // Вывод элемента в формате "/27"
    {
        System.out.print("/" + dData);
    }

//--------------------------------------------------------------
} // Конец класса DataItem
