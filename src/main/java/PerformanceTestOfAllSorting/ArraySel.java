package PerformanceTestOfAllSorting;

class ArraySel {

    private long[] a;
    private int nElems;

    public ArraySel(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void selectionSort() {
        for (int out = 0; out < nElems - 1; out++) {

            int min = out;

            for (int in = out + 1; in < nElems; in++) {
                if (a[in] < a[min]) {
                    min = in;
                }
            }

            swap(out, min);
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}