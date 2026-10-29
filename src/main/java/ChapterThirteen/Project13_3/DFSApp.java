package ChapterThirteen.Project13_3;


// dfs.java
// Обход в глубину
// Запуск программы: C>java DFSApp

////////////////////////////////////////////////////////////////
class DFSApp
{
    public static void main(String[] args)
    {
        Graph theGraph = new Graph();

        theGraph.addVertex('A'); // 0 (исходная вершина)
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4

        theGraph.addEdge(1, 0); // BA
        theGraph.addEdge(0, 2); // AC
        theGraph.addEdge(1, 4); // BE
        theGraph.addEdge(3, 4); // DE
        theGraph.addEdge(4, 2); // EC
        System.out.print("Visits: ");
        theGraph.dfs(0); // Обход в глубину
        System.out.println();
        System.out.println("Сonnectivity table:");
        theGraph.connectivityTable();
    }
} // Конец класса DFSApp
///////////////////////////////////////////////////////////

