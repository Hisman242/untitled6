package ChapterEight.TreeProject8_5;

import java.util.*;               // Для использования класса Stack

class Tree
{
    public Node root;             // first node of tree

    // ------------------------------------------------------------
    public Tree()                  // Конструктор
    {
        root = null;
    }                              // Пока нет ни одного узла

    // ------------------------------------------------------------
    public void traverse(int traverseType)//Запускает 1 из 3 обходов
    {
        switch(traverseType) //Проверка переданного числа
        {
            case 1:
                System.out.print("\nPreorder traversal: ");//Выбираем прямой
                preOrder(root);
                break;

            case 2:
                System.out.print("\nInorder traversal:  ");//Выбираем симметричный
                inOrder(root);
                break;

            case 3:
                System.out.print("\nPostorder traversal: ");//Выбираем обратный
                postOrder(root);
                break;
        }

        System.out.println();
    }

    // ------------------------------------------------------------
    private void preOrder(Node localRoot)//Прямой
    {
        if(localRoot != null)
        {
            System.out.print(localRoot.cData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    // ------------------------------------------------------------
    private void inOrder(Node localRoot)//Симметричный
    {
        if(localRoot != null)
        {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.cData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    // ------------------------------------------------------------
    private void postOrder(Node localRoot)//Обратный
    {
        if(localRoot != null)
        {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.cData + " ");
        }
    }

    // ------------------------------------------------------------
    public void displayTree()//Метод вывода всего дерева
    {
        Stack globalStack = new Stack(); //Создаем стек текущего уровня
        globalStack.push(root);//Отправляем в стек корень дерева

        int nBlanks = 32;//Кол-во отступов перед узлами
        boolean isRowEmpty = false;//Флаг показывает, остались ли ещё нижние уровни дерева.

        System.out.println("......................................................");

        while(isRowEmpty == false)//Каждая итерация выводит один уровень дерева
        {
            Stack localStack = new Stack();//Второй стек для сбора потомков для следующего уровня
            isRowEmpty = true;//В начале предпологаем что ниже ничего нет

            for(int j = 0; j < nBlanks; j++) //Перед первым узлом печатаем пробелы
                System.out.print(' ');

            while(globalStack.isEmpty() == false)//Выполняем пока на нашем(текущем) уровне остаются узлы
            {
                Node temp = (Node)globalStack.pop();//Извлекаем узел из стека

                if(temp != null)//Если узел существует
                {
                    if(temp.cData == '\0'){//Внутренний ли это узел? Если да, то у него нет символа и мы выводим только частоту
                        System.out.print(temp.frequency);
                    } else{
                        if(temp.cData == '\n'){ //Если вывести \n мы сломаем вывод и перейдем на следующую строку, поэтому выводим текстовую замену
                            System.out.print("nl" + " " + temp.frequency);//нл - нью лайн(перенос строки)
                        } else if(temp.cData == ' '){//Пробел тоже плохо виден, поэтому печатаем сп(спейс - пробел)
                            System.out.print("sp" + " " + temp.frequency);
                        }else{ //Иначе обычный символ, печатаем его и кол-во повторов(частоту)
                            System.out.print(temp.cData + " " + temp.frequency);
                        }



                    }

                    localStack.push(temp.leftChild);//В стек следующего уровня отправляем правого и левого ребенка
                    localStack.push(temp.rightChild);

                    if(temp.leftChild != null || temp.rightChild != null) //Если есть хоть один потомок, значит дерево продолжается
                        isRowEmpty = false;
                }
                else //Иначе выводим --(значит узла нет) и помещаем два null в стек
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for(int j = 0; j < nBlanks * 2 - 2; j++) //После вывода каждого узла добавляется расстояние до следующего узла уровня
                    System.out.print(' ');
            }

            System.out.println(); //Переходим на следующую строчку
            nBlanks /= 2; //Отступ уменьшяется в два раза

            while(localStack.isEmpty() == false)//Переносим эл-ты из локального стека в стек текущего уровня(глобальный)
                globalStack.push(localStack.pop());//Специально меняем порядок выше,были помещены левый и правый, правый помещается в глобал стек а потом левый
        }//Но так как это стек, то уже в глобал стеке у нас сначала достается левый и потом только правый(Смена порядка)

        System.out.println("......................................................");
    }

// ------------------------------------------------------------
}  // Конец класса Tree
////////////////////////////////////////////////////////////////