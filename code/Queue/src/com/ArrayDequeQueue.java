package com;

import java.util.ArrayDeque;

class MyDeque {
    //存储数组
    private int[] arr;

    //
    private int front;

    //
    private int tail;

    public MyDeque(int num) {
//        front = 1;
//        tail = 1;
        arr = new int[num];
    }

    public void addFirst(int n) {
        front = (front - 1 + arr.length) % arr.length;
        arr[front] = n;

        if(front == tail){
            doubleCapacity();
        }

    }

    public void addLast(int n) {
        arr[tail] = n;
        tail = (tail + 1) % arr.length;

        if(front == tail){
            doubleCapacity();
        }
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("队列是空的，无法移除");
        }

        int result = arr[front];

        arr[front] = 0;

        front = (front + 1) % arr.length;

        return result;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("队列是空的，无法移除");
        }

        tail = (tail - 1 + arr.length) % arr.length;

        int result = arr[tail];

        arr[tail] = 0;

        return result;


    }

    public int peekFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("队列是空的，无法移除");
        }


        return arr[(tail - 1 + arr.length) % arr.length];
    }

    public int Size() {
        return (tail - front + arr.length) % arr.length;
    }

    public boolean isEmpty() {
        return front == tail;
    }


    private void doubleCapacity() {
         int p = front;
         int n = arr.length;//数组的长度
         int r = n - p;
         int[] a = new int[n << 1];//扩大一倍
         System.arraycopy(arr, p, a, 0, r);//先copy后面的r个
         System.arraycopy(arr, 0, a, r, p);//再copy前面的p个
         arr = a;
         front = 0;
         tail = n;

    }

}


public class ArrayDequeQueue {

    public static void main(String[] args) {
        MyDeque myDeque = new MyDeque(5);

        myDeque.addFirst(1);

        System.out.println(myDeque.isEmpty());
    }

}
