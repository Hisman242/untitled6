package PriorityQ;

import java.io.IOException;

class PriorityQApp
{
    public static void main(String[] args)
    {
        PriorityQ thePQ = new PriorityQ(5);

        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);
        thePQ.display();
        System.out.println("The remove - "+thePQ.remove());
        thePQ.display();

        System.out.println(thePQ.peekMin());
        //        while(!thePQ.isEmpty())
//        {
//            long item = thePQ.remove();
//            System.out.print(item + " "); // 10, 20, 30, 40, 50
//        }
//
//        System.out.println("");
    }

    //-------------------------------------------------------------
} // Конец класса PriorityQApp
