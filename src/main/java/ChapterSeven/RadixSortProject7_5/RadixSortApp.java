package ChapterSeven.RadixSortProject7_5;


public class RadixSortApp {
    public static void main(String[] args){
        int maxSize = 16; // Размер массива
        RadixSort radixSort = new RadixSort(maxSize,2);
        for(int j=0; j<maxSize; j++){  // Заполнение случайными числами
            long n = (int)(Math.random()*199);
            radixSort.insert(n);
        }
        System.out.println("Displaying arr");
        radixSort.display();
        System.out.println("Show in the numerical system");
        radixSort.displayInNumeralSystem();
        radixSort.radixSort();
        System.out.println("After radix sort");
        radixSort.display();
        System.out.println("Show in the numerical system");
        radixSort.displayInNumeralSystem();
    }
}
