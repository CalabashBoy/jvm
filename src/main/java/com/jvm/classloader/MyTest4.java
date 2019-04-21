package com.jvm.classloader;

/**
 * 对于数组类型来说，类型是jvm运行期动态生成的，父类型object
 *
 */
public class MyTest4 {

  public static void main(String[] args) {

    //MyParent4 myParent4 = new MyParent4();

    MyParent4[][] myParent4s = new MyParent4[1][1];

    //java虚拟机在运行期生成的数组类型
    //class [Lcom.jvm.classloader.MyParent4;
    System.out.println(myParent4s.getClass());


    int[] ints = new int[1];
    System.out.println(ints.getClass());
    System.out.println(ints.getClass().getSuperclass());
  }
}

class MyParent4{

  static {
    System.out.println("MyParent4 static code.");
  }
}