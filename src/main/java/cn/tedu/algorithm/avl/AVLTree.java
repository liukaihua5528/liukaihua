package cn.tedu.algorithm.avl;

import java.util.ArrayList;

/**
 * @Date 2020/8/31 22:17
 * @Created by liukaihua
 */
public class AVLTree<K extends Comparable<K>,V> {

    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //获取平衡因子
    private int getBalanceFactor(Node node){
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(Node node){
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public void add(K key,V value){
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
        //更新height
        node.height  = 1+Math.max(getHeight(node.left),getHeight(node.right));
        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            System.out.println("unbalanced"+balanceFactor);
        }
        //平衡维护
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
             return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    //右旋转
    private Node rightRotate(Node y){
        Node x = y.left;
        Node T3 = x.right;
        x.right = y;
        y.left = T3;
        //更新height
        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;
        return x;
    }

    private Node leftRotate(Node y){
        Node x = y.right;
        Node T2 = x.left;
        x.left = y;
        y.right = T2;
        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;
        return x;
    }

    //判断该二叉树是否是二分搜索树
    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root,keys);
        for (int i=1;i<keys.size();i++){
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if (node == null) {
            return true;
        }
        int balancedFactor = getBalanceFactor(node);
        if (Math.abs(balancedFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private void inOrder(Node node,ArrayList<K> keys){
        if (node == null) {
            return;
        }
        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }
}
