package ChapterEight.TreeProject8_5;

import javax.swing.tree.TreeNode;
import java.util.HashMap;

public class Huffman {
    public void buildHuffmanTree(String[] text, int nItems){
        Node[] nodeArr = new Node[nItems];
        int nodeCounter = 0;
        int currentLetter = 0;

        for (int i = 0; i < nItems; i++) {
            text[i] = "";
        }
    }

    public char[] parsingIntoACharArray(String[] text){
        char[] charArray = new char[1024];
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < charArray.length; j++) {

            }
        }
        return null;
    }

    public void findTheNumberOfRepetitions(String[] text){
        Character[] charArray = new Character[text.length];
        for (int i = 0; i < text.length; i++) {

        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < text.length; i++) {
            if(!map.containsKey(text[i])){

            }
        }
    }


}
