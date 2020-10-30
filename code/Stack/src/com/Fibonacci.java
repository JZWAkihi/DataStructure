package com;

public class Fibonacci {

    public static int Fib(int n){

        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }

        return Fib(n-1) + Fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(Fib(7));
        System.out.println(Fib(10));
    }

}
