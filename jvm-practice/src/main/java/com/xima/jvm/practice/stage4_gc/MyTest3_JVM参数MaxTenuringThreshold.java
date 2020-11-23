package com.xima.jvm.practice.stage4_gc;

/**
 *
 * 虚拟机参数
 * -------------------------------------
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:+PrintCommandLineFlags
 * -XX:MaxTenuringThreshold=5
 * -XX:+PrintTenuringDistribution
 * -XX:+UseParallelGC
 *
 * 用java 1.8执行
 * 打印--------------------
 * -XX:InitialHeapSize=20971520 -XX:InitialTenuringThreshold=5 -XX:MaxHeapSize=20971520 -XX:MaxNewSize=10485760 -XX:MaxTenuringThreshold=5 -XX:NewSize=10485760 -XX:+PrintCommandLineFlags -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintTenuringDistribution -XX:SurvivorRatio=8 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseParallelGC
 * [GC (Allocation Failure)
 * Desired survivor size 1048576 bytes, new threshold 5 (max 5)
 * [PSYoungGen: 8076K->560K(9216K)] 8076K->6712K(19456K), 0.0060979 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 560K->0K(9216K)] [ParOldGen: 6152K->6584K(10240K)] 6712K->6584K(19456K), [Metaspace: 3242K->3242K(1056768K)], 0.0049556 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 * hello world
 * Heap
 *  PSYoungGen      total 9216K, used 2515K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 *   eden space 8192K, 30% used [0x00000007bf600000,0x00000007bf874f30,0x00000007bfe00000)
 *   from space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
 *   to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
 *  ParOldGen       total 10240K, used 6584K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
 *   object space 10240K, 64% used [0x00000007bec00000,0x00000007bf26e298,0x00000007bf600000)
 *  Metaspace       used 3281K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 360K, capacity 388K, committed 512K, reserved 1048576K
 *
 * 备注：
 *  new threshold 5 (max 5)
 *
 *
 * MaxTenuringThreshold作用：在可以自动调节对象晋升（promote）到老年代阈值的GC中，设置该阈值的最大值。
 * 该参数的默认值为15，CMS中默认值为6，G1中默认为15（在JVM中，该数值是由4个bit来表示的，所以最大值为1111，即15）
 *
 * 经历了多次GC后，存活的对象会在From Survivor与To Survivor之间来回存放，而这里面的一个前提则是这两个空间有足够的大小来存放这些数据，再GC算法中，
 * 会计算每个对象年龄的大小，如果达到某个年龄后发现总大小已经大于了Survivor空间的50%，那么这时就需要调整阈值，不能再继续等到默认的15次GC后才完成晋升，
 * 因为这样会导致Survivor空间不足，所以需要调整阈值，让这些存活对象尽快完成晋升。
 *
 *
 *
 *
 */
public class MyTest3_JVM参数MaxTenuringThreshold {

    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[2 * size];
        byte[] myAlloc4 = new byte[2 * size];

        System.out.println("hello world");
    }

}