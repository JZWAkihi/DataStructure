package com;

class ArrayStackString {

    //存储数组
    private String[] arr;

    //数组最大的容量
    private int maxSize;

    //表示栈顶指针
    private int pop;

    //初始化栈
    public ArrayStackString(int num){
        maxSize = num;
        pop = -1;
        arr = new String[maxSize];
    }

    //判满
    public boolean isFull(){
        return pop == maxSize - 1;
    }
    //判空
    public boolean isEmpty(){
        return pop == -1;
    }

    //入栈操作
    public void push(String n){
        if(isFull()){ //先要判满，避免堆栈上溢
            throw new IllegalStateException("栈已满，无法存入数据");
        }
        arr[++pop] = n;
    }

    //出栈操纵
    public String pop(){
        if(isEmpty()){ //判空，避免堆栈下溢
            throw new IllegalStateException("栈空，无法取出数据");
        }

        String result = arr[pop--];
        return result;
    }
    //栈中数据个数
    public int Size(){
        return pop - (-1);
    }
    //得到栈顶元素
    public String pick(){
        return arr[pop];
    }
    //打印栈
    public void ShowStack(){
        if(isEmpty()){
            System.out.println("栈空");
        }

        for (int i = 0; i <= pop ; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();

    }
}

public class MyStack {
    public static void main(String[] args) {

        ArrayStackString arrayStackString = new ArrayStackString(10);

        arrayStackString.push("a");
        arrayStackString.push("b");
        arrayStackString.push("c");
        arrayStackString.push("d");

        arrayStackString.ShowStack();

        arrayStackString.pop();
        System.out.println(arrayStackString.Size());
        System.out.println(arrayStackString.pick());

        arrayStackString.ShowStack();
    }

}
