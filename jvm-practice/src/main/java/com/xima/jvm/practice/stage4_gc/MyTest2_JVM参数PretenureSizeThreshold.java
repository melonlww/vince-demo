package com.xima.jvm.practice.stage4_gc;

/**
 * PretenureSizeThreshold：设置对象超过多大时直接在老年代进行分配（UseSerialGC 串行垃圾收集器此参数才会生效）
 *
 *
 * 实验一：
 * 虚拟机参数
 * -------------------------------------
 *  -verbose:gc
 *  -Xms20M
 *  -Xmx20M
 *  -Xmn10M
 *  -XX:+PrintGCDetails
 *  -XX:SurvivorRatio=8
 *  -XX:+UseParallelGC
 *  -XX:PretenureSizeThreshold=4194304     (4194304 = 4*1024*1024)
 *
 *  打印----------------------
 *  [0.003s][warning][gc] -XX:+PrintGCDetails is deprecated. Will use -Xlog:gc* instead.
 * [0.013s][info   ][gc] Using Parallel
 * [0.013s][info   ][gc,heap,coops] Heap address: 0x00000007fec00000, size: 20 MB, Compressed Oops mode: Zero based, Oop shift amount: 3
 * [0.298s][info   ][gc,heap,exit ] Heap
 * [0.298s][info   ][gc,heap,exit ]  PSYoungGen      total 9216K, used 7585K [0x00000007ff600000, 0x0000000800000000, 0x0000000800000000)
 * [0.298s][info   ][gc,heap,exit ]   eden space 8192K, 92% used [0x00000007ff600000,0x00000007ffd68778,0x00000007ffe00000)
 * [0.298s][info   ][gc,heap,exit ]   from space 1024K, 0% used [0x00000007fff00000,0x00000007fff00000,0x0000000800000000)
 * [0.298s][info   ][gc,heap,exit ]   to   space 1024K, 0% used [0x00000007ffe00000,0x00000007ffe00000,0x00000007fff00000)
 * [0.298s][info   ][gc,heap,exit ]  ParOldGen       total 10240K, used 0K [0x00000007fec00000, 0x00000007ff600000, 0x00000007ff600000)
 * [0.298s][info   ][gc,heap,exit ]   object space 10240K, 0% used [0x00000007fec00000,0x00000007fec00000,0x00000007ff600000)
 * [0.298s][info   ][gc,heap,exit ]  Metaspace       used 6426K, capacity 6507K, committed 6784K, reserved 1056768K
 * [0.298s][info   ][gc,heap,exit ]   class space    used 559K, capacity 570K, committed 640K, reserved 1048576K
 *
 * 备注:
 * ParOldGen       total 10240K, used 0K
 * 5M没有进入老年代，还在新生代   PretenureSizeThreshold 没有生效
 * 原因：UseParallelGC 垃圾收集器PretenureSizeThreshold参数不会生效
 *
 *
 *
 * 实验二：
 * 虚拟机参数
 * -------------------------------------
 *  -verbose:gc
 *  -Xms20M
 *  -Xmx20M
 *  -Xmn10M
 *  -XX:+PrintGCDetails
 *  -XX:SurvivorRatio=8
 *  -XX:+UseSerialGC
 *  -XX:PretenureSizeThreshold=4194304     (4194304 = 4*1024*1024)
 *
 *  打印----------------------
 *  [0.002s][warning][gc] -XX:+PrintGCDetails is deprecated. Will use -Xlog:gc* instead.
 * [0.012s][info   ][gc] Using Serial
 * [0.012s][info   ][gc,heap,coops] Heap address: 0x00000007fec00000, size: 20 MB, Compressed Oops mode: Zero based, Oop shift amount: 3
 * [0.235s][info   ][gc,heap,exit ] Heap
 * [0.235s][info   ][gc,heap,exit ]  def new generation   total 9216K, used 2464K [0x00000007fec00000, 0x00000007ff600000, 0x00000007ff600000)
 * [0.235s][info   ][gc,heap,exit ]   eden space 8192K,  30% used [0x00000007fec00000, 0x00000007fee68360, 0x00000007ff400000)
 * [0.235s][info   ][gc,heap,exit ]   from space 1024K,   0% used [0x00000007ff400000, 0x00000007ff400000, 0x00000007ff500000)
 * [0.235s][info   ][gc,heap,exit ]   to   space 1024K,   0% used [0x00000007ff500000, 0x00000007ff500000, 0x00000007ff600000)
 * [0.235s][info   ][gc,heap,exit ]  tenured generation   total 10240K, used 5120K [0x00000007ff600000, 0x0000000800000000, 0x0000000800000000)
 * [0.235s][info   ][gc,heap,exit ]    the space 10240K,  50% used [0x00000007ff600000, 0x00000007ffb00010, 0x00000007ffb00200, 0x0000000800000000)
 * [0.235s][info   ][gc,heap,exit ]  Metaspace       used 6381K, capacity 6443K, committed 6784K, reserved 1056768K
 * [0.235s][info   ][gc,heap,exit ]   class space    used 556K, capacity 570K, committed 640K, reserved 1048576K
 *
 * 备注:
 * tenured generation   total 10240K, used 5120K
 * 5M进入老年代，PretenureSizeThreshold 生效了
 * 原因：UseSerialGC 垃圾收集器PretenureSizeThreshold参数生效
 */
public class MyTest2_JVM参数PretenureSizeThreshold {

    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAlloc = new byte[5 * size];
    }

}
