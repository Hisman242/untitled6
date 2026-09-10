package ChapterNine.Project9_1;

import java.util.*;               // Для использования класса Stack

class Tree
{
    private Node root;             // first node of tree

    // ------------------------------------------------------------
    public Tree()                  // Конструктор
    {
        root = null;
    }                              // Пока нет ни одного узла

    // ------------------------------------------------------------
    private Node rightTurn(Node node){//Правый поворот
        if(node != null && node.leftChild !=null ){ //Внешний поворот
            Node grandfather = node;//Запоминает прежнюю вершину
            Node parent = node.leftChild;//запоминает её левого ребёнка, который будет подниматься
            Node transition = parent.rightChild;//сохраняет правое поддерево этого ребёнка
            parent.rightChild = grandfather;//Прежний дедушка становится правым ребёнком поднявшегося родителя
            parent.rightChild.leftChild = transition;//Левым деревом дедушки становится переходящий узел
            return parent;//Возвоазаеься глвая вершина
        } else{//Если поворот невозможен из-за отсутствия нужного узла, возвращается null
            return null;
        }
    }
    // ------------------------------------------------------------
    private Node innerLeftTurn(Node node){//Внутренний левый: LR
        if(node != null && (node.leftChild !=null)
                && (node.leftChild.rightChild != null)){ //Проверяется существование зигзага: вершина,
            //её левый ребёнок;правый ребёнок этого левого ребёнка.
            Node grandfather = node;//grandfather запоминает вершину.
            Node parent = node.leftChild;//Левый ребенок дедушки
            Node x = parent.rightChild;//Правый ребенок родителя

            /*
            Эта строка выполняется в таком порядке->
            Вызывается leftTurn(parent).
            Программа уходит внутрь обычного левого поворота.
            Тот возвращает новую вершину своего поддерева.
            Эта вершина записывается в grandfather.leftChild.
             */
            grandfather.leftChild = leftTurn(parent);
            return rightTurn(grandfather);//Возвращаем результат правого поворота относительно дедушки
        } else{//Если нужного зигзага нет, метод возвращает null.
            return null;
        }
    }
    // ------------------------------------------------------------
    private Node innerRightTurn(Node node){//Внутренний правый: RL
        if(node != null && (node.rightChild !=null)
                && (node.rightChild.leftChild != null)){ //Проверяется зеркальный зигзаг: вправо, затем влево.
            Node grandfather = node;//Запоминается вершина.
            Node parent = node.rightChild;//Запоминается её правый ребёнок.
            Node x = parent.leftChild;//Запоминается её правый ребёнок.

            grandfather.rightChild = rightTurn(parent);//Первый поворот — правый относительно родителя.
            return leftTurn(grandfather);//Второй поворот — левый относительно дедушки.
        } else{//При отсутствии нужных узлов возвращается null.
            return null;
        }
    }
    // ------------------------------------------------------------
    private Node leftTurn(Node node){//Левый поворот
        if(node != null && (node.rightChild !=null)){ //Внешний поворот(Для левого поворота нужны вершина и её правый ребёнок.)
            Node grandfather = node;//grandfather — прежняя вершина.
            Node parent = node.rightChild;//parent — правый ребёнок, который поднимется
            Node transition = parent.leftChild;//transition — его левое поддерево, которое нужно сохранить.
            parent.leftChild = grandfather;//Дедушка становится левым ребёнком поднявшегося родителя.
            parent.leftChild.rightChild = transition;// правым поддеревом дедушки становится transition.
            return parent;//Возвращаем новую вершину
        } else{//Если нет необходимых узлов, поворот не выполняется.
            return null;
        }
    }
    // ------------------------------------------------------------
    public Node find(int key)      // Поиск узла с заданным ключом
    {                              // (предполагается, что дерево не пустое)
        Node current = root;       // Начать с корневого узла

        while(current.iData != key)    // Пока не найдено совпадение
        {
            if(key < current.iData)    // Двигаться налево?
                current = current.leftChild;
            else                       // Или направо?
                current = current.rightChild;

            if(current == null)        // Если потомка нет,
                return null;           // поиск завершился неудачей
        }

        return current;                // Элемент найден
    }

