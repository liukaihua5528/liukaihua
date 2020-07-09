package cn.tedu.algorithm.stack;

/**
 * @Date 2020/7/8 23:38
 * @Created by liukaihua
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();

}
