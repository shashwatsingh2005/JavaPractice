package com.java.features.eight.method_reference;

import java.util.function.BiFunction;

public class Demo {

    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> add = Arithmatic :: sum;
        int z = add.apply(1,3);
        System.out.println(z);

        BiFunction<Integer,Integer,Integer> subs = new Arithmatic() :: substraction;
        int x = subs.apply(3,1);
        System.out.println(x);
    }
}
