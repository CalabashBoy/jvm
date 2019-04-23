package com.jvm.classloader;

/**
 * @program: jvm
 * @description:
 * @author: Calabash
 * @create: 2019-04-23 23:19
 **/
public class MyPerson {
  private MyPerson myPerson;

  public void setMyPerson(Object o){
    this.myPerson = (MyPerson) o;
  }
}
