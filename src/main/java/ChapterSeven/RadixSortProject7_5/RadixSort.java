package ChapterSeven.RadixSortProject7_5;
public class RadixSort {
    private int numeralSystem;//Система счисления
    private int numberOfPasses; //Количество проходов
    private long[] arr;//Массив, который мы используем
    private int nItems;//Сколько у нас реально добавлено э-тов
    public RadixSort(int maxSize, int numeralSystem) { //Конструктор принимает вместимость и систему счисления
        arr = new long[maxSize];
        nItems = 0;
        if(numeralSystem >= 2 && numeralSystem <= 36){
            //Если система счисления больше или равна двум и меньше или равна 36 это правильно
            this.numeralSystem = numeralSystem;
            //В противном случае система с основанием меньше 2 или больше 36 - ошибка,ставим минимальную двоичную систему или максимальную 36
        } else if(numeralSystem > 36){
            System.out.println("Your value is higher than the maximum supported, so it has been changed to 36 (the maximum supported numeral system)");
            this.numeralSystem = 36;
        } else if(numeralSystem < 2){
            System.out.println("Your value is less than the minimum supported, so it’s been changed to 2 (the minimum supported numeral system)");
            this.numeralSystem = 2;
        }
    }
    public void insert(long value){//Метод добавления значения в массив
        arr[nItems] = value;
        nItems++;
    }
    public long maximumNumber(){
        //Метод ищет максимальное число и определяет кол-во его цифр
        if(nItems != 0){ //Проверяем не пуст ли массив?
            numberOfPasses = 0; //Обнуляем счёчик
/*
Если не обнулить счётчик, то в переменной numberOfPasses будет сохранено значение
и при повторном запуске, мы будем добавлять в него, что приводит к ошибкам
*/
            long max = 0; //Начальное максимальное значение
            for (int i = 0; i < nItems; i++) { //Поиск максимума
                if(arr[i] > max){
//Если число из массива больше чем максимум, тогда максимумом становится это число
                    max = arr[i];
                }
            }
            //Начинается работа с подсчетом кол-ва символов у максимального числа
            //Далее кол-во символов будет равно проходу по циклу (разряды каждого числа)
            long temp = max;//Сохраняем значение во временную переменную
            //0 - состоит из одного разряда, по-этому увеличиваем счётчик
            if(temp == 0){
                numberOfPasses++;
            }
            //Пока число не равно 0, мы делим на numeralSystem и прибавляем один разряд
            while (temp != 0){
                temp = temp / numeralSystem;
                numberOfPasses++;
            }
            //Возвращаем максимальное число
            return max;
        } else{ // В противном случае массив пуст
            System.out.println("Array is empty");
            return -1;
        }
    }
    public int size(){ //Возвращает кол-во заполненных эл-тов
        return nItems;
    }
    public void display(){//Выводит весь массив
        for (int i = 0; i < nItems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public void radixSort(){
        //Формула для получения конкретной цифры = (число / делитель) % основание
        //Число - temp,  делитель - divider, система счисления - numeralSystem
        if(nItems == 0){ //Проверка пустого массива
            System.out.println("Array is empty");
            return;
        }
        //Определяем кол-во проходов
        maximumNumber();
        // Определяем обрабатываемый разряд
        long divider = 1;
        //Создаем массив из numeralSystem групп
        DoublyLinkedList[] groups = new DoublyLinkedList[numeralSystem];
        for(int i = 0; i < numeralSystem; i++){ //Заполняем массив списками
            groups[i] = new DoublyLinkedList();
        }
        //Одна итерация - проход по разрядам
        for (int i = 0; i < numberOfPasses; i++) {
            //Проходим по всем числам слева -> направо
            for (int j = 0; j < nItems; j++) {
                //Берем текущее число
                long temp = arr[j];
                //Извлекаем нужную цифру( по формуле)
                long digit = (temp  / divider) % numeralSystem;
                //Берётся группа, номер которой совпадает с найденной цифрой.
                DoublyLinkedList doublyLinkedList = groups[(int) digit];
                //Добавляем число в конец группы
                doublyLinkedList.insertLast(temp);
            }
            //Ниже начинается обратный перенос из групп в массив
            int j = 0;//Позиция для записи в массив
            int k = 0;//Номер текущей группы
            while(k < groups.length){ //Группы перебираются строго от 0 до numeralSystem - 1
                //Получаем текущую группу
                DoublyLinkedList doublyLinkedList = groups[k];
                //Пока в группе есть числа - мы их извлекаем
                while (!doublyLinkedList.isEmpty()){
                    //Удаляем первый элемент списка
                    Link link = doublyLinkedList.deleteFirst();
                    arr[j] = link.dData;//Записываем его число обратно в массив
                    j++;//Переходим к следующей позиции массива
                }
                k++;//Переходим к следующей группе
            }
            divider = divider * numeralSystem;//Переход к следующему разряду
        }
    }

    public void displayInNumeralSystem(){
        for (int i = 0; i < nItems; i++) {
            // Выводит значение в системе счисления, заданной в конструкторе
            System.out.print(Long.toString(arr[i], numeralSystem) + " ");
        }
        System.out.println();
    }
}
