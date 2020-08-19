package cn.tedu.algorithm.unionFind;

import java.util.Random;

/**
 * @Date 2020/8/19 22:14
 * @Created by liukaihua
 */
public class UnionTest {

    private static double testUF(UF uf,int m){
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i=0;i<m;i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a,b);
        }
        for (int i=0;i<m;i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a,b);
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int size = 100000;
        int m = 100000;
        UnionFind1 find1 = new UnionFind1(size);
        System.out.println(testUF(find1,m));
        UnionFind2 find2 = new UnionFind2(size);
        System.out.println(testUF(find2,m));
        UnionFind3 find3 = new UnionFind3(size);
        System.out.println(testUF(find3,m));
    }

}
