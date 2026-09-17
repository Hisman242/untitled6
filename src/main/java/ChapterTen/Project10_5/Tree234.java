package ChapterTen.Project10_5;


class Tree234
{
    private Node root = new Node(); // Создание корневого узла

    // -------------------------------------------------------------
    public int find(long key)
    {
        Node curNode = root;
        int childNumber;

        while(true)
        {
            if((childNumber = curNode.findItem(key)) != -1)
                return childNumber; // Узел найден
            else if(curNode.isLeaf())
                return -1; // Узел не найден
            else // Искать глубже
                curNode = getNextChild(curNode, key);
        }
    }

    // -------------------------------------------------------------
    // Вставка элемента данных
    public void insert(long dValue) {
        Node curNode = root;
        DataItem tempItem = new DataItem(dValue);

        while(true)
        {
            if(curNode.isLeaf()){
                if(curNode.getNumItems() <= 2){
                    curNode.insertItem(tempItem);
                }
                if(curNode.getNumItems() == 3){
                    split(curNode);
                }
                break;
            } else if(curNode.getNumItems() >= 1) {
                curNode = getNextChild(curNode, dValue);
            }
        }
    }

    // -------------------------------------------------------------
    public Node split(Node thisNode) // Разбиение узла
    {

        // Предполагается, что узел полон
        DataItem itemB ;//itemB — средний ключ, поднимаемый к родителю.
        DataItem itemC;//itemС — наибольший ключ, переносящийся в newRight.
        Node parent;//parent — родитель разделяемого узла.
        Node child1;//child1, child2 — отсоединённые потомки.
        Node child2;
        int itemIndex;//itemIndex — позиция, на которую itemB вставился в родителя.

        itemC = thisNode.removeItem(); // Удаление элементов из
        itemB = thisNode.removeItem(); // текущего узла
        child1 = thisNode.disconnectChild(1); // Отсоединение потомков
        child2 = thisNode.disconnectChild(2); // от текущего узла
        Node newRight = new Node(); // Создание нового узла

        if(thisNode == root ) // Если узел является корнем
        {
            root = new Node(); // Создание нового корня
            parent = root; // Корень становится родителем
            root.connectChild(0, thisNode); // Связывание с родителем
        }
        else // Текущий узел не является корнем
            parent = thisNode.getParent(); // Получение родителя
        // Разбираемся с родителем
        itemIndex = parent.insertItem(itemB); // B вставляется в родителя
        //Родитель тоже переполнился? Проверяется, содержит ли родитель теперь три ключа.
        if(thisNode != root && thisNode.getParent().getNumItems() == 3){
            Node right = split(thisNode.getParent());//Метод вызывает сам себя и разделяет родителя.прежняя переменная parent указывает на левую половину,
            //переменная right указывает на правую половину
            if(itemIndex == 0){//Это означает, что B был самым маленьким ключом.
                parent.connectChild(1, newRight);//thisNode уже находится на позиции 0.Поэтому остаётся подключить newRight на позицию 1
            } else if(itemIndex == 1){//Это означает, что B находился посередине.Части текущего узла должны разойтись
                parent.connectChild(parent.getNumItems(),thisNode);//После разделения в parent находится один ключ,Поэтому thisNode подключается справа от ключа родителя.
                right.connectChild(0, newRight);//newRight подключается как первый, то есть левый, потомок правой половины
            } else if(itemIndex == 2){//Это означает, что B был самым большим ключом.
                Node descendant = right.disconnectChild(0);//Потомок с позиции 0 временно сохраняется в descendant.
                right.connectChild(0, thisNode);//thisNode становится левым потомком
                right.connectChild(1, newRight);//newRight становится правым потомком
                parent.connectChild(parent.getNumItems(),descendant);//descendant подключается как правый потомок левой половины родителя
            }

            // Разбираемся с узлом newRight
            newRight.insertItem(itemC); // Элемент C в newRight
            newRight.connectChild(0, child1); // Связывание 0 и 1
            newRight.connectChild(1, child2); // с newRight
            return newRight;
        }
        int n = parent.getNumItems(); // Всего элементов?

        for(int j = n - 1; j > itemIndex; j--) // Перемещение связей
        {                                       // родителя
            Node temp = parent.disconnectChild(j); // На одного потомка
            parent.connectChild(j + 1, temp);      // вправо
        }

        // Связывание newRight с родителем
        parent.connectChild(itemIndex + 1, newRight);

        // Разбираемся с узлом newRight
        newRight.insertItem(itemC); // Элемент C в newRight
        newRight.connectChild(0, child1); // Связывание 0 и 1
        newRight.connectChild(1, child2); // с newRight
        return newRight;
    }

    // -------------------------------------------------------------
    // Получение соответствующего потомка при поиске значения
    public Node getNextChild(Node theNode, long theValue)
    {
        int j;

        // Предполагается, что узел не пуст, не полон и не является листом
        int numItems = theNode.getNumItems();

        for(j = 0; j < numItems; j++) // Для каждого элемента в узле
        {                             // Наше значение меньше?
            if(theValue < theNode.getItem(j).dData)
                return theNode.getChild(j); // Вернуть левого потомка
        }

        // Наше значение больше,
        return theNode.getChild(j); // Вернуть правого потомка
    }

    // -------------------------------------------------------------
    public void displayTree()
    {
        recDisplayTree(root, 0, 0);
    }

    // -------------------------------------------------------------
    private void recDisplayTree(Node thisNode, int level,
                                int childNumber)
    {
        System.out.print("level=" + level + " child=" + childNumber + " ");
        thisNode.displayNode(); // Вывод содержимого узла

        // Рекурсивный вызов для каждого потомка текущего узла
        int numItems = thisNode.getNumItems();

        for(int j = 0; j < numItems + 1; j++)
        {
            Node nextNode = thisNode.getChild(j);

            if(nextNode != null)
                recDisplayTree(nextNode, level + 1, j);
            else
                return;
        }
    }

    // -------------------------------------------------------------
} // Конец класса Tree234