package com.jvm.classloader;

/**
 * 1、对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * 2、当一个类在初始化时，要求其父类全部都已经初始化
 *
 * -XX:+TraceClassLoading 用于追踪类的加载信息并且打印出来
 * 先加载MyTest
 *
 * -XX:+<option> 开启选项
 * -XX:-<option> 关闭选项
 * -XX:<option>=<value> 将option选项的值设置为value
 */
public class MyTest1 {

  public static void main(String[] args) {
    System.out.println(MyChild1.str1);
  }
}

class MyParent1{
  public static String str1 = "hello world";
  static {
    System.out.println("MyParent1 static block.");
  }
}

class MyChild1 extends MyParent1{

  public static String str2 = "welcome";
  static {
    System.out.println("MyChild1 static block.");
  }
}
