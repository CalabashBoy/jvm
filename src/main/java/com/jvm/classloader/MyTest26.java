package com.jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @program: jvm
 * @description: 线程类加载器的使用模式
 * @author: Calabash
 * @create: 2019-05-02 16:49
 *
 *
 * 获取  使用  还原
 *
 *
 **/
public class MyTest26 {

  public static void main(String[] args) {
    ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
    Iterator<Driver> iterator = loader.iterator();

    while (iterator.hasNext()){
      Driver driver = iterator.next();
      System.out.println("driver : " + driver.getClass());
      System.out.println("loader : " + driver.getClass().getClassLoader());
    }

    System.out.println(Thread.currentThread().getContextClassLoader());
    System.out.println(ServiceLoader.class.getClassLoader() );
  }
}
