package com;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 十进制转换为其他进制
 */

public class NumberBaseConversion {
    /**
     * 十进制转换成二进制
     * @param num  十进制数字
     * @return  二进制字符串
     */
    public static String Binary(int num){

        if(num<0){
            throw new RuntimeException("数字必须为正整数");
        }

        //定义栈
        Stack<Integer> arrayStack = new Stack<Integer>();

        //开始循环
        while( num != 0){
            //将余数进栈
            arrayStack.push(num % 2);
            num = num / 2;
        }

        //定义字符序列可变的字符串
        StringBuilder stringBuilder = new StringBuilder();

        while(arrayStack.size() != 0){
            //出栈
            stringBuilder.append(arrayStack.pop());
        }

        return stringBuilder.toString();

    }


    /**
     * 十进制转十六进制
     * @param num  十进制数字
     * @return   十六进制字符串
     */
    public static String Hexadecimal(int num){
        if(num<0){
            throw new RuntimeException("数字必须为正整数");
        }

        Stack<String> stack = new Stack<>();

        while(num != 0){

            switch (num % 16){
                case 10: stack.push("a");
                    break;
                case 11: stack.push("b");
                    break;
                case 12: stack.push("c");
                    break;
                case 13: stack.push("d");
                    break;
                case 14: stack.push("e");
                    break;
                case 15: stack.push("f");
                    break;
                    //如果余数是 0 - 9 ，将数字转换成字符串，压入栈
                default:stack.push(Integer.toString(num % 16));
                    break;
            }

            num /= 16;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(stack.size() != 0){
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(Binary(42));
        System.out.println(Hexadecimal(30));
        System.out.println(Binary(-1));
    }
}
