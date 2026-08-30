package ChapterEight.TreeProject8_5;

import java.io.*;
class TreeApp
{
    public static void main(String[] args) throws IOException {

        Huffman huffman = new Huffman();//Создаем объект, который выполняет основную работу
        System.out.println("Enter your text message");
        String[] arr = new String[1024];//Создаем массив, в котором будут наши введенные строки
        String message = "";//Переменная одной прочитаной строки
        int count = 0;//Кол-во введенных строк
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//Поток ввода
        while(!(message = br.readLine()).equals("")){//Цикл ввода
            arr[count++] = message;//Добавляем в массив прочитанную строчку
        }
        System.out.println("Your message:");//Выводим наше сообщение
        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
        huffman.buildHuffmanTree(arr,count);//Запукск алгоритма Дэвида Хаффмана
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