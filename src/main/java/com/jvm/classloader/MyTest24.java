package com.jvm.classloader;

/**
 * 当前类加载器
 * 每一个类都会尝试使用自己的类加载器来去加载其他的类
 * 如果classx引用了classy，那么classx的类加载器就会加载classy，前提是classy尚未被加载
 *
 *
 * 线程上下文类加载器：
 * jdk1.2开始引入，类Thread中的ContextClassLoader
 * 如果没有setContextClassLoader，线程继承父线程的上下文类加载器
 *
 *
 * 重要性，原因和作用：
 * spi：Service Provider Interface
 * 父ClassLoader可以使用当前线程 Thread.currentThread().getContextClassLoader()
 * 这就改变了父ClassLoader不能使用子Classloader的情况，改变了双亲委派模型
 * 线程上下文类加载器，就是当前线程的当前classloader
 *
 * 在双亲委托模型下，类加载是由下至上的，即下层的类加载器会委托上层进行加载
 * 在spi模型下，java核心类是由启动类加载器加载，而这些接口的实现来自于
 * 不同的jar，这样传统的双亲委托模型无法满足spi要求，而通过给当前线程设置的
 * 当前上下文类加载器来实现类的加载
 **/
public class MyTest24 {

  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getContextClassLoader());
    System.out.println(Thread.class.getClassLoader());
  }
}
