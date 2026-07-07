package CheapPocketComputer;

public class Computer {
//    int result = 0;
//    public int mult(int x, int y){
//
//        if(y == 0){
//            int temp = result;
//            result = 0;
//            return temp;
//
//        }
//        result = x + result;
//        return mult(x, y - 1);
//    }
    public int mult(int x, int y){
        if(y == 0){
            return 0;
        }
        return x + mult(x, y - 1);
    }
    public static  void main(String[] args){
        Computer computer = new Computer();
        System.out.println(computer.mult(10, 3));
        System.out.println(computer.mult(20, 3));
        System.out.println(computer.mult(100, 3));
    }
}
