package ChapterEight.TreeProject8_3;

import java.io.*;
import java.util.Arrays;

class TreeApp
{
    public static void main(String[] args) throws IOException {
        System.out.println("Please enter a string");
        String text = getString();
        String[] strings = text.split("");
        System.out.println("Your line -> " + Arrays.toString(strings));
        Tree tree = new Tree();
        tree.buildCompleteTree(strings);
        tree.displayTree();



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