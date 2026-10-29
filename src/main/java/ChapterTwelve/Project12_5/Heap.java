package ChapterTwelve.Project12_5;

import java.util.Stack;

class Heap
{
    private Node root;//Корень пирамиды
    private int currentSize;    // Реальное кол-во узлов


    public String  path(int n){//Вычисляет маршрут к позиции с заданным номером
        StringBuilder result = new StringBuilder();//Создаем стринг билдер для формирования результирующей строки
        int[] path = new int[Integer.toBinaryString(n).length()];//Создаем массив для двоичных цифр
        int j = 0; //j указывает, куда записать очередную цифру. Сначала запись идёт в ячейку с индексом 0
        while (n >= 1) {//Пока число положительное, продолжай получать его двоичные цифры.
            path[j++] = n % 2;//n % 2 вычисляет остаток от деления на два. Он будет 0 или 1. Этот остаток записывается в path[j], после чего j увеличивается
            n = n / 2;//Делит число на два и отбрасывает дробную часть. Так ты переходишь к оставшимся двоичным цифрам.
        }
        for (int i = j - 2; i >= 0 ; i--) {//Его задача — прочитать сохранённые цифры в обратную сторону, пропустив начальную единицу.
            result.append(path[i]);//Добавляет очередную цифру к результату
        }
        return result.toString();//Возвращаем результирующую строку

    }
    // -------------------------------------------------------------
    public Heap()         // Конструктор
    {
        currentSize = 0;
        root = null;
    }

