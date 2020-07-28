package cn.tedu.algorithm.set;

/**
 * @Date 2020/7/27 20:54
 * @Created by liukaihua
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
