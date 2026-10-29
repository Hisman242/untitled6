package ChapterEleven.Project11_2;

class DataItem
{
    private String SData; // (Данных может быть и больше)
    // Данные (ключ)

    //--------------------------------------------------------------
    public DataItem(String ii) // Конструктор
    {
        SData = ii;
    }

    //--------------------------------------------------------------
    public String getKey()
    {
        return SData;
    }

    //--------------------------------------------------------------
} // Конец класса DataItem
