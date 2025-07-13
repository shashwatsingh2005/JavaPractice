package com.java.features.eight.hascode_equals;

public class Demo {

    public static void main(String[] args) {
        Student s1 = new Student(1,"Male","Saurabh",23);
        Student s2 = new Student(1,"Male","Saurabh",24);
        //s2 = s1;
        //s1 = s2;
        if(s1.equals(s2)){
            System.out.println("Both are eqaual as per .equals()");
        }

        if(s1 == s2){
            System.out.println("Both are eqaual as per ==");
        }

        System.out.println("S1 hascode : "+s1.hashCode());
        System.out.println("S2 hascode : "+s2.hashCode());
    }
}
