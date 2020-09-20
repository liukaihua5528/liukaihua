package cn.tedu.algorithm.hash;

import java.util.TreeMap;

/**
 * @Date 2020/9/16 21:42
 * @Created by liukaihua
 */
public class HashTable<K,V> {

    private TreeMap<K,V>[] hashtable;
    private int M;
    private int size;

    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
    }
}
