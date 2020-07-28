package cn.tedu.algorithm.set;

import cn.tedu.algorithm.list.LinkedList;

/**
 * @Date 2020/7/27 21:45
 * @Created by liukaihua
 */
public class LinkedListSet<E> implements Set<E>{

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.isContains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.isContains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
