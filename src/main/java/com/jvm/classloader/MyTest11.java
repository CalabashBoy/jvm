package com.jvm.classloader;

class Parent3 {

  static int a = 3;

  static {
    System.out.println("Parent2 static block.");
  }

  static void doSomething() {
    System.out.println("do some thing");
  }
}


class Child3 extends Parent3 {
  static {
    System.out.println("Child3 static block.");
  }
}

public class MyTest11 {

  public static void main(String[] args) {
    //通过子类访问父类的静态变量
    //对父类的主动使用，初始化父类，先初始化static
    //然后打印a的值
    //但是没有对Child3的主动使用，没有初始化Child3的静态代码块
    System.out.println(Child3.a);

    //Child3依然没有初始化静态代码块
    //本质上是对父类的主动使用
    Child3.doSomething();
  }
}
