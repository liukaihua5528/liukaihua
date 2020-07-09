package cn.tedu.algorithm.stack;

import cn.tedu.algorithm.array.Array;

/**
 * @Date 2020/7/9 20:23
 * @Created by liukaihua
 */
public class ArrayStack<E> implements Stack<E>{

    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 从栈顶添加一个元素
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 从栈顶取出一个值
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查询栈顶的元素
     * @return
     */
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Stack");
        builder.append("[");
        for (int i=0;i<array.getSize();i++){
            builder.append(array.get(i));
            if (i != array.getSize() - 1) {
                builder.append(",");
            }
        }
        builder.append("] top");
        return builder.toString();
    }
}
