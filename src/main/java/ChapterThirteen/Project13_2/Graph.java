package ChapterThirteen.Project13_2;


class Graph
{
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // Список вершин
    private LinkList[] linkLists;//Массив связных списков(Массив смежных списков)
    private int nVerts; // Текущее количество вершин
    private StackX theStack;

    // -----------------------------------------------------------
    public Graph() // Конструктор
    {
        vertexList = new Vertex[MAX_VERTS];

        // Списки смежности
        linkLists = new LinkList[MAX_VERTS];
        nVerts = 0;

        for(int j = 0; j < MAX_VERTS; j++) // Матрица смежности
            linkLists[j] = new LinkList();

        theStack = new StackX();
    }

    // -----------------------------------------------------------
    public void addVertex(char lab)//Добавляет вершину в лсит
    {
        vertexList[nVerts++] = new Vertex(lab);
    }

    // -----------------------------------------------------------
    public void addEdge(int start, int indexOfVertex)//Добавляет 2 ребра ( A -> B) ( B -> A)
    {
        linkLists[start].insertFirst(indexOfVertex);
        linkLists[indexOfVertex].insertFirst(start);
    }

    // ------------------------------------------------------------
    public void displayVertex(int v)//Вывод вершины
    {
        System.out.print(vertexList[v].label);
    }

    // ------------------------------------------------------------
    public void dfs() // Обход в глубину
    {                 // Алгоритм начинает с вершины 0
        vertexList[0].wasVisited = true; // Пометка
        displayVertex(0); // Вывод
        theStack.push(0); // Занесение в стек

        while(!theStack.isEmpty()) // Пока стек не опустеет
        {
            // Получение непосещенной вершины, смежной к текущей
            int v = getAdjUnvisitedVertex(theStack.peek());

            if(v == -1) // Если такой вершины нет,
                theStack.pop(); // элемент извлекается из стека
            else // Если вершина найдена
            {
                vertexList[v].wasVisited = true; // Пометка
                displayVertex(v); // Вывод
                theStack.push(v); // Занесение в стек
            }
        }

        // Стек пуст, работа закончена
        for(int j = 0; j < nVerts; j++) // Сброс флагов
            vertexList[j].wasVisited = false;
    }

    // ------------------------------------------------------------
    // Метод возвращает непосещенную вершину, смежную по отношению к v
    public int getAdjUnvisitedVertex(int v)
    {
        Link link = linkLists[v].find(vertexList);
        if( link != null){//Если результат не пустой - возвращаем, иначе возвращаем -1
            return link.iData;
        } else{
            return -1;
        }
    }

    // ------------------------------------------------------------
} // Конец класса Graph
////////////////////////////////////////////////////////////////
