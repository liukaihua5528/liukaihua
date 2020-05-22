package cn.tedu.search;

import java.util.Queue;

/**
 * @Author lkh
 */
public class BST<K extends Comparable<K>,V> {
    private class Node{
        K key;
        V value;
        Node left;
        Node right;
        public Node(K key,V value){
            this.key=key;
            this.value=value;
            this.left=this.right=null;
        }
        public Node(Node node){
            this.key=node.key;
            this.value=node.value;
            this.left=node.left;
            this.right=node.right;
        }
    }
    private Node root;
    private int count;
    public BST(){
        root=null;
        count=0;
    }
    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return count==0;
    }
    public void insert(K key,V value){
        root=insert(root,key,value);
    }

    private Node insert(Node node, K key, V value) {
        if (node == null) {
            count++;
            return new Node(key,value);
        }
        if (key == node.key) {
            node.value=value;
        } else if (key.compareTo(node.key)<0) {
            node.left=insert(node.left,key,value);
        }else {
            node.right=insert(node.right,key,value);
        }
        return node;
    }
    public boolean contains(K key){
        return contains(root,key);
    }

    private boolean contains(Node node, K key) {
        if (node == null) {
            return false;
        }
        if (node.key == key) {
            return true;
        }
        if (key.compareTo(node.key)<0) {
            return contains(node.left,key);
        }else {
            return contains(node.right,key);
        }
    }
    public V search(K key){
        return search(root,key);
    }

    private V search(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (node.key == key) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left,key);
        }else {
            return search(node.right,key);
        }
    }
    //前序遍历
    public void preOrder(){
        preOrder(root);
    }
    //中序遍历
    public void inOrder(){
        inOrder(root);
    }
    //后序遍历
    public void postOrder(){
        postOrder(root);
    }
    //层序遍历
    public void levelOrder(){
        Queue<Node> q = null;
        q.add(root);
        while (!q.isEmpty()) {
            Node node=q.peek();
            q.poll();
            System.out.println(node.key);
            if (node.left == null) {
                q.add(node.left);
            }
            if (node.right == null) {
                q.add(node.right);
            }
        }
    }

    /**
     * 寻找最小值
     */
    public K minimum(){
        assert (count!=0);
        Node minNode=minimum(root);
        return minNode.key;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }
    /**
     * 寻找最大值
     */
    public K maximum(){
        assert (count!=0);
        Node maxNode=maximum(root);
        return maxNode.key;
    }

    /**
     * 删除最小值
     */
    public void removeMin(){
        if (root!=null) {
            root=removeMin(root);
        }
    }
    /**
     * 删除最大值
     */
    public void removeMax(){
        if (root!=null) {
            root=removeMax(root);
        }
    }

    /**
     * 删除key的节点
     * @param key
     */
    public void remove(K key){
        root=remove(root,key);
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left=remove(node.left,key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right=remove(node.right,key);
            return node;
        }else {
            if (node.left == null) {
                Node rightNode=node.right;
                count--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode=node.left;
                count--;
                return leftNode;
            }
            Node successor=new Node(minimum(node.right));
            count++;
            successor.right=removeMin(node.right);
            successor.left=node.left;
            count--;
            return successor;
        }
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode=node.left;
            count--;
            return leftNode;
        }
        node.right=removeMax(node.right);
        return node;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode=node.right;
            count--;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

}