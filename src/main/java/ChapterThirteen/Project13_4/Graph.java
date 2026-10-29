package ChapterThirteen.Project13_4;


class Graph
{
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // Список вершин
    private int adjMat[][]; // Матрица смежности
    private int nVerts; // Текущее количество вершин
    private StackX theStack;

    // -------------------------------------------------------------
    public Graph() // Конструктор
    {
        vertexList = new Vertex[MAX_VERTS];

        // Матрица смежности
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        for(int j = 0; j < MAX_VERTS; j++) // Матрица смежности
            for(int k = 0; k < MAX_VERTS; k++) // заполняется нулями
                adjMat[j][k] = 0;

        theStack = new StackX();
    }
    // -------------------------------------------------------------
    public void warshel(){
        System.out.println("Warshel is starting: \nMatrix Before:");
        matrixOutput();
        int x,z,y; //z — начало;y — посредник;x — конец Создается свзять z -> x
        for (int i = 0; i < nVerts; i++) {//Цикл выбора промежуточной вершины(Идет по строкам)(Сейчас мы рассматриваем пути, которые можно соединить через вершину i.)
            for (int j = 0; j < nVerts; j++) { //Переменная j перебирает столбцы выбранной строки.
                if(adjMat[i][j] == 1){//Из вершины i можно попасть в вершину j?В начале работы единицы обозначают прямые рёбра. По мере работы среди них будут и найденные многошаговые пути.
                    x = j;//Концом рассматриваемого пути становится вершина из выбранного столбца.
                    y = i;//Промежуточной вершиной становится вершина из выбранной строки.
                    for (int k = 0; k < nVerts; k++) {//Ищем все начала пути.Переменная k перебирает все возможные начальные вершины:
                        if(adjMat[k][y] == 1){//Кто может попасть в выбранную промежуточную вершину y
                            z = k;//Найденная начальная вершина сохраняется в z
                            adjMat[z][x] = 1;//Мы записываем начало и конец составного пути.
                            // Промежуточная вершина уже выполнила свою роль: через неё была доказана достижимость.
                        }
                    }
                }
            }
            System.out.println("Outputting the intermediate state: =>");
            matrixOutput();
        }
    }


    // -------------------------------------------------------------
    public void addVertex(char lab)
    {
        vertexList[nVerts++] = new Vertex(lab);
    }

    // -------------------------------------------------------------
    public void addEdge(int start, int end)
    {
        adjMat[start][end] = 1;
    }
    // -------------------------------------------------------------
    public void matrixOutput(){
        System.out.println("-------------------------------------------------------------");
        System.out.print("   ");
        for (int i = 0; i < nVerts; i++) {
            System.out.print(vertexList[i].label + "|");
        }
        System.out.println();
        for (int i = 0; i < nVerts; i++) {
            System.out.print(vertexList[i].label + "| ");
            for (int j = 0; j < nVerts; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------");
    }
    // -------------------------------------------------------------
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    // -------------------------------------------------------------
    public void mst() // Построение минимального остовного дерева
    {                 //
        vertexList[0].wasVisited = true; // Пометка
        theStack.push(0); // Занесение в стек

        while(!theStack.isEmpty()) // Пока стек не опустеет
        {                          // Извлечение элемента из стека
            int currentVertex = theStack.peek();

            // Получение следующего соседа
            int v = getAdjUnvisitedVertex(currentVertex);

            if(v == -1) // Если соседей больше нет,
                theStack.pop(); // извлечь элемент из стека
            else // Сосед существует
            {
                vertexList[v].wasVisited = true; // Пометка
                theStack.push(v); // Занесение в стек

                // Вывод ребра
                displayVertex(currentVertex); // От currentVertex
                displayVertex(v); // к v
                System.out.print(" ");
            }
        }

        // Стек пуст, работа закончена
        for(int j = 0; j < nVerts; j++) // Сброс флагов
            vertexList[j].wasVisited = false;
    }

    // -------------------------------------------------------------
    // Метод возвращает непосещенную вершину, смежную по отношению к v
    public int getAdjUnvisitedVertex(int v)
    {
        for(int j = 0; j < nVerts; j++)
            if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
                return j;

        return -1;
    }

    // -------------------------------------------------------------
} // Конец класса Graph
////////////////////////////////////////////////////////////////

