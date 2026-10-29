package ChapterTwelve.Project12_4;

import java.io.*;

class PriorityQApp
{
    public static void main(String[] args) throws IOException
    {
        PriorityQ thePQ = new PriorityQ();

        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);
        System.out.println("Max: " + thePQ.peekMax());
        System.out.println("Min: " + thePQ.peekMin());

        System.out.println("Removing");
        while(!thePQ.isEmpty())
        {
            long item = thePQ.remove();
            System.out.print(item + " "); // 50 40 30 20 10
        }

        System.out.println("");
    }

    //-------------------------------------------------------------
} // Конец класса PriorityQApp
