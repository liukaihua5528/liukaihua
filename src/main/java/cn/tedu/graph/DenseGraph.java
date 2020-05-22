package cn.tedu.graph;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 稠密图
 * @Author lkh
 */
public class DenseGraph {
    private int n,m;
    private boolean directed;
    private ArrayList<ArrayList<Boolean>> g=new ArrayList<ArrayList<Boolean>>();
    public DenseGraph(int n,boolean directed){
        this.n=n;
        this.m=0;
        this.directed=directed;
        for (int i=0;i<n;i++){
            ArrayList<Boolean> arr=new ArrayList<>();
            for (int j=0;j<n;j++){
                arr.add(j,false);
            }
            g.add(arr);
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
        if (hasEdge(v, w)) {
            return;
        }
        //g[v][w]=true;
        ArrayList<Boolean> arr=g.get(v);
        arr.set(w,true);
        if (!directed) {
            ArrayList<Boolean> arr1=g.get(w);
            arr1.set(v,true);
        }
        m++;
    }
    public boolean hasEdge(int v,int w){
        assert (v>=0&&v<n);
        assert (w>=0&&w<n);
        ArrayList<Boolean> arrayList=g.get(v);
        return arrayList.get(w);
    }
    
    class adjIterator{
        private DenseGraph G;
        private int v;
        private int index;
        public adjIterator(DenseGraph graph,int v){
            this.v=v;
            this.index=-1;
        }
        public int begin(){
            index=-1;
            return next();
        }
        public int next(){
           for (index+=1;index<G.V();index++){
               if (G.g.get(v).get(index)) {
                   return index;
               }
           }
           return -1;
        }
        public boolean end(){
            return index>=G.V();
        }
    }

}
