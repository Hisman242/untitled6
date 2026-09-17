package ChapterTen.Project10_3;

import java.util.Arrays;

public class SortApp {

    public static void main(String[] args) {
        Tree234 tree = new  Tree234();
        long[] longs = {123,3,588,929,656,93,645,19999,74,288282,852349032,823};
        tree.sort(longs);
        System.out.println(Arrays.toString(longs));

    }
}
