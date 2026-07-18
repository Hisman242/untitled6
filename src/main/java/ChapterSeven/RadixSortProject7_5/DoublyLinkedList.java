package ChapterSeven.RadixSortProject7_5;


class DoublyLinkedList
{
    private Link first;         // Ссылка на первый элемент списка
    private Link last;          // Ссылка на последний элемент списка
    // -------------------------------------------------------------
    public DoublyLinkedList()   // Конструктор
    {
        first = null;
        last = null;
    }
    // -------------------------------------------------------------
    public boolean isEmpty()    // true, если список пуст
    {
        return first == null;
    }
    // -------------------------------------------------------------
    public void insertFirst(long dd) // Вставка в начало списка
    {
        Link newLink = new Link(dd);

        if(isEmpty())
            last = newLink;
        else
            first.previous = newLink;

        newLink.next = first;
        first = newLink;
    }
    // -------------------------------------------------------------
    public void insertLast(long dd) // Вставка в конец списка
    {
        Link newLink = new Link(dd);

        if(isEmpty())
            first = newLink;
        else
        {
            last.next = newLink;
            newLink.previous = last;
        }

        last = newLink;
    }
    // -------------------------------------------------------------
    public boolean insertAfter(long key, long dd)
    {
        Link current = first;

        while(current.dData != key)
        {
            current = current.next;

            if(current == null)
                return false;
        }

        Link newLink = new Link(dd);

        if(current == last)
        {
            newLink.next = null;
            last = newLink;
        }
        else
        {
            newLink.next = current.next;
            current.next.previous = newLink;
        }

        newLink.previous = current;
        current.next = newLink;

        return true;
    }
    // -------------------------------------------------------------
    public Link deleteFirst()
    {
        Link temp = first;

        if(first.next == null)
            last = null;
        else
            first.next.previous = null;

        first = first.next;

        return temp;
    }
    // -------------------------------------------------------------
    public Link deleteLast()
    {
        Link temp = last;

        if(first.next == null)
            first = null;
        else
            last.previous.next = null;

        last = last.previous;

        return temp;
    }
    // -------------------------------------------------------------
    public Link deleteKey(long key)
    {
        Link current = first;

        while(current.dData != key)
        {
            current = current.next;

            if(current == null)
                return null;
        }

        if(current == first)
            first = current.next;
        else
            current.previous.next = current.next;

        if(current == last)
            last = current.previous;
        else
            current.next.previous = current.previous;

        return current;
    }
    // -------------------------------------------------------------
    public void displayForward()
    {
        System.out.print("List (first-->last): ");

        Link current = first;

        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }

        System.out.println("");
    }
    // -------------------------------------------------------------
    public void displayBackward()
    {
        System.out.print("List (last-->first): ");

        Link current = last;

        while(current != null)
        {
            current.displayLink();
            current = current.previous;
        }

        System.out.println("");
    }
    // -------------------------------------------------------------
    public long peekFirst()
    {
        Link current = first;
        return current.dData;
    }
// -------------------------------------------------------------

    public long peekLast()
    {
        Link current = last;
        return current.dData;
    }
// -------------------------------------------------------------
} // Конец класса DoublyLinkedList