package cn.tedu.algorithm.map;

import cn.tedu.algorithm.set.LinkedListSet;
import cn.tedu.search.FileOperation;

import java.util.ArrayList;

/**
 * @Date 2020/7/28 21:16
 * @Created by liukaihua
 */
public class MapTest {

    public static void main(String[] args) {
        System.out.println("pride-and-prejudice.txt");
        ArrayList<String> word1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",word1);
        System.out.println(word1.size());
        LinkedListMap<String,Integer> map = new LinkedListMap<>();
        for (String word:word1){
            if (map.contains(word)) {
                map.set(word,map.get(word)+1);
            }else {
                map.add(word,1);
            }
        }
        System.out.println(map.getSize());
        System.out.println(map.get("pride"));
    }

}
