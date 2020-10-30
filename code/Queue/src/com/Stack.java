package com;

class StackByQueue{
    //先定义两个循环队列
    ArrayCircularQueue Queue1;
    ArrayCircularQueue Queue2;

    //初始化队列
    public StackByQueue(){
        Queue1 = new ArrayCircularQueue(5);
        Queue2 = new ArrayCircularQueue(5);
    }

    //入栈
    public boolean push(int i){
        if(Queue1.isEmpty() && Queue1.isEmpty()){
            return Queue1.AddQueue(i);
        }

        if(!Queue1.isEmpty()){
            return Queue1.AddQueue(i);
        }else{
            return Queue2.AddQueue(i);
        }
    }

    //出栈
    public Integer pop(){
        if(Queue2.isEmpty() && Queue1.isEmpty()){
            throw new RuntimeException("队列为空");
        }

        if (!Queue1.isEmpty() && Queue2.isEmpty() ){
            while(Queue1.Size() > 1){
                Queue2.AddQueue(Queue1.GetQueue());
            }
            return Queue1.GetQueue();
        }
        if (!Queue2.isEmpty() && Queue1.isEmpty() ){
            while(Queue2.Size() > 1){
                Queue1.AddQueue(Queue2.GetQueue());
            }
            return Queue2.GetQueue();
        }


        return null;
    }

    //遍历栈
    public void ShowStack() {

        if(!Queue1.isEmpty()){
            System.out.print("Queue1:  ");
            Queue1.ShowQueue();
        }else{
            System.out.print("Queue2:  ");
            Queue2.ShowQueue();
        }
    }

    //栈的有效数据个数
    public int Size(){
        return Math.max(Queue1.Size(),Queue2.Size());
    }
}

public class Stack {
    public static void main(String[] args) {
        StackByQueue stackByQueue = new StackByQueue();

        stackByQueue.push(1);
        stackByQueue.push(2);
        stackByQueue.push(3);
        stackByQueue.push(4);


        stackByQueue.ShowStack();

        System.out.println(stackByQueue.pop());

        stackByQueue.ShowStack();

        System.out.println(stackByQueue.pop());

        System.out.println(stackByQueue.Queue1.isEmpty());

        System.out.println(stackByQueue.Queue2.isEmpty());

        stackByQueue.ShowStack();

        System.out.println(stackByQueue.Size());


    }
}
