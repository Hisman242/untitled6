package ChapterSeven.PartitionProject7_1;

public class PartitionAppTest {
    public static void main(String[] args) {

        ArrayPar arr1 = new ArrayPar(1);
        ArrayPar arr2 = new ArrayPar(2);
        ArrayPar arr3 = new ArrayPar(3);
        ArrayPar arr4 = new ArrayPar(0);

        //Заполняем 1 массив
        arr1.insert(1);
        //Заполняем 2 массив
        arr2.insert(8);
        arr2.insert(3);
        //Заполняем 3 массив
        arr3.insert(1);
        arr3.insert(32);
        arr3.insert(4);
        //Получаем размеры всех массивов
        int size1 = arr1.size();
        int size2 = arr2.size();
        int size3 = arr3.size();
        int size4 = arr4.size();
        int partDex1 = arr1.partitionIt(0, size1 - 1);
        System.out.println("Partition is at index " + partDex1);
        arr1.display(); // Вывод массива после разбиения
        int partDex2 = arr2.partitionIt(0, size2-1);
        System.out.println("Partition is at index " + partDex2);
        arr2.display(); // Вывод массива после разбиения
        int partDex3 = arr3.partitionIt(0, size3-1);
        System.out.println("Partition is at index " + partDex3);
        arr3.display(); // Вывод массива после разбиения
        int partDex4 = arr4.partitionIt(0, size4 - 1);
        System.out.println("Partition is at index " + partDex4);
        arr4.display(); // Вывод массива после разбиения



    }
}
