package cn.tedu.algorithm.array;


/**
 * @Date 2020/6/24 21:34
 * @Created by liukaihua
 */
public class Array<E> {

    private E[] data;
    //有效元素个数
    private int size;

    /**
     * 构造函数
     * @param capacity
     */
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(E e){
//        if (size == data.length) {
//            throw new IllegalArgumentException("addLast failed");
//        }
//        data[size] = e;
//        size++;
        //直接调用方法add
        add(size,e);
    }

    public void addFirst(E e){
        add(0,e);
    }

    //在index位置插入元素e
    public void add(int index,E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("addLast failed");
        }
        if (size == data.length) {
            resize(2*data.length);
        }
        for (int i=size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i=0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed");
        }
        return data[index];
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }

    public void set(int index,E e){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed");
        }
        data[index] = e;
    }

    /**
     * 查询数组是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i=0;i<size;i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 如果没有返回无效索引 -1
     * @param e
     * @return
     */
    public int find(E e){
        for (int i=0;i<size;i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed");
        }
        E ret = data[index];
        for (int i=index+1;i<size;i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null; //loitering object
        if (size == data.length / 4 && data.length/2 !=0) {
            resize(data.length/2);
        }
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 从数组删除元素e
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array:size = %d,capacity = %d\n",size,data.length));
        builder.append("[");
        for (int i=0;i<size;i++){
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
