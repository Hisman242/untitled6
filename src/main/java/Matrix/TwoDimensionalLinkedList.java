package Matrix;


public class TwoDimensionalLinkedList {
    private int width; //ширина
    private int height; //высота
    private Link first;
    public  TwoDimensionalLinkedList(int width, int height) {
        Link previousRowStart = null;
        this.width = width;
        this.height = height;
        for (int i = 0; i < height; i++) {
            Link highValue = previousRowStart;
            Link widthTemp = null;
            Link currentRowStart = null;
            for (int j = 0; j < width; j++) {
                Link current = new  Link(0);

                if(first == null){
                    first = current;
                    widthTemp = current;
                    highValue = null;
                    previousRowStart = first;
                } else{
                    if(widthTemp == null){
                        widthTemp = current;
                    } else{
                        widthTemp.next = current;
                        widthTemp = current;
                        if(highValue != null){
                            highValue.down = widthTemp;
                            highValue = highValue.next;
                        }
                    }

                }
                previousRowStart = currentRowStart;


            }
        }
    }

    public void insert(long data, int widthData, int heightData) {
        if(widthData >= 0 && widthData <= this.width && heightData >= 0 && heightData <= this.height){
            Link newLink = new Link(data);
            if(first == null && widthData == 0 && heightData == 0){
                first = newLink;
            } else{
                for (int i = 0; i < heightData; i++) {

                }
            }
        } else{
            System.out.println("Вы указали неправильные координаты");
        }

    }
    public void display() {

    }

}
