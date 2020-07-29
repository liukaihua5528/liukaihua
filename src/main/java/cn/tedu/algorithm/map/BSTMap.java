package cn.tedu.algorithm.map;

/**
 * @Date 2020/7/28 21:23
 * @Created by liukaihua
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V>{

    private class Node{
        public K key;
        public V value;
        public Node left,right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }

    private Node add(Node node,K key,V value){

        if (node == null) {
            size++;
            return new Node(key,value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left,key,value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right,key,value);
        }
        return node;
    }


    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void set(K key, V value) {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
