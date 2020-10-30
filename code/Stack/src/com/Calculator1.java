package com;


import java.util.Stack;

public class Calculator1 {

    /**
     * 计算
     * @param expression1  字符串表达式
     */
    public static void calc(String expression1){
        char[] expression = expression1.toCharArray();
        //创建两个栈，一个存储数据，另一个存储运算符。
        Stack<Integer> numstack = new Stack<>();
        Stack<Character> operstack = new Stack<>();


        //定义相关变量
        int index = 0;  //用于扫描字符数组的下标
        char ch=' ';    //用于存储扫描结果
        int num1 = 0;   //用于计算
        int num2 = 0;   //用于计算
        char oper;      //符号
        int res = 0;    //计算结果


        //多位数拼接
        StringBuilder nums = new StringBuilder();

        //开始while循环
        while(true){
            //扫描
            ch = expression[index];
            //判断是否是运算符
            if(isOper(ch)){
                //如果是运算符栈非空
                if(!operstack.isEmpty()){
                    //判断当前运算符和栈顶运算符的优先级
                    //如果，栈顶的优先级高，则
                    //      取出数据栈的两个元素，，，注意顺序！！！！！
                    //      取出符号栈的一个元素，，然后计算
                    if(priority(ch) <= priority(operstack.peek())){
                        //注意取出的顺序，涉及到运算
                        num1 = numstack.pop();
                        num2 = numstack.pop();

                        oper = operstack.pop();
                        //一个运算函数，数字和符号传入，注意顺序
                        res = cal(num1,num2,oper);
                        //然后将结构传入数据栈
                        numstack.push(res);
                        //当当前扫描的符号传入符号栈
                        operstack.push(ch);
                    }else{    //如果当前的运算符优先级大于栈顶运算符，当前运算符进栈
                        operstack.push(ch);
                    }
                }else{//如果运算符栈是空，这直接入栈
                    operstack.push(ch);
                }
            }
            //如果扫描到数字
            else{
                //将ch拼接到nums中
                nums.append(ch);
                //如果当前数字是最后一个，直接进栈
                if(index == expression.length - 1){
                    numstack.push(Integer.parseInt(nums.toString()));
                }else {
                    //如果数字不是最后一个
                    //且下一个扫描到的是运算符
                    if(isOper(expression[index+1])){
                        //直接进栈
                        numstack.push(Integer.parseInt(nums.toString()));
                        //将nums清空！！
                        nums.delete(0,nums.length());
                    }
                    //如果扫描到的下一个是数字，则在下一次循环中拼接到nums中，直到出现运算符
                }

            }

            index++;
            if(index >= expression.length){
                break;
            }
        }

        //结束扫描后，如果符号栈为空，那么还需要运算，此时，符号栈中的符号不区分优先级了。
        while (true){
            if(operstack.isEmpty()){
                break;
            }
            //数据栈弹出两个元素
            num1 = numstack.pop();
            num2 = numstack.pop();
            //符号栈弹出元素
            oper = operstack.pop();
            //计算
            res = cal(num1,num2,oper);
            //将结果压入数据栈
            numstack.push(res);
        }


        System.out.println(numstack.pop());
    }

    /**
     * 判断是否是运算符
     * @param val  扫描的字符
     * @return  是否是运算符
     */
    public static boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算
     * @param num1  数据1
     * @param num2  数据2
     * @param oper  符号
     * @return   返回计算结果
     */
    public static int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;

            default:
                break;
        }

        return res;
    }

    /**
     * 得到运算符优先级
     * @param oper  字符
     * @return 返回运算符优先级
     */
    public static int priority(char oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }
        else if(oper == '+' || oper == '-'){
            return 0;
        }
        else {
            return 0;
        }
    }


    public static void main(String[] args) {
        calc("4*5+18/3");  //26
        calc("4+6*9-20");  //38
    }

}
