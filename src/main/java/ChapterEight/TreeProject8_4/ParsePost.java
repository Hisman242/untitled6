package ChapterEight.TreeProject8_4;

class ParsePost
{
    private StackX theStack;//Стек промежуточных деревьев
    private String input;//Постфиксная строка
    //-------------------------------------------------------------
    public ParsePost(String s)//Конструктор
    {
        input = s;
    }

    //-------------------------------------------------------------
    public Tree doParse()//Строит и возвращает дерево
    {
        theStack = new StackX(20);             // Создание объекта стека
        char ch;//Текущий символ
        int j;//Индекс символа в строке

        for(j=0; j<input.length(); j++)       // Для каждого символа
        {

            ch = input.charAt(j);              // Чтение символа
            theStack.displayStack(""+ch+" ");  // *диагностика*(Показывает состояние стека)
            Node tempNode = new Node();//Для текущего символа создается узел
            tempNode.iData =  (ch);//Символ помещается в узел
            if(Character.isLetterOrDigit(ch)){ //Если символ буква или цифра
                Tree tempTree = new Tree();//Создаем пустое дерево, если символ является операндом
                tempTree.root = tempNode;//Созданный узел(tempNode) становится корнем
                theStack.push(tempTree);//Помещаем одноузловое дерево в стек
            } else if(theStack.size() > 1){// Если это оператор и в стеке есть хотя бы два дерева, то входим
                //Так как в стеке последний добавленный выходит первым, мы сначала извлекаем правое, а потом левое поддерево
                Tree tree2 = theStack.pop();//Извлекаем правое поддерево
                Tree tree1 = theStack.pop();//Извлекаем левое поддерево
                Tree mergeTree = new Tree();//Создаём новое дерево, в которое мы будем объединять наши поддеревья(трее1 и трее2)
                mergeTree.root = tempNode;//Оператор становится корнем дерева
                mergeTree.root.leftChild = tree1.root;//Корень tree1 становится левым потомком оператора
                mergeTree.root.rightChild = tree2.root;//Корень tree2 становится правым потомком оператора

                theStack.push(mergeTree);        // Занесение промежуточного
            }                                   // результата в стек
        }
        return theStack.pop();//Возвращаем готовое дерево(резултат)
    }
}  // Конец класса ParsePost
////////////////////////////////////////////////////////////////