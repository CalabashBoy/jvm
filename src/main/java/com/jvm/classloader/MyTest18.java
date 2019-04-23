package com.jvm.classloader;

/**
 * @program: jvm
 * @description:
 * @author: Calabash
 * @create: 2019-04-23 23:00
 **/
public class MyTest18 {

  public static void main(String[] args) {
    System.out.println(System.getProperty("sun.boot.class.path"));
    System.out.println(System.getProperty("java.ext.dirs"));
    System.out.println(System.getProperty("java.class.path"));
  }
}
