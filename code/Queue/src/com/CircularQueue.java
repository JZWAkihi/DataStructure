package com;

class ArrayCircularQueue{

    //表示数组的最大容量
    private int maxSize;

    //队列头  此处的front指向队列的第一个数据
    private int front;

    //队列尾   此处的rear最后一个数据的下一个数据
    private int rear;

    //该数据用于存放数据，模拟队列
    private int[] arr;

    //初始化队列
    public ArrayCircularQueue(int Size){
        maxSize = Size;

        front = 0;
        rear = 0;

        arr  = new int[maxSize];
    }

    //判空
    public boolean isEmpty(){
        return rear == front;
    }

    //判满
    public boolean isFull(){
        return front == (rear + 1) % maxSize;
    }

    //添加数据
    public boolean AddQueue(int n){
        if (isFull()){
            System.out.println("队列已满");
        }

        arr[rear] = n;
        rear = (rear + 1) % maxSize;

        return true;

    }

    //出队列，返回队头数据
    public int GetQueue(){
        if(isEmpty()){
            System.out.println("队列为空，无法返回数据");
            throw new RuntimeException("队列空，不能取数据");
        }

        int value = arr[front];
        front = (front + 1) % maxSize;

        return value;
    }

    //遍历队列
    public void ShowQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }

        int i = front;

        while(i != rear)
        {
            System.out.print(arr[i] + "\t");

            i = (i + 1) % maxSize;
        }
        System.out.println();
    }

    //得到队列的有效数据个数
    public int Size(){
        return (rear - front + maxSize) % maxSize;
    }

    //得到队列的队首数据
    public int getHandQueue(){
        if (isEmpty()){
            System.out.println("队列为空，无法返回数据");
            throw new RuntimeException("队列空，不能取数据");
        }

        return arr[front];
    }

}


public class CircularQueue {

    public static void main(String[] args) {
        ArrayCircularQueue arrayCircularQueue = new ArrayCircularQueue(3);

        arrayCircularQueue.AddQueue(1);
        arrayCircularQueue.AddQueue(2);

        arrayCircularQueue.GetQueue();
        arrayCircularQueue.GetQueue();

        System.out.println(arrayCircularQueue.isFull());   //false
    }


}
