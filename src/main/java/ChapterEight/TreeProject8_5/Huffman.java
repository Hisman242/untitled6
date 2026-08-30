package ChapterEight.TreeProject8_5;
import java.util.HashMap;
import java.util.Map;

public class Huffman {

    Map<Character, String> resultMap = new HashMap<>();// Тут храняться готовые коды (символ->строка) - это кодовая таблица.
    public void buildHuffmanTree(String[] text, int count){//Главный метод, который связывает все этапы
        HashMap<Character, Integer> map = findTheNumberOfRepetitions(text,count);//Вызываем метод подсчёта частот
        Node[] nodes = new Node[map.keySet().size()];//Создаём массив узлов(длина массива = длине уникальных символов)
        int index = 0;//Индекс для заполнения массива
        for(Map.Entry<Character, Integer> entry : map.entrySet()){//Проход по частотной таблице
            if(index != nodes.length){//Проверяем не дошли ли мы до конца массива
                Node node = new Node();//Создаем новый узел
                node.cData = entry.getKey();//Записываем в узел символ
                node.frequency = entry.getValue();//Записываем в узел частоту
                nodes[index++] = node;//Добавляем узел в массив
            }
        }

        Tree[]  trees = new Tree[nodes.length];//Создаем массив деревьев
        PriorityQ priorityQ = new PriorityQ(trees.length);//Создаем приоритетную очередь под массив деревьев
        for (int i = 0; i < nodes.length; i++) {//Проходим по всем узлам и оборачиваем их в деревья, после чего записываем их в массив
            Tree tempTree = new  Tree();
            tempTree.root = nodes[i];
            trees[i] = tempTree;
        }

        for (int i = 0; i < trees.length; i++) {//Все одноузловые деревья помещаются в приоретеную очередь
            priorityQ.insert(trees[i]);
        }

        int countOfActiveTree  = priorityQ.size();//Текущее кол-во живых деревьев
        while(countOfActiveTree > 1){//Пока деревьев больше чем один, продолжаем построение
            Tree treeOne = priorityQ.remove();//Извлекаем два дерева с минимальными частотами
            Tree treeTwo = priorityQ.remove();
            int frequency = treeOne.root.frequency + treeTwo.root.frequency; //Складываются частоты корней
            Tree resultTree = new Tree();//Создаем объединенное дерево
            Node resultNode = new Node();//Создаем новый узел
            resultNode.frequency = frequency;//Записываем в него сумму частот, cData не назначаем, так как она равна нулю('\n0')
            resultTree.root = resultNode;//Узел становится корнем объединенного дерева
            resultTree.root.leftChild = treeOne.root;//Корни двух извлеченных деревьев становятся правым и левым потомком
            resultTree.root.rightChild = treeTwo.root;
            priorityQ.insert(resultTree);//Обратно возвращаем в приорететную очередь
            countOfActiveTree = priorityQ.size();//Обнавляем кол-во деревьев
        }

        Tree resultTree = new Tree();//Получение итогового дерева
        if(priorityQ.size()>0){//Проверяем существует ли вообще итоговое дерево? Если очередь пуста -> пользователь ввел пустое сообщение
            resultTree.root = priorityQ.remove().root;//Последнее дерево извлекается из нашей очереди
            String path = "";//В начале путь пуст( Мы  находимся в корне)
            codeSearch(resultTree.root, path);//Запускается рекурсивный обход дерева
            if(map.size() <= 8){//Ограничение вывода дерева(Проверяем уникальные символы(в мапе хранятся уникальные значение( в последствии листы))
                System.out.println("Displaying the tree");
                resultTree.displayTree();//Выводим дерево
                System.out.println("The tree has been displayed");
            } else{ //Не выводим, дерево слишком большое
                System.out.println("The tree cannot be displayed due to its large size.");
            }

            System.out.println("Displaying the code table"); //Выводим кодовую таблицу
            System.out.println(resultMap.toString());
            System.out.println("Encoding the message");
            String encode = messageEncoding(text,count, resultMap);//Кодируем
            System.out.println(encode);
            System.out.println("Decoding the message(map)");
            System.out.println(messageDecoder(encode, resultMap));//Декодирование по мапе
            System.out.println("Decoding the message(tree)");
            System.out.println(treeBasedMessageDecoder(resultTree, encode));//Декодирование по дереву
        } else{ //Вы ввели пустое значение, делать нечего.
            System.out.println("You entered an empty message.");
        }

    }

