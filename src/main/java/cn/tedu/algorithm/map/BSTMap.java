package cn.tedu.algorithm.map;

import cn.tedu.search.FileOperation;

import java.util.ArrayList;

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
        }else {
            node.value = value;
        }
        return node;
    }

    private Node getNode(Node node,K key){
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left,key);
        }else {
            return getNode(node.right,key);
        }
    }


    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if (node != null) {
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node root, K key) {
        if (root == null) {
            return null;
        }
        if (key.compareTo(root.key) < 0) {
            root.left = remove(root.left,key);
            return root;
        } else if (key.compareTo(root.key) > 0) {
            root.right = remove(root.right,key);
            return root;
        }else {
            //左子树为空
            if (root.left == null) {
                Node rightNode = root.right;
                root.right = null;
                size--;
                return rightNode;
            }
            //右子树为空
            if (root.right == null) {
                Node leftNode = root.left;
                root.left = null;
                size--;
                return leftNode;
            }
            /**
             * 待删除结点均不为空
             * 找到比待删除结点大的最小结点
             */
            Node successor = minimum(root.right);
            successor.right = removeMin(root.right);
            successor.left = root.left;
            root.left = root.right = null;
            return successor;
        }
    }

    private Node minimum(Node node){
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private Node removeMin(Node node){
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }


    @Override
    public boolean contains(K key) {
        Node node = getNode(root,key);
        return node!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root,key);
        return node==null?null:node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root,key);
        if (node == null) {
            throw new IllegalArgumentException(key+" doesn't exist");
        }
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        System.out.println("pride-and-prejudice.txt");
        ArrayList<String> word1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",word1);
        System.out.println(word1.size());
        BSTMap<String,Integer> map = new BSTMap<>();
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
