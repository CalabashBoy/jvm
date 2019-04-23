package com.jvm.classloader;

import java.lang.reflect.InvocationTargetException;

/**
 * @program: jvm
 * @description:
 * @author: Calabash
 * @create: 2019-04-22 23:54
 **/
public class MyTest17 {

  public static void main(String[] args)
      throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    //首先由父加载器加载
    MyTest16 loader1 = new MyTest16("loader1");
    Class<?> clazz = loader1.loadClass("com.jvm.classloader.MySample");
    System.out.println("class " + clazz.hashCode());
    //如果注释这里，
    //mysample不会实例化，也不会调用构造方法，也不会实例化mycat
    //没有对mycat主动使用，不会加载mycat.class
    Object object = clazz.getDeclaredConstructor().newInstance();
  }
}
