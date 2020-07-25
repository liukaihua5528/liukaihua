package cn.tedu.algorithm.bst;

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
