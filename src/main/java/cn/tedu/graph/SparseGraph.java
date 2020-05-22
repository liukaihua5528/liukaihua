package cn.tedu.graph;

import java.util.ArrayList;

/**
 * 稀疏图
 * @Author lkh
 */
public class SparseGraph {
    private int n,m;
    private boolean directed;
    private ArrayList<ArrayList<Integer>> g;
    public SparseGraph(int n,boolean directed){
        this.n=n;
        this.m=0;
        this.directed=directed;
        for (int i=0;i<n;i++){
            ArrayList<Integer> arr=new ArrayList<>();
            for (int j=0;j<n;j++){
                arr.add(null);
            }
        }
    }
    public int V(){
        return n;
    }
    public int E(){
        return m;
    }
    public void addEdge(int v,int w){
        assert (v>=0&&v<n);
        assert (w>=0&&w<n);
        ArrayList<Integer> arr=g.get(v);
        arr.add(w);
        if (v!=w&&!directed) {
            ArrayList<Integer> arr1=g.get(w);
            arr1.add(v);
        }
        m++;
    }
    public  boolean hasEdge(int v,int w){
        assert (v>=0&&v<n);
        assert (w>=0&&w<n);
        for (int i=0;i<g.get(v).size();i++){
            ArrayList<Integer> arr=g.get(v);
            if (arr.get(w)==w) {
                return true;
            }
        }
        return false;
    }
    class adjIterator{
        private SparseGraph G;
        private int v;
        private int index;
        public adjIterator(SparseGraph graph,int v){
            this.v=v;
            this.index=0;
        }
        public int begin(){
            index=0;
            if (G.g.get(v).size() == 0) {
                return G.g.get(v).get(index);
            }
            return -1;
        }
        public int next(){
            index++;
            if (index < G.g.get(v).size()) {
                return G.g.get(v).get(index);
            }
            return -1;
        }
        public boolean end(){
            return index>=G.g.get(v).size();
        }
    }

}
