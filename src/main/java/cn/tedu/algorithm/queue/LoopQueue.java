package cn.tedu.algorithm.queue;


/**
 * @Date 2020/7/12 16:39
 * @Created by liukaihua
 */
public class LoopQueue<E> implements Queue<E>{

    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    /**
     * 入队
     */
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity+1];
        for (int i=0;i<size;i++){
            newData[i] = data[(i+front)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity()/2 != 0) {
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot getFront from an empty queue");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue :size = %d,capacity = %d\n",size,getCapacity()));
        builder.append("front [");
        for (int i=front; i!=tail; i=(i+1)%data.length){
            builder.append(data[i]);
            if ((i+1)%data.length!=tail) {
                builder.append(", ");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue.toString());
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue.toString());
            }
        }
    }
}
