package ChapterThirteen.Project13_1;

// bfs.java
// Обход в ширину
// Запуск программы: C>java BFSApp

////////////////////////////////////////////////////////////////
class BFSApp
{
    public static void main(String[] args)
    {
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); // 0 (исходная вершина)
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        theGraph.addVertex('F'); // 5
        theGraph.addVertex('G'); // 6
        theGraph.addVertex('H'); // 7
        theGraph.addVertex('I'); // 8


        theGraph.addEdge(0,1);
        theGraph.addEdge(0,2);
        theGraph.addEdge(0,3);
        theGraph.addEdge(0,4);
        theGraph.addEdge(0,5);
        theGraph.addEdge(1,1);
        theGraph.addEdge(1,2);
        theGraph.addEdge(2,3);
        theGraph.addEdge(3,4);
        theGraph.addEdge(5,6);
        theGraph.addEdge(7,8);
        theGraph.addEdge(8,1);

        System.out.print("Minimum spanning tree: ");
        theGraph.mst(); // Минимальное остовное дерево
        System.out.println();
    }
}
////////////////////////////////////////////////////////////////
