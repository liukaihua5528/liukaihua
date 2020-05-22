package cn.tedu.unionfind;

/**
 * @Author lkh
 */
public class UnionFindFour {
    private int[] parent;
    private int[] rank;//rank[i]表示以i为根的集合中层数个数
    private int count;
    public UnionFindFour(int count){
        parent=new int[count];
        rank=new int[count];
        this.count=count;
        for (int i=0;i<count;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    public int find(int p){
        assert (p>=0&&p<count);
        //while (p!=parent[p]){
        //    parent[p]=parent[parent[p]];
        //    p=parent[p];
        //}
        //return p;
        if (p!=parent[p]){
            parent[p]=find(parent[p]);
        }
        return parent[p];
    }
    public boolean isConnected(int p,int q){
        return find(p)==find(q);
    }
    public void unionElements(int p,int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (rank[pRoot]<rank[qRoot]){
            parent[pRoot]=qRoot;
        }else if (rank[qRoot]<rank[pRoot]){
            parent[qRoot]=pRoot;
        }else {// ==
            parent[pRoot]=qRoot;
            rank[qRoot]+=1;
        }
        
    }

}
