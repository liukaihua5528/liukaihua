package cn.tedu.algorithm.set;

import cn.tedu.search.FileOperation;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Date 2020/7/27 21:34
 * @Created by liukaihua
 */
public class SetTest {

    public static void main(String[] args) {
        System.out.println("pride-and-prejudice.txt");
        ArrayList<String> word1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",word1);
        System.out.println(word1.size());
        LinkedListSet<String> set1 = new LinkedListSet<>();
        for (String word:word1){
            set1.add(word);
        }
        System.out.println(set1.getSize());

        System.out.println("a-tale-of-two-cities.txt");
        ArrayList<String> word2 = new ArrayList<>();
        FileOperation.readFile("a-tale-of-two-cities.txt",word2);
        System.out.println(word2.size());
        LinkedListSet<String> set2 = new LinkedListSet<>();
        for (String word:word2){
            set2.add(word);
        }
        System.out.println(set2.getSize());
    }

    private static double testSet(Set<String> set,String filename){
        long startTime = System.nanoTime();
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile(filename,words);
        for (String word:words){
            set.add(word);
        }
        System.out.println(set.getSize());
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    @Test
    public void set(){
        String filename = "pride-and-prejudice.txt";
        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet,filename);
        System.out.println(time1);
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet,filename);
        System.out.println(time2);
    }

}
