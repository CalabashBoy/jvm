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
    byte[] data = loadClassData(name);
    return this.defineClass(name, data, 0, data.length);
  }

  private byte[] loadClassData(String name) {
    // load the class data from the connection

    InputStream in = null;
    byte[] data = null;
    ByteArrayOutputStream baos = null;

    try {
      this.classLoaderName = this.classLoaderName.replace(".", "/");

      in = new FileInputStream(new File(name + this.fileExtension));
      baos = new ByteArrayOutputStream();

      int ch = 0;
      while (-1 != (ch = in.read())) {
        baos.write(ch);
      }

      data = baos.toByteArray();
    } catch (Exception e) {

    } finally {

      try {
        in.close();
        baos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return data;
  }

  public static void test(ClassLoader classLoader)
      throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    Class<?> aClass = classLoader
        .loadClass("com.jvm.classloader.Child");

    Object o = aClass.newInstance();
    System.out.println(o);

  }

  public static void main(String[] args)
      throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    MyTest16 myTest16 = new MyTest16("loader1");
    test(myTest16);
  }
}
