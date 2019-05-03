package com.jvm.classloader;

/**
 * @program: jvm
 * @description:
 * @author: Calabash
 * @create: 2019-05-01 22:48
 **/
public class MyTest25 implements Runnable{

  private Thread thread;

  public MyTest25(){
    thread = new Thread(this);
    thread.start();
  }

  public void run() {
    ClassLoader classLoader = this.thread.getContextClassLoader();
    this.thread.setContextClassLoader(classLoader);
    System.out.println("Class : " + classLoader.getClass());
    System.out.println("Parent : " + classLoader.getParent());
  }

  public static void main(String[] args) {
    new MyTest25();
  }
}
