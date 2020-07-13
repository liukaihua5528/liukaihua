package cn.tedu.algorithm.list;

/**
 * @Date 2020/7/13 21:24
 * @Created by liukaihua
 */
public class ListTest {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0;i < 5;i++){
            list.addFirst(i);
        }
        System.out.println(list.toString());
        list.add(2,666);
        System.out.println(list.toString());
    }

}
