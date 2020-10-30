package com;

import java.util.Stack;

public class ParenthesisMatching {

    /**
     *
     * @param par  字符串表达式
     * @return   是否匹配成功
     */
    public static Boolean parenthseis(String par){
        //先将字符串转换成字符数组
        char[] chars = par.toCharArray();

        Boolean flag = true;
        //定义一个字符栈
        Stack<Character> stack = new Stack<>();

        //开始扫描
        for (int i = 0; i < chars.length; i++) {
            //如果栈空且扫描到右括号
            if(stack.isEmpty() && (chars[i] == '}' || chars[i] == ']' || chars[i] == ')')){
                flag = false;
                break;
            }
            //如果扫描到左括号
            if((chars[i] == '{' || chars[i] == '[' || chars[i] == '(')){
                stack.push(chars[i]);
            }
            //如果栈非空，且扫描到右括号
            if(!stack.isEmpty() && (chars[i] == '}' || chars[i] == ']' || chars[i] == ')')){
                //取出栈顶元素，这里可以直接取出，如果不匹配，就直接退出循环了。不用担心数据丢失
                char pop = stack.pop();

                if(pop == '(' && chars[i] != ')' ){
                    flag = false;
                    break;
                }

                if(pop == '[' && chars[i] != ']'){
                    flag = false;
                    break;
                }

                if(pop == '{' && chars[i] != '}'){
                    flag = false;
                    break;
                }
            }
        }

        //如果栈非空，表达式不匹配
        if(stack.size() != 0){
            flag = false;
        }

        return flag;
    }


    public static void main(String[] args) {
        System.out.println(parenthseis("({})"));
        System.out.println(parenthseis("({[})"));
        System.out.println(parenthseis(""));
        System.out.println(parenthseis(")({})"));
    }

}
