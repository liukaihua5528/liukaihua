package cn.tedu.algorithm.list;

import cn.tedu.algorithm.stack.ArrayStack;
import cn.tedu.algorithm.stack.Stack;
import org.junit.Test;

import java.util.Random;

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
        list.remove(2);
        System.out.println(list.toString());
        list.removeFirst();
        System.out.println(list.toString());
        list.removeLast();
        System.out.println(list.toString());
    }

    @Test
    public void linkedListStackTest(){
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i=0;i<5;i++){
            stack.push(i);
            System.out.println(stack.toString());
        }
        stack.pop();
        System.out.println(stack.toString());
    }

    @Test
    public void stackTest(){
        int opCount = 10000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack,opCount);
        System.out.println(time1);
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack,opCount);
        System.out.println(time2);
    }

    private static double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i=0;i<opCount;i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i=0;i<opCount;i++){
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

}
