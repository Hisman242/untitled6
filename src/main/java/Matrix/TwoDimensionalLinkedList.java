package Matrix;


public class TwoDimensionalLinkedList {
    private int width; //ширина
    private int height; //высота
    private Link first;
    public TwoDimensionalLinkedList(int width, int height) {
//        first = всегда [0][0], вход во всю матрицу.
//        currentRowStart = первая ячейка строки, которую ты строишь сейчас.
//        previousRowStart = первая ячейка строки сверху.
//        widthTemp = последняя созданная ячейка в текущей строке.
//        highValue = ячейка сверху над current.
        Link previousRowStart = null;
        this.width = width;
        this.height = height;
        for (int i = 0; i < height; i++) {
            Link highValue = previousRowStart;
            Link widthTemp = null;
            Link currentRowStart = null;
            for (int j = 0; j < width; j++) {
                Link current = new  Link(0);
                if(j == 0){
                    currentRowStart = current;
                }
                if(first == null){
                    first = current;
                }
                if(widthTemp != null){
                    widthTemp.next = current;
                }
                if(highValue  != null){
                    highValue.down = current;
                    highValue = highValue.next;
                }
                widthTemp = current;
            }
            previousRowStart = currentRowStart;
        }
    }

    public long insert(long data, int widthData, int heightData) {
        if(widthData >= 0 && widthData < this.width && heightData >= 0 && heightData < this.height){
            Link temp = first;
            for (int j = 0; j < heightData; j++) {
                temp = temp.down;
            }
            for(int i = 0; i < widthData; i++){
                temp =  temp.next;
            }
            temp.dData = data;
            return data;


        } else{
            System.out.println("Вы указали неправильные координаты, выходящие за границы.");
        }
        return 0;
    }
    public void display() {
        Link firstTemp = first;

        while(firstTemp != null){
            Link iterator =  firstTemp;
            while(iterator != null){
                System.out.print(iterator.dData + " ");
                iterator = iterator.next;
            }
            System.out.println();
            firstTemp = firstTemp.down;
        }
    }
}
