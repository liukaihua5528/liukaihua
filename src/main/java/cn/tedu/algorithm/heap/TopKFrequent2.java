package cn.tedu.algorithm.heap;

import java.util.*;
import java.util.PriorityQueue;

/**
 * @Date 2020/8/4 21:32
 * @Created by liukaihua
 */
public class TopKFrequent2 {

    private class Freq{
        int e,freq;
        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    private class FreqComparator implements Comparator<Freq>{
        public int compare(Freq a, Freq b) {
            return a.freq-b.freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums,int k){
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int num:nums){
            if (treeMap.containsKey(num)) {
                treeMap.put(num,treeMap.get(num)+1);
            }else {
                treeMap.put(num,1);
            }
        }
        //比较器作为参数
        PriorityQueue<Freq> queue = new PriorityQueue<>(new FreqComparator());
        for (int key:treeMap.keySet()){
            if (queue.size() < k) {
                queue.add(new Freq(key,treeMap.get(key)));
            } else if (treeMap.get(key) > queue.peek().freq) {
                queue.remove();
                queue.add(new Freq(key,treeMap.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            res.add(queue.remove().e);
        }
        return res;
    }

}
