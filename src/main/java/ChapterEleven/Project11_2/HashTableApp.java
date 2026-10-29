package ChapterEleven.Project11_2;

// hash.java
// Реализация хеш-таблицы с линейным пробированием
// Запуск программы: C:>java HashTableApp

import java.io.*;

////////////////////////////////////////////////////////////////
class HashTableApp
{
    public static void main(String[] args) throws IOException
    {
        DataItem dataItem = new DataItem("awdhadjh");
        DataItem dataItem1 = new DataItem("awdhadwdwjh");
        DataItem dataItem2 = new DataItem("nellipopapap");
        DataItem dataItem3 = new DataItem("amazonneprospi");
        HashTable hashTable = new HashTable(11);
        hashTable.insert(dataItem);
        hashTable.insert(dataItem1);
        hashTable.insert(dataItem2);
        hashTable.insert(dataItem3);
        hashTable.displayTable();
    }

    //--------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    //--------------------------------------------------------------
    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }

    //-------------------------------------------------------------
} // Конец класса HashTableApp
////////////////////////////////////////////////////////////////
