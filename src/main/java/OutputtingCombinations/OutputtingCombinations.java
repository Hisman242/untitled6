package OutputtingCombinations;

public class OutputtingCombinations {
    //Массив, в котором хранятся входные буквы
    private char[] arr;
    //Конструктор принимает массив в аргументах
    public OutputtingCombinations(char[] arr) {
        this.arr = arr;
    }

    public void showTeam(int n, int k, int index, String current){
//        n — сколько человек всего осталось рассмотреть;
//        k — сколько человек ещё нужно выбрать.
//        index — показывает текущую букву
//        current - текущая собранная комбинация

        //Базовый случай, если выбрали нужное колличество людей - выводим
        if (k == 0) {
            System.out.println(current);
            return; //заканчиваем ветку рекурсии
        }
        //Если дальше продолжать бессмысленно - мы выходим с этой ветки
        if((n == 0 && k > 0) || k>n || index == arr.length){
            /*
            (n == 0 && k > 0)  - людей больше не осталось, но надо кого - то выбрать = ошибка
            k>n - нужно выбрать людей больше, чем у нас осталось = ошибка
            index == arr.length - мы вышли за границы массива = ошибка
             */
            return; // выходим из ветки
        }
        /*
        Берем текущую букву, добавляем её в current, уменьшаем колличество нужных букв,
        переходим к следующей букве
         */
        showTeam(n - 1, k - 1, index + 1,current + arr[index]);
        /*
        Не берем текущую букву, не меняем current, не уменьшаем колличество нужных букв,
        переходим к следующей букве
         */
        showTeam(n - 1, k, index+1,current);
    }

    public static void main(String[] args) {
        OutputtingCombinations outputtingCombinations = new OutputtingCombinations(new char[]{'A','B', 'C','D','E'});
        String current = "";
        outputtingCombinations.showTeam(5 ,3, 0, current);

    }
}
