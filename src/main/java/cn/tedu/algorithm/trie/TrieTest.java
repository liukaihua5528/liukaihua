package cn.tedu.algorithm.trie;

import cn.tedu.algorithm.set.BSTSet;
import cn.tedu.search.FileOperation;

import java.util.ArrayList;

/**
 * @Date 2020/8/17 22:08
 * @Created by liukaihua
 */
public class TrieTest {

    public static void main(String[] args) {
        System.out.println("pride-and-prejudice.txt");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            long startTime = System.nanoTime();
            BSTSet<String> set = new BSTSet<>();
            for (String word:words){
                set.add(word);
            }
            for (String word:words){
                set.contains(word);
            }
            long endTime = System.nanoTime();
            double time = (endTime-startTime)/1000000000.0;
            System.out.println(set.getSize());
            System.out.println(time);

            startTime = System.nanoTime();
            Trie trie = new Trie();
            for (String word:words){
                trie.add(word);
            }
            for (String word:words){
                trie.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime-startTime)/1000000000.0;
            System.out.println(trie.getSize());
            System.out.println(time);
        }

    }

}
