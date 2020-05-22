package cn.tedu.graph;

/**
 * @Author lkh
 */
public class Edge<Weight> {
    private int a,b;
    private Weight weight;
    public Edge(int a,int b,Weight weight){
        this.a=a;
        this.b=b;
        this.weight=weight;
    }
    public Edge(){
        
    }
    public int v(){
        return a;
    }
    public int w(){
        return b;
    }
    public Weight wt(){
        return weight;
    }
    public int other(int x){
        assert (x==a||x==b);
        return x==a?b:a;
    }

}
