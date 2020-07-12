package cn.tedu.algorithm.queue;

import java.util.Random;

/**
 * @Date 2020/7/12 17:43
 * @Created by liukaihua
 */
public class QueueTest {

    //测试queue
    private static double testQueue(Queue<Integer> queue,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i=0;i<opCount;i++){
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i=0;i<opCount;i++){
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 1000000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue,opCount);
        System.out.println(time1);
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue,opCount);
        System.out.println(time2);
    }

}
