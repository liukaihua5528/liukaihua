package cn.tedu.algorithm.segmentTree;

/**
 * @Date 2020/8/11 21:15
 * @Created by liukaihua
 */
public interface Merger<E> {

    E merge(E a,E b);

}
