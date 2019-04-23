package com.jvm.classloader;

/**
 * @program: jvm
 * @description:
 * @author: Calabash
 * @create: 2019-04-23 23:05
 **/
public class MyTest18_1 {

  public static void main(String[] args) throws ClassNotFoundException {
    MyTest16 loader1 = new MyTest16("loader1");
    loader1.setPath("/Users/calabash/Desktop/classes/");
    Class<?> clazz = loader1.loadClass("com.jvm.classloader.MySample");
    System.out.println("class : " + clazz.hashCode());
    System.out.println("class loader : " + clazz.getClassLoader());
  }
}
