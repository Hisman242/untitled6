package ChapterEight.TreeProject8_4;

// postfix.java
// Разбор постфиксных арифметических выражений
// Запуск программы: C>java PostfixApp
import java.io.*;              // Для ввода/вывода

////////////////////////////////////////////////////////////////
class PostfixApp
{
    public static void main(String[] args) throws IOException
    {
        String input;
        Tree output;

        while(true)
        {
            System.out.print("Enter postfix: ");
            System.out.flush();

            input = getString();         // Ввод строки с клавиатуры

            if( input.equals("") )       // Завершение, если нажата клавиша
                break;                   // [Enter]

            // Создание объекта для разбора выражения
            ParsePost aParser = new ParsePost(input);

            output = aParser.doParse();  // Обработка выражения и создание дерева
            System.out.println("Displaying the tree");
            output.displayTree(); //Вывод дерева
            System.out.println("We perform a tree traversal");

            output.traverse(1);//Выполняем прямой обход
            output.traverse(2);//Выполняем симметричный обход
            output.traverse(3);//Выполняем обратный обход



        }
    }

    //-------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

//-------------------------------------------------------------
}  // Конец класса PostfixApp
////////////////////////////////////////////////////////////////