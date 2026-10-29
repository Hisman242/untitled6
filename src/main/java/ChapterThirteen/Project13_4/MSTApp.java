package ChapterThirteen.Project13_4;

// mst.java
// Построение минимального остовного дерева
// Запуск программы: C>java MSTApp

////////////////////////////////////////////////////////////////
class MSTApp
{
    public static void main(String[] args)
    {
        Graph theGraph = new Graph();


        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4

        theGraph.addEdge(0, 1); // A → B
        theGraph.addEdge(0, 2); // A → C
        theGraph.addEdge(1, 3); // B → D
        theGraph.addEdge(2, 3); // C → D
        theGraph.addEdge(3, 4); // D → E


        theGraph.matrixOutput();
        System.out.print("Minimum spanning tree: ");
        theGraph.mst(); // Минимальное остовное дерево

        System.out.println();
        System.out.println();
        System.out.println("Warshel");
        theGraph.warshel();



    }
} // Конец класса MSTApp
////////////////////////////////////////////////////////////////

