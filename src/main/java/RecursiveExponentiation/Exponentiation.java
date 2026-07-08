package RecursiveExponentiation;

public class Exponentiation {
    //Значениия передаются по формуле x * x, y/2
    public int  power(int x, int y){
        //Если х равен 0 и y равен 0, то результат всегда равен 0, потому что это ошибка
        if(y==0 && x == 0){
            System.out.println("Impossible value");
            return 0;
        }
        // Если x равен 0, а степень больше 0, результат равен 0
        if(x==0){
            return 0;
        }
        //По математическому правилу, если y == 0, то результат всегда 1
        if(y == 0){
            return 1;
        }

        //Базовое условие выхода, если значение y(степени) = 1, тогда число не на что умножать, кроме как на само себя(степень не возможно /2), рекурсия пойдет вверх
        if(y == 1){
            return x;
        }

        // Если степень чётная, продолжаем рекурсию по формуле x^y = (x*x)^(y/2)
        if(y % 2 == 0){
            return  power(x * x, y/2);
        } else{
            //Число нечетное, домножаем на х, потому что при делении на 2 остаток уйдет и мы потеряем правильное значение х
            return  power(x * x, y/2) * x;
        }

    }
    public static void main(String[] args) {
        Exponentiation exponentiation = new Exponentiation();
        System.out.println(exponentiation.power(2,8));
        System.out.println(exponentiation.power(3,18));

    }
}
