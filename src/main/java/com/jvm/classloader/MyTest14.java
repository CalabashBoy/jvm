package com.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @program: jvm
 * @description:
 * @author: Calabash
 * @create: 2019-04-21 22:36
 **/
public class MyTest14 {

  public static void main(String[] args) throws IOException {
    ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//    System.out.println(contextClassLoader);
    //路径有问题，程序没输出！！！！
    String resourceName = "target/classes/com/jvm/classloader/MyTest13.class";

    Enumeration<URL> resources = contextClassLoader.getResources(resourceName);

    while (resources.hasMoreElements()) {
      URL url = resources.nextElement();
      System.out.println(url);
    }

    System.out.println("++++++++++++++++");
    Class<MyTest14> myTest14Class = MyTest14.class;
    System.out.println(myTest14Class.getClassLoader());

    System.out.println("++++++++++++++++");
    Class<String> stringClass = String.class;
    System.out.println(stringClass.getClassLoader());


  }
}
