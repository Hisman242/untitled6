package ChapterSeven.RadixSortProject7_5;
public class RadixSort {
    private int numberOfPasses;
    private long[] arr;
    private int nItems;
    public RadixSort(int maxSize) {
        arr = new long[maxSize];
        nItems = 0;
    }
    public void insert(long value){
        arr[nItems] = value;
        nItems++;
    }
    public long maximumNumber(){
        if(nItems != 0){
            numberOfPasses = 0;
            long max = 0;
            for (int i = 0; i < nItems; i++) {
                if(arr[i] > max){
                    max = arr[i];
                }
            }
            long temp = max;
            if(temp == 0){
                numberOfPasses++;
            }
            while (temp != 0){
                temp = temp / 10;
                numberOfPasses++;
            }
            return max;
        } else{
            System.out.println("Array is empty");
            return -1;
        }
    }
    public int size(){
        return nItems;
    }
    public void display(){
        for (int i = 0; i < nItems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public void radixSort(){
        //Формула для получения конкретной цифры = (число / делитель) % 10
        //Число - temp,  делитель - divider
        maximumNumber();

        long divider = 1;
        DoublyLinkedList[] groups = new DoublyLinkedList[10];
        for(int i = 0; i < 10; i++){
            groups[i] = new DoublyLinkedList();
        }
        for (int i = 0; i < numberOfPasses; i++) {
            for (int j = 0; j < nItems; j++) {
                long temp = arr[j];
                long digit = (temp  / divider) % 10;
                DoublyLinkedList doublyLinkedList = groups[(int) digit];
                doublyLinkedList.insertLast(temp);
            }
            int j = 0;
            int k = 0;
            while(k < groups.length){
                DoublyLinkedList doublyLinkedList = groups[k];
                while (!doublyLinkedList.isEmpty()){
                    Link link = doublyLinkedList.deleteFirst();
                    arr[j] = link.dData;
                    j++;
                }
                k++;
            }
            divider = divider * 10;

        }
    }
}
