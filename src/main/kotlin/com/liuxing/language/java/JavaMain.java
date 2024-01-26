package com.liuxing.language.java;

/**
 * Description:
 * Author: liuxia
 * Date: 2023/11/28
 */
public class JavaMain<T> {

    public static void main(String[] args) {
//        JavaMain javaMain = new JavaMain();
//        System.out.println(javaMain.fib(1));
//        System.out.println(javaMain.fib(2));
//        System.out.println(javaMain.fib(3));
//        System.out.println(javaMain.fib(4));


    }

    public int fib(int n) {
        return fib(1, 1, n);
    }

    private int fib(int num1, int num2, int n) {
        return n == 0 ? num1 : fib(num2, num1 + num2, n - 1);
    }

}