    // ------------------------------------------------------------
    public void insert(int id, double dd) { //Вставка
        Node newNode = new Node();     // Создание нового узла
        newNode.iData = id;            // Вставка данных
        newNode.dData = dd;
        newNode.isRed = true;          //Делаем наш узел красным
        if (root == null){ // Корневой узел не существует
            root = newNode; //Коренем становится наш новый э-т
            root.isRed = false; //Корень всегда черный
        } else {// Корневой узел занят
            Node greatGrandfather = null;//Ссылка на прадедушку
            Node grandfather = null;//Ссылка на дедушку
            Node parent = null;//Ссылка на родителя
            Node current = root;       // Начать с корневого узла(Ссылка на рассматриваемый узел)


            while(true)                // (внутренний выход из цикла)
            {



                //Проверка необходимости flip
                /*
                Тут мы проверяем есть ли у нас вообще текущий узел, существует ли левый ребенок,
                существует ли правый ребенок, текущий узел черный?, левый ребенок красный?,
                правый ребенок красный, если да то заходим внутрь

                Если текущий узел черный и у него два красный ребенка, нужно сделать флип
                 */
                if( current != null && current.leftChild != null
                        && current.rightChild != null
                        && !current.isRed && current.leftChild.isRed
                        && current.rightChild.isRed ){
                    if(current != root){//Если текущий узел корень, то не делаем его красным правило 2.
                        current.isRed = true;
                    } else{ //Иначе узел не является корнем всего дерева, становится красным
                        current.isRed = false;
                    }
                    current.leftChild.isRed = false;//Потомки становятся черными
                    current.rightChild.isRed = false;
                    //Выполняем проверку конфликта, если родителя нет или он черный, поворота не будет
                    //Иначе произойдут повороты и конфликт будет исправлен
                    redOnRedConflict(greatGrandfather,grandfather,parent,current);
                }
                //Движение ссылок(Сдвиг ссылок)
                greatGrandfather = grandfather;
                grandfather = parent;
                parent = current;

                if(id < current.iData) // Двигаться налево?
                {

                    current = current.leftChild; //Передвигаем ссылку текущего узла

                    if(current == null)    // Если достигнут конец цепочки,
                    {                     // вставить слева
                        parent.leftChild = newNode;
                        current = newNode; //Делает вставленный узел текущим
                        if(!parent.isRed){ //Если родитель черный - возвращаем управление
                            return;
                        } else{ //Иначе родитель красный, приводит к конфликту красный-красный
                            redOnRedConflict(greatGrandfather,grandfather,parent,current);
                            return;//Вызываем метод решения конфликта, возвращаем управление

                        }

                    }
                } else                       // Или направо?
                {
                    current = current.rightChild;//Передвигаем ссылку

                    if(current == null)    // Если достигнут конец цепочки,
                    {                     // вставить справа

                        parent.rightChild = newNode;
                        current = newNode;//Присваеваем текущему узлу вставленный узел
                        if(!parent.isRed){  //Если родитель черный - возвращаем управление
                            return;
                        } else{//Иначе родитель красный, приводит к конфликту красный-красный
                            redOnRedConflict(greatGrandfather,grandfather,parent,current);
                            return;//Вызываем метод решения конфликта, возвращаем управление
                        }

                    }
                }
            }
        }
    }

