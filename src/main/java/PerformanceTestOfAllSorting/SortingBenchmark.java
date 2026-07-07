package PerformanceTestOfAllSorting;

public class SortingBenchmark {
    public static void main(String[] args) {

        int maxSize = 100_000;

        ArrayBub bubbleArray = new ArrayBub(maxSize);
        ArraySel selectionArray = new ArraySel(maxSize);
        ArrayIns insertionArray = new ArrayIns(maxSize);
        DArray mergeArray = new DArray(maxSize);

        // Во все 4 массива вставляются ОДНИ И ТЕ ЖЕ числа
        for (int i = 0; i < maxSize; i++) {
            long number = (long) (Math.random() * 100_000);

            bubbleArray.insert(number);
            selectionArray.insert(number);
            insertionArray.insert(number);
            mergeArray.insert(number);
        }

        System.out.println("Количество чисел: " + maxSize);
        System.out.println();

        // Bubble Sort
        long start = System.currentTimeMillis();

        bubbleArray.bubbleSort();

        long end = System.currentTimeMillis();

        System.out.println("Bubble Sort: " + (end - start) / 1000.0 + " секунд");

        // Selection Sort
        start = System.currentTimeMillis();

        selectionArray.selectionSort();

        end = System.currentTimeMillis();

        System.out.println("Selection Sort: " + (end - start) / 1000.0 + " секунд");

        // Insertion Sort
        start = System.currentTimeMillis();

        insertionArray.insertionSort();

        end = System.currentTimeMillis();

        System.out.println("Insertion Sort: " + (end - start) / 1000.0 + " секунд");

        // Merge Sort
        start = System.currentTimeMillis();

        mergeArray.mergeSort();

        end = System.currentTimeMillis();

        System.out.println("Merge Sort: " + (end - start) / 1000.0 + " секунд");
    }
}
