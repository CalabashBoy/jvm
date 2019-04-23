package com.jvm.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: jvm
 * @description:
 * @author: Calabash
 * @create: 2019-04-23 23:18
 **/
public class MyTest20 {

  public static void main(String[] args)
      throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    MyTest16 loader1 = new MyTest16("loader1");
    MyTest16 loader2 = new MyTest16("loader2");

    Class<?> clazz1 = loader1.loadClass("com.jvm.classloader.MyPerson");
    Class<?> clazz2 = loader1.loadClass("com.jvm.classloader.MyPerson");

    System.out.println(clazz1 == clazz2);

    Object object1 = clazz1.newInstance();
    Object object2 = clazz2.newInstance();

    Method method = clazz1.getMethod("setMyPerson", Object.class);
    //第一个参数，在哪个对象上调用这个方法
    //传入参数个数，与method一致
    method.invoke(object1, object2);
  }
}
