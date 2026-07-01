package circularList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
5.5. Задача Иосифа Флавия — известная математическая задача с историческим подтекстом.Существует много легенд о том, как она возникла.
В одной из них говорится, что Иосиф был в составе гарнизона осажденной крепости, которую должны были захватить римляне.
Защитники крепости предпочли смерть рабству.Они выстроились в круг, и начинали считать по кругу, выбрав в качестве начала отсчета
конкретного человека. Каждый n-й по счету покидал круг и совершал самоубийство. Иосиф решил, что ему умирать еще рано,
и выбрал такие правила, чтобы остаться последним из выживших.Если в круге было (например) 20 человек и он был седьмым от начала отсчета,
какое число следовало выбрать для отсчета? Задача сильно усложняется тем, что круг уменьшается по мере выбывания участников.
Создайте приложение, моделирующее задачу с использованием циклического связанного списка (как в проекте 5.3). Во входных параметрах
передаются количество людей в круге, число для отсчета и номер человека, с которого начинается отсчет (чаще всего 1).
Программа выводит список выбывающих.Когда один из участников выходит из круга, отсчет начинается заново слева от него
(предполагается, что отсчет ведется по часовой стрелке).Например, если в круге стоят семеро участников с номерами от 1 до 7,
а отсчет ведется через 3 позиции (начиная с позиции 1), то участники выбывают в порядке 4, 1, 6, 5, 7, 3. Номер 2 остается последним.
 */
public class JosephusProblem {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        CircularList circularList = new CircularList();

        System.out.println("Введите число людей:");
        int countOfPerson = Integer.parseInt(bufferedReader.readLine());

        System.out.println("Введите позицию начального человка:");
        int startPersonId = Integer.parseInt(bufferedReader.readLine());

        System.out.println("Введите шаг:");
        int step = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < countOfPerson; i++) {
            Person person = new Person(i);
            circularList.insert(person.getId() + 1);
        }
        for (int i = 0; i < startPersonId - 1; i++) {
            circularList.step();
        }
        System.out.println("Вывод после того, как мы передвинули позицию к начальному человку:");
        circularList.display();
        while (countOfPerson > 1){

            System.out.println("Делаем шаги указанные пользователем");
            for (int i = 0; i < step; i++) {
                circularList.step();
            }
            System.out.println(circularList.removeCurrent());
            System.out.println("Удалили человека");
            countOfPerson--;
            circularList.display();

        }
        System.out.println("Победил " + circularList.peek());
    }
}
