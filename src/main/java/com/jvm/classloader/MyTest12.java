package com.jvm.classloader;

class CL{
  static {
    System.out.println("CLass CL");
  }
}
public class MyTest12 {

  public static void main(String[] args) throws ClassNotFoundException {
    //没有导致cl类的初始化
    //classLoader.loadClass并不是对类的主动使用
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    Class<?> aClass = classLoader.loadClass("com.jvm.classloader.CL");
    System.out.println(aClass);

    System.out.println("----------");
    //cl类初始化了
    //反射也是属于主动使用
    Class<?> aClass1 = Class.forName("com.jvm.classloader.CL");
    System.out.println(aClass1);
  }
}
