package com.jvm.classloader;

/**
 * @program: jvm
 * @description:
 * @author: Calabash
 * @create: 2019-04-21 16:36
 **/
public class MyTest7 {

  public static void main(String[] args) throws ClassNotFoundException {
    Class<?> clazz = Class.forName("java.lang.String");
    System.out.println(clazz.getClassLoader());

    Class<?> clazzc = Class.forName("com.jvm.classloader.C");
    System.out.println(clazzc.getClassLoader());
  }
}


class C {

}