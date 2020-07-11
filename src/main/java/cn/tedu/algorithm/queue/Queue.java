package cn.tedu.algorithm.queue;

/**
 * @Date 2020/7/12 0:01
 * @Created by liukaihua
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();

}
