package com.jvm.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 双亲委派模型的好处"
 * 1、保证java核心哭的安全：所有应用都会引用object类，运行期object类会被加载到虚拟机中
 * 如果这个加载过程是由java应用所完成的，很可能会在jvm中存在多个版本object而且这些类之间相互不可见不兼容的，正式命名空间发挥作用
 * 借助于双亲委派机制，java核心类库的加载工作由启动加载器统一完成，使用的都是同一个版本的java类库，他们之间相互兼容
 * 2、java核心类库的类不会被自定义的类替代
 * 3、不同的类加载器可以为相同名称的类创建额外的命名空间，相同名称的类可以并存在jvm中，
 * 只需用不同的类加载器加载即可，不同加载器加载的类不兼容，相当于在java虚拟机内部创建一个又一个相互隔离的类空间
 * ，这类技术在很多框架中得到实际应用
 **/
public class MyTest21 {

  public static void main(String[] args)
      throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    MyTest16 loader1 = new MyTest16("loader1");
    MyTest16 loader2 = new MyTest16("loader2");

    loader1.setPath("/Users/calabash/Desktop/classes/");
    loader2.setPath("/Users/calabash/Desktop/classes/");

    Class<?> clazz1 = loader1.loadClass("com.jvm.classloader.MyPerson");
    Class<?> clazz2 = loader2.loadClass("com.jvm.classloader.MyPerson");

    //将工程目录下myperson。class删除
    //这里输出false
    //命名空间不同
    System.out.println(clazz1 == clazz2);

    Object object1 = clazz1.newInstance();
    Object object2 = clazz2.newInstance();

    Method method = clazz1.getMethod("setMyPerson", Object.class);
    //第一个参数，在哪个对象上调用这个方法
    //传入参数个数，与method一致
    method.invoke(object1, object2);
  }
}
