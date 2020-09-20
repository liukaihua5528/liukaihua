package cn.tedu.algorithm.avl;

import cn.tedu.algorithm.map.Map;

/**
 * @Date 2020/9/5 23:52
 * @Created by liukaihua
 */
public class AVLMap<K extends Comparable<K>,V> implements Map<K,V> {

    private AVLTree<K,V> avl;

    public AVLMap() {
        avl = new AVLTree<>();
    }

    @Override
    public void add(K key, V value) {
        avl.add(key,value);
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
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
