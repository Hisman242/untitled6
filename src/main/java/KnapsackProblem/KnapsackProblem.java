package KnapsackProblem;

public class KnapsackProblem {
    //Массив с весом предметов
    private int[] arr;
    //При создании объекта мы передаём массив с весами предметов.
    public KnapsackProblem(int[] arr) {
        this.arr = arr;
    }

    public boolean  knapsack(int targetWeight, int indexArr) {
//int indexArr - это индекс предмета, с которого мы сейчас начинаем смотреть массив.
//int targetWeight- это сколько ещё нужно добрать до нужного веса.

        //Базовое условие выхода, если целевой вес равен нулю, тогда мы уже нашли числа, которые пойдут в рюкзак
        if(targetWeight==0){
            System.out.print("Sum(by way of recursion): ");
            return true;
        } if(indexArr == arr.length){
            //Если мы дошли до конца массива, но нужный вес не набрали, тогда возвращаем фолс
            //Это не означает, что решений нет впринципе, но конкретно в этой ветке их нет.
            return false;
        }

        //Есть ли возможность взять предмет?
        if((targetWeight - arr[indexArr]) >= 0){
            //Попробуем взять текущий предмет.(Ветка)
            if(knapsack(targetWeight - arr[indexArr], indexArr + 1)){
                //Если рекурсивный вызов вернул true, значит текущий предмет действительно входит в найденную комбинацию.
                //Всё печатается в возврате рекурсии, поэтому вывод наоборот.(Можно дописать красиво)
                System.out.print(arr[indexArr] + " ");
                //вся дальнейшая рекурсия после взятия этого предмета нашла подходящую сумму.
                return true;

            } else{
                //попробовали взять текущий предмет,но путь с ним не дал решения,тогда попробуем его не брать.
                //поскольку мы его не берем, таргет вейт не меняется, но индекс увеличивается потому что мы пропускаем данный эллемент.
                return knapsack(targetWeight, indexArr + 1) ;
            }
        } else {
            //Предмет слишком большой и не поместиился  в изначальное условиие(Переходим к следующему)
            return knapsack(targetWeight, indexArr + 1) ;
        }

    }
    public static void main(String[] args) {
        KnapsackProblem knapsackProblem =  new KnapsackProblem(new int[]{11,8,7,6,5});
        System.out.println(knapsackProblem.knapsack(20,0));

    }
}