    public String messageEncoding(String[] text, int count, Map<Character, String> resultMap){ //Метод кодирования
        String encodingString = parsingIntoAString(text,count); //Массив строк снова превращается в одно сообщение
        String resultString = ""; //Создаем пустую строку для двоичного результата
        for (int i = 0; i < encodingString.length(); i++) { // Программа проходит по каждому символу сообщения
            if(resultMap.containsKey(encodingString.charAt(i))){//Если есть код для текущего символа
                resultString += resultMap.get(encodingString.charAt(i)); //Дописываем в нашу строчку код текущего символа
            }
        }
        return resultString;//Закодированная строка возвращается
    }

    public String messageDecoder(String text, Map<Character, String> resultMap){//Декодирование(Мапа)
        String resultString = "";//Собираем восстановленное сообщение
        String temp = "";//Временно накапливаем биты одного символа
        for (int i = 0; i < text.length(); i++) {//Проход по каждому биту
            temp += text.charAt(i);//Текущий бит добавляется во временную строчку
            for(Map.Entry<Character, String> entry : resultMap.entrySet()){//Перебираем все строки кодовой таблицы
                if(entry.getValue().equals(temp)){ //Если результат совпал
                    resultString += entry.getKey();//Символ дописывается в строку результата
                    temp = "";//Временный путь очищается
                    break;//Выходим из цикла перебора мапы
                }
            }
        }
        return resultString;
    }

    public String treeBasedMessageDecoder(Tree tree, String text){//Декодироване(по дереву)
        Node currentNode = tree.root;//Начинаем с корня дерева
        String resultString = "";//Создается строка, которая накапливает в себе текст
        if(tree.root.leftChild == null &&  tree.root.rightChild == null){ //Если у корня нет потомка, всё дерево состоит из одного символа
            for (int i = 0; i < text.length(); i++) { //Добавляем корневой символ столько раз, сколько битов содержит текст
                resultString += tree.root.cData;
            }
            return resultString; //Возвращаем результат
        }
        for (int i = 0; i < text.length(); i++) {//Обычное декодирование
            if(text.charAt(i) == '0'){ //Ноль означает переход влево
                currentNode = currentNode.leftChild;
            } else if(text.charAt(i) == '1'){ //Один означает переход вправо
                currentNode = currentNode.rightChild;
            }if(currentNode.leftChild == null && currentNode.rightChild == null){//Если у узла нет потомков - это лист, который нам нужен
                resultString += currentNode.cData;//Символ добавляем в результат
                currentNode = tree.root;//Возвращаемся в корень после нахождения символа
            }
        }
        return resultString; //Возвращаем нашу строку
    }

    public void codeSearch(Node currentNode, String path){//Этот метод создает кодовую таблицу
        if(currentNode == null){//Если узла нет, прекращаем текущий рекурсивный вызов
            return;
        } else if (path.equals("") && currentNode.leftChild == null && currentNode.rightChild == null ) {//Если мы в корне и нет правого и левого потомка, -
            path = "0";//- в сообщении только один уникальный символ
            resultMap.put(currentNode.cData, path);//Ему назначается код 0 и добавляем в мапу
            return;//Выход
        } else{//Иначе обычный лист
            if(currentNode.leftChild == null && currentNode.rightChild == null) {//Если мы дошли до символа
                resultMap.put(currentNode.cData, path); //Записываем в таблицу символ -> накопленный путь
                return;//Выходим
            }

            codeSearch(currentNode.leftChild, path + 0); //Для левого потомка создается строка с добавленным нулём
            codeSearch(currentNode.rightChild, path + 1);//Для правого потомка создается отдельная строка с единицей
        }
    }


    public String parsingIntoAString(String[] text, int count){//Парсинг массива в строчку
        String result = "";//Итоговая строка
        for (int i = 0; i < count; i++) {//Обрабатываем только реально заполненные эл-ты массива
            result += text[i];//Добавляем текущую строка
            if(i != count - 1){//Перенос добавляется только между строками
                result+="\n";
            }
        }
        return result;//Возвращаем строку
    }

    public HashMap<Character, Integer> findTheNumberOfRepetitions(String[] text,int count){// Метод подсчета частот(символ -> кол-во)
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();//Создается частотная таблица
        String string = parsingIntoAString(text, count); //Получаем полное сообщение в строку
        for (int i = 0; i < string.length(); i++) {//Проходим по каждому символу
            if(map.containsKey(string.charAt(i))){//Проверяем встречался ли символ раньше?
                int value = map.get(string.charAt(i));//Если да - получаем старую частоту
                map.put(string.charAt(i), value + 1);//Увеличиваем частоту на единицу
            } else{ //Если не встречался, добавляем с частотой 1
                map.put(string.charAt(i),1);
            }
        }
        return map;
    }


}
