package com.jvm.classloader;

import java.util.Random;

/**
 * 当一个接口初始化时，并不要求其父接口完成初始化
 * 只有在真正使用到父接口的时候，才会导致父接口的初始化
 * 接口中不能定义static代码块
 * 接口中的feild static final的
 **/
public class MyTest5 {

  public static void main(String[] args) {
    System.out.println(MyChild5.b1);
  }
}


interface MyParent5 {
  public static final int a = 5;
}

interface MyChild5 extends MyParent5 {

  public static final int b = 6;

  public static final int b1 = new Random().nextInt();
}