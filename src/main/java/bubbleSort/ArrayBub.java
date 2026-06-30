package bubbleSort;
class ArrayBub
{
    private long[] a;
    private int nElems;

    public ArrayBub(int max)
    {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value)
    {
        a[nElems] = value;
        nElems++;
    }

    public void display()
    {
        for(int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");

        System.out.println("");
    }

    public void oddEvenSort(){
        for (int i = 0; i < nElems; i++) {
            if(i%2==0){
                for(int j = 0; j < nElems - 1; j = j + 2){
                    if(a[j] > a[j+1]){
                        swap(j,j+1);
                    }
                }
            } else{
                for(int j = 1; j < nElems - 1; j = j+2){
                    if(a[j] > a[j+1]){
                        swap(j,j+1);
                    }
                }
            }

        }
    }


    public void bubbleSort()
    {
        int in;
        int left = 0;
        int right = nElems - 1;
        while(left < right){

            for(in = left; in < right; in++)
            {
                if(a[in] > a[in + 1]) {
                    swap(in, in + 1);
                }

            }
            right--;
            for(in = right; in > left; in--)
            {
                if(a[in] < a[in - 1]) {
                    swap(in, in - 1);
                }

            }
            left++;
        }
//        for(out = nElems - 1; out > 1; out--)
//        {
//            for(in = 0; in < out; in++)
//            {
//                if(a[in] > a[in + 1]) {
//                    swap(in, in + 1);
//                }
//            }
//        }
    }

    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }



}
