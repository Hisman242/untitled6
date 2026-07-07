package RecursiveMergeSort;



import java.time.Duration;
import java.time.Instant;

public class TestOfAllSortingAlgorithms {
    public static void main(String[] args) {
        int maxSizeForTest = 100000;
        DArray dArray = new DArray(maxSizeForTest);
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
        dArray.mergeSort();
        long endTime = System.currentTimeMillis();
        double seconds = (endTime - startTime) / 1000.0;
        System.out.println("Время выполнения: " + seconds + " секунд");
    }
}
