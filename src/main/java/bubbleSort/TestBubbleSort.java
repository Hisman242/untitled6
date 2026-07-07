package bubbleSort;


public class TestBubbleSort {
    public static void main(String[] args) {
        int maxSizeForTest = 100000;
        ArrayBub dArray = new ArrayBub(maxSizeForTest);
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
        dArray.bubbleSort();
        long endTime = System.currentTimeMillis();
        double seconds = (endTime - startTime) / 1000.0;
        System.out.println("Время выполнения: " + seconds + " секунд");
    }
}
