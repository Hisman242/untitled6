package ChapterEight.TreeProject8_5;

import javax.swing.tree.TreeNode;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Huffman {


    public void buildHuffmanTree(String[] text){
        HashMap<Character, Integer> map = findTheNumberOfRepetitions(text);
        Node[] nodes;
    }

    public String parsingIntoAString(String[] text){
        String result = "";
        for (int i = 0; i < text.length; i++) {
            result += text[i];
            if(i != text.length){
                result+="\n";
            }
        }
        return result;
    }

    public HashMap<Character, Integer> findTheNumberOfRepetitions(String[] text){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        String string = parsingIntoAString(text);
        for (int i = 0; i < string.length(); i++) {
            if(map.containsKey(string.charAt(i))){
                int value = map.get(string.charAt(i));
                map.put(string.charAt(i), value + 1);
            } else{
                map.put(string.charAt(i),1);
            }
        }
        return map;
    }


}
