package com;

public class HanoiTest {

    private static int step = 0;

    public static void Move(char m,char n){
        step++;
        System.out.println("第" + step + "次移动  " + m + "->" + n);
    }


    public static void Hanoi(int n,char a,char b,char c){
        if(n == 1){
            Move(a,c);
        }else{
            Hanoi(n-1,a,c,b);
            Move(a,c);
            Hanoi(n-1,b,a,c);
        }
    }

    public static void main(String[] args) {

        Hanoi(3,'A','B','C');
    }

}
