package ChapterEight.TreeProject8_4;

import java.io.*;

class TreeApp
{
    public static void main(String[] args) throws IOException
    {
        int value;
        Tree theTree = new Tree();


    }

    // ------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    // ------------------------------------------------------------
    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }

    //------------------------------------------------------------
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }

// ------------------------------------------------------------
}  // Конец класса TreeApp
////////////////////////////////////////////////////////////////