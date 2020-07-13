package cn.tedu.algorithm.list;

/**
 * @Date 2020/7/12 18:23
 * @Created by liukaihua
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    //获取链表元素个数
    public int getSize(){
        return size;
    }

    //是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E e){
        Node node = new Node(e);
        node.next = head;
        head = node;
        size++;
    }

    public void add(int index,E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed");
        }
        if (index == 0) {
            addFirst(e);
        }else {
            Node prev = head;
            for (int i=0;i<index-1;i++){
                prev = prev.next;
            }
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;
            size++;
        }
    }

    public void addLast(E e){
        add(size,e);
    }

}
