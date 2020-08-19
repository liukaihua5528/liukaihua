package cn.tedu.algorithm.unionFind;

/**
 * @Date 2020/8/19 22:45
 * @Created by liukaihua
 */
public class UnionFind4 implements UF{

    private int[] parent;
    //sz[i]表示以i为根的集合中元素个数
    private int[] sz;

    public UnionFind4(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i=0;i<size;i++){
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p){
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        while (p!=parent[p]){
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (sz[pRoot]<sz[qRoot]){
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[qRoot];
        }else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
