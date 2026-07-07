package PerformanceTestOfAllSorting;

class ArrayIns {

    private long[] a;
    private int nElems;

    public ArrayIns(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void insertionSort() {
        for (int out = 1; out < nElems; out++) {

            long temp = a[out];
            int in = out;

            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                in--;
            }

            a[in] = temp;
        }
    }
}