package com.jvm.classloader;

//结论：初始化一个接口时，不会事先初始化他的父接口
public class TestOther {

  public static void main(String[] args) {
    System.out.println(MyParent.THREAD);

  }
}


interface MyGrandpa{
    //匿名内部类
  public static final Thread THREAD = new Thread() {

    {
      System.out.println("MyGrandpa invked.");
    }
  };
}

interface MyParent extends MyGrandpa{
  public static final Thread THREAD = new Thread() {

    {
      System.out.println("MyParent invked.");
    }
  };
}

//
//class MyOther {
//
//  //匿名内部类
//  public static final Thread THREAD = new Thread() {
//
//    {
//      System.out.println("MyOther invked.");
//    }
//  };
//}
//
//class MyChild extends MyOther{
//  public static int b = 5;
//}
//
