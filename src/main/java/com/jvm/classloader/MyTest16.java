package com.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: jvm
 * @description:
 * @author: Calabash
 * @create: 2019-04-21 23:46
 **/
public class MyTest16 extends ClassLoader {

  private String classLoaderName;

  private final String fileExtension = ".class";

  private String path;

  public void setPath(String path) {
    this.path = path;
  }

  public MyTest16(String classLoaderName) {
    //将系统类加载器当作该类加载器的父加载器
    super();
    this.classLoaderName = classLoaderName;
  }

  public MyTest16(ClassLoader parent, String classLoaderName) {
    //显示制定该类加载器的父加载器
    super(parent);
    this.classLoaderName = classLoaderName;
  }

  @Override
  public String toString() {
    return "[" + this.classLoaderName + "]";
  }

  @Override
  public Class<?> findClass(String name) {
    System.out.println("find class invoked : " + name);
    System.out.println("class loader name : " + this.classLoaderName);
    byte[] data = loadClassData(name);
    return this.defineClass(name, data, 0, data.length);
  }

  private byte[] loadClassData(String name) {
    // load the class data from the connection

    InputStream in = null;
    byte[] data = null;
    ByteArrayOutputStream baos = null;

    //classLoaderName = classLoaderName.replaceAll(".", "/");

    try {
      name = name.replace(".", "/");
      String filePath = this.path + name + this.fileExtension;
      in = new FileInputStream(new File(filePath));
      baos = new ByteArrayOutputStream();

      int ch = 0;
      while (-1 != (ch = in.read())) {
        baos.write(ch);
      }

      data = baos.toByteArray();
    } catch (Exception e) {

    } finally {

      try {
        if (in != null) {
          in.close();
        }
        if (baos != null) {
          baos.close();

        }

      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return data;
  }

  public static void main(String[] args)
      throws IllegalAccessException, InstantiationException, ClassNotFoundException {

    //由于双亲委派机制，并没有使用自定义的类加载器加载
    //因为class文件在classpath路径下
//    MyTest16 loader = new MyTest16("loader1");
//    loader.setPath("/Users/calabash/Desktop/代码/jvm/target/classes/");
//
//    Class<?> clazz = loader
//        .loadClass("com.jvm.classloader.MyTest1");
//    Object o = clazz.newInstance();
//
//    System.out.println("clazz : " + clazz.hashCode());
//    System.out.println(o.getClass().getClassLoader());

    //classpath下无法加载，使用自定义类加载器
    MyTest16 loader1 = new MyTest16("loader1");
    loader1.setPath("/Users/calabash/Desktop/classes/");

    Class<?> clazz1 = loader1
        .loadClass("com.jvm.classloader.MyTest1");
    Object o1 = clazz1.newInstance();

    System.out.println("clazz1 : " + clazz1.hashCode());
    System.out.println(o1.getClass().getClassLoader());

    //已经有了父类加载器，不用自定义加载器加载class
    MyTest16 loader3 = new MyTest16(loader1, "loader2");
    loader3.setPath("/Users/calabash/Desktop/classes/");

    Class<?> clazz3 = loader1
        .loadClass("com.jvm.classloader.MyTest1");
    Object o3 = clazz1.newInstance();

    System.out.println("clazz3 : " + clazz1.hashCode());
    System.out.println(o3.getClass().getClassLoader());
  }
}