    // -------------------------------------------------------------
    public boolean isEmpty()
    {
        return currentSize == 0;
    }
    // -------------------------------------------------------------
    public Node getNodeByPath(String path){//Он получает готовый маршрут и действительно проходит по ссылкам дерева
        if(path.equals("")){//Если маршрут пустой, переходов нет. Искомый узел — сам корень.
            return root;
        }
        int indexOfPath = 0;//Номер символа маршрута, который сейчас нужно прочитать.
        Node parent = root;//current — узел, в котором мы сейчас находимся.
        Node current = root;//parent — узел, из которого выполнили последний переход.
        boolean isLeft = false;//Запоминает направление последнего перехода.
        while(indexOfPath != path.length()){//Продолжает работу, пока прочитаны не все символы маршрута.
            char c = path.charAt(indexOfPath++);//Читает текущий символ и затем увеличивает индекс.
            if(c == '0'){//if(c == '0') — проверяет, нужен ли переход влево.
                parent = current;//запоминает узел, из которого уходим.
                current = current.leftChild;//переводит локальную ссылку на левого потомка.
                isLeft = true;//запоминает направление.
            } else if(c == '1'){//Делает то же самое для перехода вправо.
                parent = current;
                current = current.rightChild;
                isLeft = false;
            }
        }
        if(isLeft){//Возвращает потомка последнего запомненного родителя с нужной стороны.
            return parent.leftChild;
        } else{//
            return parent.rightChild;
        }
    }
    // -------------------------------------------------------------
    public boolean insert(int key) {//Метод вставки
        if(root == null){//Проверяет, пустое ли дерево.
            root = new Node(key);//Создаёт первый узел и сохраняет ссылку на него как на корень.
            currentSize++;//Увеличивает количество узлов с 0 до 1
            return true;//Возвращает успешный результат.
        } else{//Если корень существует, выполняется ветка else
            String path = path(currentSize+1);//Ищем мрашрут свободного места
            Node node = new Node(key);//Создаёт новый отдельный узел с ключом
            int indexOfPath = 0;//Готовит чтение маршрута с первого символа.
            Node parent = root;
            Node current = root;
            boolean isLeft = false;
            while(indexOfPath != path.length()){//условие while проверяет, остались ли символы
                char c = path.charAt(indexOfPath++);//charAt(...) читает очередное направление
                if(c == '0'){
                    parent = current;
                    current = current.leftChild;
                    isLeft = true;
                } else if(c == '1'){
                    parent = current;
                    current = current.rightChild;
                    isLeft = false;
                }
            }
            node.parent = parent;//Новый узел запоминает своего родителя.
            if(isLeft){//Проверяет сторону найденной свободной позиции.
                parent.leftChild = node;//Присоединяет новый узел слева, если последний переход был левым
            } else{
                parent.rightChild = node;//Присоединяет справа, если последний переход был правым
            }
            trickleUp(++currentSize);//Сначала сохраняется полнота дерева(увеличиваем кол-во эл-тов), затем восстанавливается порядок ключей.
            return true;//Возвращаем успех
        }
    }
    //     -------------------------------------------------------------
    public void trickleUp(int index){//Он поднимает слишком большое значение к корню.
        int indexOfParent = (index) / 2;//Вычисляют номер родителя
        Node parentNode = getNodeByPath(path(indexOfParent));//Получаем ноду родителя
        Node currentNode = getNodeByPath(path(index));//Получаем текущий узел по индексу
        while(index > 1 && currentNode.iData > parentNode.iData ){//Проверяет одновременно две вещи: 1.Текущий узел ещё не корень. 2.Его ключ больше ключа родителя.
            int parentData = parentNode.iData;//Получаем числа родителя и текущего узла
            int currentData = currentNode.iData;
            parentNode.iData = currentData;//Происходит обмен данными. Данные из текущего узла пробрасываем вверх - в родителя
            currentNode.iData = parentData;//Данные из родителя идут вниз в ребенка(текущий узел)
            index = indexOfParent; //Текущий индекс становится индексов родителя( то есть тот куда мы пробросили данные вверх)
            indexOfParent = (index ) / 2;//Тут вычисляется новый индекс родителя
            Node parent = parentNode.parent;//Тут обновляем ссылки на узлы, родитель у нас переходит вверх( то есть это дедушка текущего родителя)
            Node currentParent = currentNode.parent;//Текущий узел становится нашим предидущим родителем(то есть тот с кем мы данными обменивались)
            parentNode =  parent;//Обновляют рабочие переменные
            currentNode = currentParent;
        }
    }
    //    // -------------------------------------------------------------
    public Node remove() {// Удаление элемента с наибольшим ключом
        if(currentSize == 1){//Проверяет, остался ли один элемент.
            Node temp = root;//Сохраняет ссылку на этот узел.
            root = null;//Убирает корень из пирамиды. Теперь дерево пустое.
            currentSize--;//Меняет количество узлов с 1 на 0.
            return temp;//Возвращает извлечённый узел.
        } else if(root != null){//Корень существует, а один узел мы уже обработали. Значит, при согласованном состоянии дерева здесь узлов как минимум два.
            Node temp = new Node(root.iData);//Создаёт отдельный объект с удаляемым ключом
            Node tempRoot = getNodeByPath(path(currentSize--));//Находит последний узел.
            root.iData = tempRoot.iData;//Копирует ключ последнего узла в существующий корень.
            Node tempParent = tempRoot.parent;//Получает готовую ссылку на родителя последнего узла.
            if(tempParent != null){//Проверяет наличие родителя.
                if(tempParent.leftChild != null && tempParent.leftChild == tempRoot){//Есть ли левый потомок.Является ли он именно тем объектом, который мы собираемся отсоединить.
                    tempParent.leftChild = null;//Если последний узел находится слева, убирает ссылку родителя на него.
                } else if(tempParent.rightChild != null && tempParent.rightChild == tempRoot){//Проверяет и отсоединяет правого потомка.
                    tempParent.rightChild = null;
                }
            }
            tempRoot.parent =  null;//Очищает обратную ссылку отсоединённого узла на прежнего родителя.
            trickleDown(1);//Восстанавливает порядок, начиная с корня.
            return temp;//Возвращает сохранённое значение  в отдельном объекте.
        } else{//Если дерево пустое
            System.out.println("Heap is empty");
            return null;
        }
    }
    // -------------------------------------------------------------
    public void trickleDown(int index){//он опускает слишком маленькое значение вниз.
        Node  currentNode = getNodeByPath(path(index));//Находит узел с заданным номером
        if(currentNode.leftChild == null && currentNode.rightChild == null){//Проверяет, нет ли обоих потомков
            System.out.println("The node at this index has no children.");//Если оба отсутствуют, узел — лист. Спускать значение ниже некуда
            return;
        }
        Node largerChild;//Будет хранить ссылку на выбранного большего потомка
        int currentData;//Будет временно сохранять значение текущего узла при обмене.
        boolean isLeft = false;//Запоминает, с какой стороны находится выбранный потомок.
        while (index <= (currentSize ) / 2){//Продолжает работу, пока текущая позиция имеет хотя бы одного потомка.
            Node leftChild = currentNode.leftChild;//Получает ссылки на непосредственных потомков текущего узла.
            Node rightChild = currentNode.rightChild;
            if((leftChild != null && rightChild != null && leftChild.iData > rightChild.iData) //оба потомка существуют, и левый больше правого.
                    || (leftChild != null && rightChild == null)){//означает: есть только левый потомок.
                isLeft = true;//Запоминается левый потомок и его сторона.
                largerChild = leftChild;
            }  else{//Выбирается правый.
                isLeft = false;
                largerChild = rightChild;
            }if(currentNode.getKey() >= largerChild.getKey()){//Спрашивает: текущее значение уже не меньше большего потомка?
                break;
            }
            currentData = currentNode.iData;//Сохраняем данные узла
            currentNode.iData = largerChild.iData;//Записывает в текущий узел ключ потомка
            largerChild.iData = currentData;//Записывает в потомка сохранённую единицу
            currentNode = largerChild;//Переводит рабочую переменную на этот нижний объект, чтобы продолжить спуск единицы
            if(isLeft){//Если перешли к левому потомку, его номер — 2 * index.
                index = 2 * index;
            } else{//Если к правому — 2 * index + 1.
                index = 2 * index + 1;
            }
        }
    }
    // -------------------------------------------------------------

    public boolean change(int index, int newValue) {//Меняет ключ в выбранной позиции
        if(index < 1 || index  > currentSize)//Проверяет допустимость номера.
            return false;
        Node currentNode = getNodeByPath(path(index));//Находит нужный узел.
        if(currentNode != null ){//Проверяет, что узел найден, прежде чем обращаться к его данным.
            int oldValue = currentNode.iData; // Сохранение старого ключа
            if(currentNode.iData == newValue){//Если число уже такое, какое требуется, операция считается успешной.
                return true;
            } else {//Если значение отличается, записывает новый ключ.
                currentNode.iData = newValue;
            }
            if(oldValue < newValue) // Если узел повышается,
                trickleUp(index);   // выполняется смещение вверх.
            else                    // Если узел понижается,
                trickleDown(index); // выполняется смещение вниз.
            return true;
        } else{//обрабатывает ситуацию, когда узел не найден.
            System.out.println("Index out of bounds.");
            return false;
        }

    }

    // -------------------------------------------------------------
    public void displayTree()
    {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;

        System.out.println("......................................................");

        while(isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for(int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while(globalStack.isEmpty() == false)
            {
                Node temp = (Node)globalStack.pop();

                if(temp != null)
                {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if(temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;
                } else {
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

        System.out.println("......................................................");
    }

    // -------------------------------------------------------------
} // Конец класса Heap
////////////////////////////////////////////////////////////////
