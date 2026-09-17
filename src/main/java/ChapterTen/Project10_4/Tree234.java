package ChapterTen.Project10_4;
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
    public void insert(long dValue)
    {
        Node parent = null;
        Node curNode = root;
        DataItem tempItem = new DataItem(dValue);

        while (true){
            if(curNode != null){
                if(curNode.isLeaf()){
                    if(curNode == root && curNode.getNumItems() == 2){
                        curNode.insertItem(tempItem);
                        split(curNode);
                        break;
                    }

                    if(curNode.getNumItems() < 2 || parent != null &&  parent.getNumItems() < 2){
                        curNode.insertItem(tempItem);
                    } else{
                        System.out.println("Unable to insert");
                        return;
                    }
                    if(curNode.getNumItems() == 3){
                        split(curNode);
                    }
                    break;
                } else {
                    if(curNode.getNumItems() >= 1){
                        parent = curNode;
                        curNode = getNextChild(curNode, dValue);
                    }
                }
            } else{
                System.out.println("Current node is null");
                return;
            }

        }
    }

    // -------------------------------------------------------------
    public boolean split(Node thisNode) // Разбиение узла
    {

        if(thisNode == root  && !root.isLeaf() && root.getNumItems() >= 2
                ||
                thisNode  != root &&  thisNode.getParent().isFull()){
            System.out.println("Partitioning is not supported.");
            return false;
        }

        // Предполагается, что узел полон
        DataItem itemB, itemC;
        Node parent;
        int itemIndex;

        itemC = thisNode.removeItem(); // Удаление элементов из
        itemB = thisNode.removeItem(); // текущего узла


        Node newRight = new Node(); // Создание нового узла

        if(thisNode == root && root.isLeaf()) // Если узел является корнем, и листом
        {

            root = new Node(); // Создание нового корня
            parent = root; // Корень становится родителем
            root.connectChild(0, thisNode); // Связывание с родителем
        }
        else // Текущий узел не является корнем
            parent = thisNode.getParent(); // Получение родителя
        // Разбираемся с родителем
        itemIndex = parent.insertItem(itemB); // B вставляется в родителя
        int n = parent.getNumItems(); // Всего элементов?

        for(int j=n-1; j>itemIndex; j--) // Перемещение связей
        {                                // родителя
            Node temp = parent.disconnectChild(j); // На одного потомка
            parent.connectChild(j+1, temp);         // вправо
        }

        // Связывание newRight с родителем
        parent.connectChild(itemIndex+1, newRight);

        // Разбираемся с узлом newRight
        newRight.insertItem(itemC); // Элемент C в newRight
        return true;
    }

    // -------------------------------------------------------------
    // Получение соответствующего потомка при поиске значения
    public Node getNextChild(Node theNode, long theValue)
    {
        int j;

        // Предполагается, что узел не пуст, не полон и не является листом
        int numItems = theNode.getNumItems();

        for(j=0; j<numItems; j++) // Для каждого элемента в узле
        {                         // Наше значение меньше?
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

        for(int j=0; j<numItems+1; j++)
        {
            Node nextNode = thisNode.getChild(j);

            if(nextNode != null)
                recDisplayTree(nextNode, level+1, j);
            else
                return;
        }
    }

// -------------------------------------------------------------
} // Конец класса Tree234
