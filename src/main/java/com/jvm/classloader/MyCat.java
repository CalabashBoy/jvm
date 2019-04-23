package com.jvm.classloader;

/**
 * @program: jvm
 * @description:
 * @author: Calabash
 * @create: 2019-04-22 23:34
 **/
public class MyCat {

  public MyCat() {
    System.out.println("MyCat is loaded by : " + this.getClass().getClassLoader());
    System.out.println("from myCat : " + MySample.class);
  }


}
