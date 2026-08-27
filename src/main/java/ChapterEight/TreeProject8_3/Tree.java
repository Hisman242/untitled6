package ChapterEight.TreeProject8_3;

import java.util.*;               // Для использования класса Stack

class Tree
{
    private Node root;             // first node of tree

    // ------------------------------------------------------------
    public Tree()                  // Конструктор
    {
        root = null;
    }                              // Пока нет ни одного узла


    /*
    В проекте 8.3 наша задача построить дерево с помощью рекурсивного метода, который в порядке введенных букв сощдает дерево ->
                                ABCDEFG
                                    A
                              B          C
                            D  E       F  G
     */
    //Внешний метод построения дерева
    public void buildCompleteTree(String[] strings) {

        System.out.println("In buildCompleteTree"); //Сообщение о начале работы
        root = buildSubtree(root,strings,1);//Вызывает рекурсивный метод и присываивает возвращаемое значение корню дерева
        //Передаёт в метод root(в начале null), наш массив букв и номер первого узла
        System.out.println("Finish");//Сообщает о конце работы
    }
    //Рекурсивный метод, получает на вход текущий узел, массив с буквми, номер текущего узла, так же он возвращает Node
    private Node buildSubtree(Node root, String[] strings, int n) {
        //Условие выхода
        if(n > strings.length){
            //Если в массиве 5 символов, то узлы с номерами 6  и более - отсутствуют
            return null; //Возвращаем нулл для завершения рекурсии(Как правильно становится левым или правым потомком)
        }

        Node node1 = new Node();//Создаём узел
        node1.sData = strings[n-1]; //Помещаем соответствующий символ в узел
        //Используется n - 1, потому что номера узлов начинаются с 1, а индексы массива — с 0.
        root = node1; //Присваеваем в локальную переменную рут наш узел.(Это параметр метода, а не корень дерева)
        root.leftChild = buildSubtree(root.leftChild, strings,2 * n);//Строим левое поддерево 2*n - формула левого поддерева
        //Сохраняем в наш рут левого ребенка, которого мы получили
        root.rightChild = buildSubtree(root.rightChild, strings,2 * n + 1);//Строим левое поддерево 2*n + 1 - формула левого поддерева
        //Сохраняем в наш рут правого    ребенка, которого мы получили
        return root;//Возвращаем корень построенного дерева
    }

    public void traverse(int traverseType)
    {
        switch(traverseType)
        {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;

            case 2:
                System.out.print("\nInorder traversal:  ");
                inOrder(root);
                break;

            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }

        System.out.println();
    }

    // ------------------------------------------------------------
    private void preOrder(Node localRoot)
    {
        if(localRoot != null)
        {
            System.out.print(localRoot.sData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    // ------------------------------------------------------------
    private void inOrder(Node localRoot)
    {
        if(localRoot != null)
        {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.sData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    // ------------------------------------------------------------
    private void postOrder(Node localRoot)
    {
        if(localRoot != null)
        {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.sData + " ");
        }
    }

    // ------------------------------------------------------------
    public void displayTree()
    {
        Stack globalStack = new Stack();
        globalStack.push(root);

        int nBlanks = 32;
        boolean isRowEmpty = false;

        System.out.println(
                "......................................................");

        while(isRowEmpty == false)
        {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for(int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while(globalStack.isEmpty() == false)
            {
                Node temp = (Node)globalStack.pop();

                if(temp != null)
                {
                    System.out.print(temp.sData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if(temp.leftChild != null ||
                            temp.rightChild != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for(int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }

            System.out.println();
            nBlanks /= 2;

            while(localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }

        System.out.println(
                "......................................................");
    }

// ------------------------------------------------------------
}  // Конец класса Tree
