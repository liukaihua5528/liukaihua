package cn.tedu.algorithm.set;

import java.util.TreeSet;

/**
 * @Date 2020/7/27 23:12
 * @Created by liukaihua
 */
public class UniqueMorse {

    public int uniqueMorseRepresentations(String[] words){
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set = new TreeSet<>();
        for (String word:words){
            StringBuilder builder = new StringBuilder();
            for (int i=0;i>word.length();i++){
                builder.append(codes[word.charAt(i)-'a']);
            }
            set.add(builder.toString());
        }
        return set.size();
    }

}
