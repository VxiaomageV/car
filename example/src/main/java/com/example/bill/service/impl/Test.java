package com.example.bill.service.impl;

import java.util.ArrayList;

/**
 * @description:
 * @author: mal
 * @date: 2020/5/22
 */
public class Test {


    public static void main(String[] args){
        ArrayList<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        for(String str : list){
            System.out.println(str);
        }
        list.forEach((s) -> System.out.println(s));
        list.forEach(System.out::println);
    }

}
