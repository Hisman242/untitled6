package ChapterThirteen.Project13_2;



class LinkList
{
    private Link first; // Ссылка на первый элемент списка

    // -------------------------------------------------------------
    public LinkList() // Конструктор
    {
        first = null; // Список пока не содержит элементов
    }

    // -------------------------------------------------------------
    public void insertFirst(int id) { // Создание нового элемента
        Link newLink = new Link(id);
        newLink.next = first; // newLink --> старое значение first
        first = newLink; // first --> newLink
    }

    // -------------------------------------------------------------
    public int peekFirst(){//Метод просмотра первого числа без его удаления
        return first.iData;
    }
    // -------------------------------------------------------------
    public Link find(Vertex[] vertexList) // Поиск первого не посещённого ел-та, в аргументах передается массив ссылок на вершины
    { // (предполагается, что список не пуст)
        Link current = first; // Начиная с 'first'(локальная ссылка)

        while(vertexList != null && current != null && vertexList[current.iData].wasVisited) // Проверяет что лист и текущий эл-т не равны нулю и текущий эл-т посещен
        {//Если попали сюда, значит движемся дальше по листу
            if(current.next == null) // Если достигнут конец списка
                return null; // и совпадение не найдено
            else // Если еще остались элементы
                current = current.next; // Перейти к следующему элементу
        }

        return current; // Совпадение обнаружено
    }

    // -------------------------------------------------------------
    public Link delete(int key) // Удаление элемента с заданным ключом
    { // (предполагается, что список не пуст)
        Link current = first; // Поиск элемента
        Link previous = first;

        while(current.iData != key) {
            if(current.next == null)
                return null; // Элемент не найден
            else {
                previous = current; // Перейти к следующему элементу
                current = current.next;
            }
        } // Совпадение найдено

        if(current == first) // Если первый элемент,
            first = first.next; // изменить first
        else // В противном случае
            previous.next = current.next; // обойти его в списке

        return current;
    }

    // -------------------------------------------------------------
    public void displayList() // Вывод содержимого списка
    {
        System.out.print("List (first-->last): ");
        Link current = first; // От начала списка

        while(current != null) // Перемещение до конца списка
        {
            current.displayLink(); // Вывод данных
            current = current.next; // Переход к следующему элементу
        }

        System.out.println("");
    }

    // -------------------------------------------------------------
} // Конец класса LinkList
////////////////////////////////////////////////////////////////
