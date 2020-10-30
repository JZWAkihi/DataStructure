package com;

import java.util.ArrayDeque;

class ArrayQueue{
    //表示数组的最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //该数据用于存放数据，模拟队列
    private int[] arr;

    //队列构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        //创建一个长度为maxSize的数据
        arr = new int[maxSize];

        //指向队列的头部，分析出front时指向队列头的前一个位置
        front = -1;
        //指向队列的尾部，指向队列尾部的数据
        rear = -1;
    }

    //判断队列是否为满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列为空
    public boolean iSEmpty(){
        return front == rear;
    }

    //添加数据到队列中
    public void AddQueue(int n){
        if(!isFull()){
            rear++;
            arr[rear] = n;
        }
        else {
            System.out.println("队列已满，无法添加数据");
        }
    }

    //出队列，并返回数据
    public int GetQueue(){
        if(iSEmpty()){
            System.out.println("队列为空，无法返回数据");
            throw new RuntimeException("队列空，不能取数据");
        }

        front++;
        return arr[front];
    }

    //遍历队列
    public void ShowQueue(){
        if(iSEmpty()){
            System.out.println("队列为空");
            return;
        }

        for (int i = front; i < rear; i++) {
            System.out.print(arr[i + 1] + "\t");
        }

        System.out.println();
    }

    //遍历数组
    public void ShowArr(){
        if(iSEmpty()){
            System.out.println("队列为空");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    //显示头数据
    public int GethandQueue(){
        if(iSEmpty()){
            System.out.println("队列为空，无法返回数据");
            throw new RuntimeException("队列空，不能取数据");
        }

        return arr[front + 1];
    }

}

public class onehandQueue {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);

        arrayQueue.AddQueue(1);
        arrayQueue.AddQueue(2);
        arrayQueue.AddQueue(3);

        arrayQueue.GetQueue();
        arrayQueue.GetQueue();
        arrayQueue.GetQueue();

        System.out.println(arrayQueue.isFull());
    }

}
