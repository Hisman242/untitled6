package ChapterTwelve.Project12_3;

import java.io.*;

class PriorityQApp
{
    public static void main(String[] args) throws IOException
    {
        PriorityQ thePQ = new PriorityQ(5);

        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);
        System.out.println("Min - " + thePQ.peekMin());
        while(!thePQ.isEmpty()) {
            long item = thePQ.remove();
            System.out.print(item + " "); // 50 40 30 20 10
        }


        System.out.println("");
    }

    //-------------------------------------------------------------
} // Конец класса PriorityQApp
