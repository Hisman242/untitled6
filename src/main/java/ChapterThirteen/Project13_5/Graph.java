package ChapterThirteen.Project13_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Graph {
    private final int MAX_VERTS;//Хранит размер стороны доски.
    private int adjMat[][]; // Двумерный массив — доска.
    private StackX theStack;//Стек текущего маршрута.
    private int marker1 = -1;//Значение для обозначения занятой клетки.
    private int counter  = 1;//Количество позиций текущего маршрута.
    // -----------------------------------------------------------
    public Graph(int dimension) // Конструктор.Получает размер стороны доски.
    {
        MAX_VERTS = dimension;//Сохраняет размер.

        // Создаёт квадратную доску.
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        int num = 1;//Локальный счётчик номеров клеток.
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = num++;//В ячейку записывается текущее значение num, затем оно увеличивается на единицу.
            }
        }
        int sizeStack = MAX_VERTS * MAX_VERTS;//Вычисляет количество клеток
        theStack = new StackX(sizeStack);
    }
    // -------------------------------------------------------------
    public void matrixOutput(){//Метод показывает состояние доски.
        System.out.println("-------------------------------------------------------------");
        int count = 1;//Создаёт локальный счётчик номеров для отображения клеток.
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                if(adjMat[i][j] == marker1){//Проверяет, входит ли клетка в текущий маршрут.Если в ней -1:
                    System.out.print(" ♞ ");//Показывает коня.
                    count++;//Переходит к номеру следующей клетки.
                } else{//Если клетка свободна:
                    System.out.print(" " + count++ + " ");//Выводит её номер, затем увеличивает count.
                }
            }
            System.out.println();//После завершения внутреннего цикла переводит вывод на следующую строку доски.
        }
        System.out.println("-------------------------------------------------------------");
    }
    // -------------------------------------------------------------
    public void knightsMove(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//Подготовка ввода
        //Начальная позиция
        theStack.push(0);//Строка
        theStack.push(0);//Столбец
        theStack.push(0);//Продолжения из этой позиции ещё не выбирались
        adjMat[0][0] = marker1;//Отмечает начальную клетку занятой.
        while(counter != MAX_VERTS * MAX_VERTS){//Цикл продолжается, пока текущий маршрут не содержит все 25 клеток.
            try {
                br.readLine();//Ожидание Enter
            } catch (IOException e) {//Если при чтении возникнет IOException, выполнение перейдёт в catch.
                System.out.println("Exeption: " + e.getMessage());
            }
            if (theStack.isEmpty()){//Проверка пустого стека
                System.out.println("Error, stack is Empty");
                return;
            }
            int option = theStack.peek();//Читает информацию о переборе у текущей позиции.
            int row = theStack.peekSecond();//Читает её строку.
            int column = theStack.peekNext();//Читает её столбец.
            int res = availableKnightMove(row, column,option);//Передаёт текущие координаты и закладку перебора в метод поиска.

            if(res == -2){//Если ничего не подошло - удаляется целая последняя позиция.
                int optionRec = theStack.pop(); // Сначала извлекается её option
                int colRec =  theStack.pop();//Затем извлекается столбец.
                int rowRec = theStack.pop();//Затем строка.
                adjMat[rowRec][colRec] = 0;//Освобождает отменённую клетку.
                counter--;//Уменьшает длину маршрута на одну позицию.
            } else{ // Если res равен числу от 1 до 8, выполняется:
                counter++;//Добавление новой позиции увеличивает длину текущего маршрута на один
                switch(res){
                    case 1://Эта ветка выполняется, когда найден вариант № 1.
                        theStack.pop();//Удаляет старое значение option текущей позиции.
                        theStack.push(1);//Записывает вместо старого option выбранный вариант 1.
                        theStack.push(row+2);//Добавляет строку новой позиции.
                        theStack.push(column+1);//Добавляет столбец новой позиции.
                        theStack.push(0);//Добавляет начальную закладку новой позиции. Ноль означает: Из новой позиции ещё не выбирали продолжения.
                        break;//Завершает switch
                    /*
                        Во всех оставшихся ветках одинаковы три действия:
                        1. pop() убирает старый option текущей позиции.
                        2. Первый push() записывает номер выбранного продолжения.
                        3. Последний push(0) создаёт начальный option новой позиции.
                     */
                    case 2:
                        theStack.pop();
                        theStack.push(2);
                        theStack.push(row+2);
                        theStack.push(column-1);
                        theStack.push(0);
                        break;
                    case 3:
                        theStack.pop();
                        theStack.push(3);
                        theStack.push(row-2);
                        theStack.push(column+1);
                        theStack.push(0);
                        break;
                    case 4:
                        theStack.pop();

                        theStack.push(4);
                        theStack.push(row-2);
                        theStack.push(column-1);
                        theStack.push(0);
                        break;
                    case 5:
                        theStack.pop();
                        theStack.push(5);
                        theStack.push(row+1);
                        theStack.push(column+2);
                        theStack.push(0);

                        break;
                    case 6:
                        theStack.pop();
                        theStack.push(6);
                        theStack.push(row-1);
                        theStack.push(column+2);
                        theStack.push(0);

                        break;
                    case 7:
                        theStack.pop();
                        theStack.push(7);
                        theStack.push(row+1);
                        theStack.push(column-2);
                        theStack.push(0);

                        break;
                    case 8:
                        theStack.pop();
                        theStack.push(8);
                        theStack.push(row-1);
                        theStack.push(column-2);
                        theStack.push(0);

                        break;
                }
            }
            matrixOutput();//Выводится новое состояние доски.
        }
        System.out.println("Finish");//Если counter достиг количества клеток, цикл заканчивается.
    }
    // ------------------------------------------------------------
    public int  availableKnightMove(int row, int column, int option){//Строка, столбец, последний ход
        if(row >= 0 && row < MAX_VERTS && column >= 0 && column < MAX_VERTS){//Проверка валидности координат ( не выходит ли у нас что - то за границы матрицы)
            if((row + 2) < MAX_VERTS && column + 1 < MAX_VERTS && adjMat[row+2][column+1] != marker1 && (option < 1)){//Ход вперед на две клетки и вправо
                adjMat[row+2][column+1] = marker1;
                return 1;
            } else if((row + 2) < MAX_VERTS  && (column - 1) >= 0 && adjMat[row+2][column-1] != marker1 && (option < 2)){//Случай когда мы ходим вперед на две клетки и влево
                adjMat[row+2][column-1] = marker1;
                return 2;
            } else if((row - 2) >= 0 &&  (column + 1) < MAX_VERTS && adjMat[row-2][column+1] != marker1 && (option < 3)){ // Случай когда мы ходим вниз на две клетки и потом вправо
                adjMat[row-2][column+1] = marker1;
                return 3;
            } else if((row - 2) >= 0 &&  (column - 1) >= 0  && adjMat[row-2][column-1] != marker1 && (option < 4)){// Случай когда мы ходим вниз на две клетки и потом влево
                adjMat[row-2][column-1] = marker1;
                return 4;
            } else if((column + 2) < MAX_VERTS && (row + 1) < MAX_VERTS && adjMat[row+1][column+2] != marker1 && (option < 5)){// Случай когда мы ходим вправо на две клетки и вверх на одну
                adjMat[row+1][column+2] = marker1;
                return 5;
            } else if((column + 2) < MAX_VERTS && (row - 1) >= 0 && adjMat[row-1][column+2] != marker1  && (option < 6)){// Случай когда мы ходим вправо на две клетки и вниз на одну
                adjMat[row-1][column+2] = marker1;
                return 6;
            } else if((column - 2) >= 0 && (row + 1) < MAX_VERTS && adjMat[row+1][column-2] != marker1  && (option < 7)){//Случай когда мы ходим налоево на две клетки и вверх на одну
                adjMat[row+1][column-2] = marker1;
                return 7;
            } else if((column - 2) >= 0 && (row - 1) >= 0 && adjMat[row-1][column-2] != marker1  && (option < 8)){//Случай когда мы ходим налоево на две клетки и вниз на одну
                adjMat[row-1][column-2] = marker1;
                return 8;
            }
        }
        return  -2;
    }
    // ------------------------------------------------------------
} // Конец класса Graph
////////////////////////////////////////////////////////////////

