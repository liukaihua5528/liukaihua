package cn.tedu.algorithm.heap;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Date 2020/8/4 21:32
 * @Created by liukaihua
 */
public class TopKFrequent {

    private class Freq implements Comparable<Freq>{
        int e,freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return 1;
            } else if (this.freq > another.freq) {
                return -1;
            }else {
                return 0;
            }
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
        PriorityQueue<Freq> queue = new PriorityQueue<>();
        for (int key:treeMap.keySet()){
            if (queue.getSize() < k) {
                queue.enqueue(new Freq(key,treeMap.get(key)));
            } else if (treeMap.get(key) > queue.getFront().freq) {
                queue.dequeue();
                queue.enqueue(new Freq(key,treeMap.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            res.add(queue.dequeue().e);
        }
        return res;
    }

}
