package cn.tedu.algorithm.unionFind;

/**
 * @Date 2020/8/18 21:51
 * @Created by liukaihua
 */
public interface UF {

    int getSize();

    boolean isConnected(int p,int q);

    void unionElements(int p,int q);

}
