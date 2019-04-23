package com.jvm.classloader;

import java.lang.reflect.InvocationTargetException;

/**
 * @program: jvm
 * @description:
 * @author: Calabash
 * @create: 2019-04-22 23:54
 **/
public class MyTest17_1 {

  public static void main(String[] args)
      throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

    MyTest16 loader1 = new MyTest16("loader1");
    loader1.setPath("/Users/calabash/Desktop/classes/");
    Class<?> clazz = loader1.loadClass("com.jvm.classloader.MySample");
    System.out.println("class " + clazz.hashCode());

    Object object = clazz.getDeclaredConstructor().newInstance();
  }
}
