package RecursiveTree;

import java.io.DataInput;

public class Tree {
    // Двумерный массив:
    // первый индекс — номер строки дерева;
    // второй индекс — позиция символа в этой строке.
    private char[][] arr;
    public  Tree(int width){
        int tempWidth = width;
        int height = 0;
        while(tempWidth!=1){
            tempWidth = tempWidth/2;
            height++;
        }
        height++;
        arr = new char[height][width];
        for (int i = 0; i<height; i++){
            for (int j = 0; j < width; j++) {
                arr[i][j] = '-';
            }
        }
    }


    public  void makeBranches(int left, int right, int depth) {
        int mid = (left+right)/2;
        arr[depth][mid] = 'X';
        if(left==right){
            return;
        }
        makeBranches(left, mid,depth + 1);
        makeBranches(mid+1, right,depth+1);
    }

    public  void display() {
        // вывести массив символов
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}
