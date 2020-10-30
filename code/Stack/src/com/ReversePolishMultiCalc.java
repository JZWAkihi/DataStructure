package com;


import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

/***
 * 完整的逆波兰计算器
 */
//优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getInvalue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;

            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }



}

public class ReversePolishMultiCalc {

    /**
     * 将中缀表达式转换成中缀List<>
     * 将1 + ((2+3)*4) - 5
     */
    public static List<String> toInfixExpressionList(String s){
        //先定义一个List，存放中缀表达式对于内容

        List<String> Is = new ArrayList<>();
        //索引，用于遍历
        int i = 0;
        //多位数
        String str = "";
        char c;
        do {
            //如果c是一个非数字，需要加入到Is
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                Is.add("" + c);
                i++;
            }else{ //如果是一个数，考虑多位数问题
                str = "";
                while(i<s.length() && (c = s.charAt(i))>=48 && (c = s.charAt(i))<=57){
                    str += c;
                    i++;
                }
                Is.add(str);
            }
        }while(i<s.length());

        return Is;

    }

    /**
     * 将中缀List转换成后缀List
     *
     */
    public static List<String> parseSuffixExpreesionList(List<String> Is){
        ArrayStackString arrayStack = new ArrayStackString(10);

        List<String> s2 = new ArrayList<>();

        //遍历Is
        for (String item : Is){
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                arrayStack.push(item);
            }else if(item.equals(")")){
                while(!arrayStack.pick().equals("(")){
                    s2.add(arrayStack.pop());
                }
                arrayStack.pop();
            }else{
                //当item的优先级小于等于
                while(arrayStack.Size() != 0 && Operation.getInvalue(arrayStack.pick())>=Operation.getInvalue(item)){
                    s2.add(arrayStack.pop());
                }
                //还需要将item压入栈
                arrayStack.push(item);
            }
        }


        while(arrayStack.Size() != 0){
            s2.add(arrayStack.pop());
        }

        return s2;
    }

    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }

        return list;

    }

    public static int calculate(List<String> Is){
        ArrayStackString arrayStackString = new ArrayStackString(10);

        for (String item : Is){
            if(item.matches("//d++")){
                //入栈
                arrayStackString.push(item);
            }else{
                int num2 = Integer.parseInt(arrayStackString.pop());
                int num1 = Integer.parseInt(arrayStackString.pop());
                int res = 0;

                if(item.equals("+")){
                    res = num1 + num2;
                }else if(item.equals("-")){
                    res = num1 - num2;
                }else if(item.equals("*")){
                    res = num1 * num2;
                }else if (item.equals("/")){
                    res = num1 / num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }

                arrayStackString.push(""+res);
            }



        }
        return Integer.parseInt(arrayStackString.pop());
    }


    public static void main(String[] args) {
        List<String> strings = toInfixExpressionList("1+((2+3)*4)-5");

        List<String> list = parseSuffixExpreesionList(strings);

        List<String> listString = getListString(list.toString());

        int calculate = calculate(listString);

        System.out.println(calculate);


    }


}
