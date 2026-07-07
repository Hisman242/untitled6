package insertSort;



public class TestInsertSort {
    public static void main(String[] args) {
        int maxSizeForTest = 100000;
        ArrayIns dArray = new ArrayIns(maxSizeForTest);
        System.out.println("Max Size: " + maxSizeForTest);
        int count = 0;
        System.out.println("Sort before: " + count);

        for (int i = 0; i < maxSizeForTest; i++) {
            dArray.insert((long) ((Math.random() * 10000) + 1));
            count++;

        }
        System.out.println("Sort after: " + count);

        System.out.println("Start sorting " );
        long startTime = System.currentTimeMillis();
        dArray.insertionSort();
        long endTime = System.currentTimeMillis();
        double seconds = (endTime - startTime) / 1000.0;
        System.out.println("Время выполнения: " + seconds + " секунд");
    }
}