    // ------------------------------------------------------------
    //Метод исправления конфликта
    private void redOnRedConflict(Node greatGrandfather,
                                  Node grandfather,
                                  Node parent,
                                  Node current){ // Получает четыре ссылки на узлы от метода вставки
        //Определение положения дедеушки
        boolean grandfatherIsLeftChild =  false;//дедушка находится слева от прадедушки?
        boolean grandfatherIsRoot = false;//дедушка является корнем?
        boolean grandfatherIsRightChild = false;//дедушка находится справа от прадедушки?
        if(grandfather != null && grandfather == root){//Проверяем существование дедушки
            //И солучай когда дедушка тот же объект что и корень
            grandfatherIsRoot = true;//Если да - меняем флаг
        } else if(grandfather != null && greatGrandfather.leftChild == grandfather){
            //Проверяется существование дедушки и является ли он левой ссылкой прадедушки
            grandfatherIsLeftChild = true;//Если да - то меняем флаг
        } else if(grandfather != null && greatGrandfather.rightChild == grandfather){
            //Проверяется существование дедушки и является ли он правой ссылкой прадедушки
            grandfatherIsRightChild = true;//Если да - то меняем флаг
        }

        Node newTop = null;//Будущая вершина(ссылка на вершину)

        //Проверяем что текущий узел и родитель - это разные объекты, родитель существует,
        //дедушка существует, родитель - красный, текущий узел красный(Последние два условия - и есть конфликт)
        if(current != parent && parent != null
                && grandfather != null
                && parent.isRed
                && current.isRed){//Конфликт красный-красный

            //Внешний случай LL, дедушка существует, есть левый ребенок, левый ребенок родителя -
            //-текущий узел
            if(grandfather != null
                    && grandfather.leftChild != null
                    && grandfather.leftChild == parent
                    && parent.leftChild == current){ //Внешний лево
                parent.isRed = false;//Родитель становится черным
                grandfather.isRed = true;//Дедушка становится красным
                newTop = rightTurn(grandfather); //Выполняется правый поворот относительно дедушки
                //Внешний правый случай RR, родитель находится справа от дедушки,
                //Текущий узел находится справа от родителя
            } else if(grandfather != null
                    && grandfather.rightChild != null
                    && grandfather.rightChild == parent
                    && parent.rightChild == current){//Внешний право
                parent.isRed = false;//Родитель становится черным
                grandfather.isRed = true;//Дедушка становится красным
                newTop = leftTurn(grandfather);//Выполняется левый поворот относительно дедушки

                //Внутренний левый случай LR, родитель находится слева от дедушки,
                //текущий узел находится справа от родителя
            } else if(grandfather != null
                    && grandfather.leftChild != null
                    && grandfather.leftChild == parent
                    && parent.rightChild == current){ //Внутренний лево
                grandfather.isRed = true;//Дедушка становится красным
                current.isRed = false;//Внутренний внук становится черным
                newTop =  innerLeftTurn(grandfather);//Выполняется двойной поворот.
                //Наверх поднимается прежний current, он и становится newTop,
                //Цвет прежнего parent здесь не меняется: он остаётся красным.

                //Внутренний правый случай: RL, Родитель справа от дедушки.
                //Текущий узел слева от родителя.
            } else if(grandfather != null
                    && grandfather.rightChild != null
                    && grandfather.rightChild == parent
                    && parent.leftChild == current){ //Внутренний право
                grandfather.isRed = true;//Дедушка становится красным.
                current.isRed = false;//Текущий внутренний внук становится чёрным
                newTop =  innerRightTurn(grandfather);//Двойной поворот поднимает его наверх.
                //Он сохраняется в newTop
            }
            //Присоединение результата к дереву
            if(newTop != null  && grandfatherIsRoot){//Если дедушка был корнем
                root = newTop; //Меняем поле рут всего дерева
            } else if(newTop != null && grandfatherIsLeftChild){//Если дедушка был левым ребенком прадедушки
                greatGrandfather.leftChild = newTop;//Левая ссылка прадедушки становится нвовой вершиной
            } else if(newTop != null && grandfatherIsRightChild){//Если дедушка был правым ребенком прадедушки
                greatGrandfather.rightChild = newTop;//Правая ссылка прадедушки становится нвовой вершиной
            }

        }
    }

    // ------------------------------------------------------------
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
            System.out.print(localRoot.iData + " ");
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
            System.out.print(localRoot.iData + " ");
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
            System.out.print(localRoot.iData + " ");
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
                    if(temp.isRed){
                        System.out.print(temp.iData + " R");
                    } else{
                        System.out.print(temp.iData + " B");

                    }

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
////////////////////////////////////////////////////////////////