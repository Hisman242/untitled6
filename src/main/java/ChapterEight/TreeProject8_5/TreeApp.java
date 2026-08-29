package ChapterEight.TreeProject8_5;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Scanner;

class TreeApp
{
    public static void main(String[] args) throws IOException {

        Huffman huffman = new Huffman();
        System.out.println("Enter your text message");
        String[] arr = new String[10];
        String message = "";
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!(message = br.readLine()).equals("")){
            arr[count++] = message;
        }

        System.out.println(Arrays.toString(arr));
        huffman.buildHuffmanTree(arr, count);
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