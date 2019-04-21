package com.jvm.classloader;

import java.util.UUID;

/**
 * 当一个常量的值并非编译期间可以确定的，那么他的值就不会放到调用类的常量池中
 * 这时在程序运行的时候，会导致主动使用这个常量的值所在的类，会初始化该类
 * @program: jvm
 * @description:
 * @author: Calabash
 * @create: 2019-04-21 00:50
 **/
public class MyTest3 {

  public static void main(String[] args) {
    System.out.println(MyParent3.str);
  }
}

class MyParent3{
  //运行时才能知道uuid的值
  public static final String str = UUID.randomUUID().toString();

  static {
    System.out.println("MyParent3 static code.");
  }
}