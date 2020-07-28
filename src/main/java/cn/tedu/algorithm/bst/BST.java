package cn.tedu.algorithm.bst;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 可比较性
 * @Date 2020/7/23 21:33
 * @Created by liukaihua
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        private Node left;
        private Node right;

        public Node(E e) {
            this.e  = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //添加元素
    public void add(E e){
//        if (root == null) {
//            root = new Node(e);
//            size ++;
//        }else {
//            add(root,e);
//        }
        root = add(root,e);
    }

    private Node add(Node node,E e){
//        if (node.e.equals(e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left,e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right,e);
        }
        return node;
    }

    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    public void inOrder(){
        inOrder(root);
    }

    //中序遍历
    private void inOrder(Node node){
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 前序遍历
     * @param node
     */
    private void preOrder(Node node){
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树非递归前序遍历
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void inOrderNR(){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.e);
            cur = cur.right;
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    //后序遍历
    private void postOrder(Node node){
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //层序遍历
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur  = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    //寻找二分搜索树最小元素
    public E minimum(){
        if (size == 0) {
            throw new IllegalArgumentException("bst is empty");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    //寻找二分搜索树最大元素
    public E maximum(){
        if (size == 0) {
            throw new IllegalArgumentException("bst is empty");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public E removeMin(){
        E ret = minimum();
        removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树最小节点 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
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

    public E removeMax(){
        E ret = maximum();
        removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e){
        root = remove(root,e);
    }

    //删除以node为根的二分搜索树的元素e
    private Node remove(Node root, E e) {
        if (root == null) {
            return null;
        }
        if (e.compareTo(root.e) < 0) {
            root.left = remove(root.left,e);
            return root;
        } else if (e.compareTo(root.e) > 0) {
            root.right = remove(root.right,e);
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


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        generateBSTString(root,0,builder);
        return builder.toString();
    }

    private void generateBSTString(Node root, int depth, StringBuilder builder) {
        if (root == null) {
            builder.append(generateDepthString(depth)+"null\n");
            return;
        }
        builder.append(generateDepthString(depth)+root.e+"\n");
        generateBSTString(root.left,depth+1,builder);
        generateBSTString(root.right,depth+1,builder);
    }

    private String generateDepthString(int depth) {
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<depth;i++){
            builder.append("--");
        }
        return builder.toString();
    }
}
