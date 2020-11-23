package com.xima.jvm.practice.stage4_gc;


/**
 *
 * -XX:+PrintTenuringDistribution：用于显示每次Minor GC（年轻代GC）时Survivor区中各个年龄段的对象的大小
 *
 *
 * 虚拟机参数
 * -------------------------------------
 * -verbose:gc
 * -Xmx200M
 * -Xmn50M
 * -XX:TargetSurvivorRatio=60
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:+UseConcMarkSweepGC
 * -XX:+UseParNewGC
 * -XX:MaxTenuringThreshold=3
 * -XX:+PrintTenuringDistribution
 *
 * 用java 1.8执行
 * 打印----------------------
 2020-11-22T22:56:13.270-0800: [GC (Allocation Failure) 2020-11-22T22:56:13.270-0800: [ParNew
 Desired survivor size 3145728 bytes, new threshold 3 (max 3)
 - age   1:    1530520 bytes,    1530520 total
 : 40141K->1525K(46080K), 0.0012045 secs] 40141K->1525K(125952K), 0.0012566 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 11111
 2020-11-22T22:56:14.280-0800: [GC (Allocation Failure) 2020-11-22T22:56:14.280-0800: [ParNew
 Desired survivor size 3145728 bytes, new threshold 3 (max 3)
 - age   1:       1664 bytes,       1664 total
 - age   2:    1513016 bytes,    1514680 total
 : 42051K->1689K(46080K), 0.0015870 secs] 42051K->1689K(125952K), 0.0016277 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 22222
 2020-11-22T22:56:15.289-0800: [GC (Allocation Failure) 2020-11-22T22:56:15.289-0800: [ParNew
 Desired survivor size 3145728 bytes, new threshold 3 (max 3)
 - age   1:     343512 bytes,     343512 total
 - age   2:       1664 bytes,     345176 total
 - age   3:    1508864 bytes,    1854040 total
 : 41826K->1998K(46080K), 0.0013619 secs] 41826K->1998K(125952K), 0.0014078 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 33333
 2020-11-22T22:56:16.297-0800: [GC (Allocation Failure) 2020-11-22T22:56:16.297-0800: [ParNew
 Desired survivor size 3145728 bytes, new threshold 3 (max 3)
 - age   1:         56 bytes,         56 total
 - age   2:     342856 bytes,     342912 total
 - age   3:       1664 bytes,     344576 total
 : 42712K->837K(46080K), 0.0042232 secs] 42712K->2323K(125952K), 0.0042650 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
 44444
 2020-11-22T22:56:17.311-0800: [GC (Allocation Failure) 2020-11-22T22:56:17.311-0800: [ParNew
 Desired survivor size 3145728 bytes, new threshold 3 (max 3)
 - age   1:    1572968 bytes,    1572968 total
 - age   2:         56 bytes,    1573024 total
 - age   3:     342856 bytes,    1915880 total
 : 41560K->1976K(46080K), 0.0012904 secs] 43046K->3464K(125952K), 0.0013309 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 55555
 2020-11-22T22:56:18.321-0800: [GC (Allocation Failure) 2020-11-22T22:56:18.321-0800: [ParNew
 Desired survivor size 3145728 bytes, new threshold 3 (max 3)
 - age   1:         56 bytes,         56 total
 - age   2:    1572968 bytes,    1573024 total
 - age   3:         56 bytes,    1573080 total
 : 42705K->1693K(46080K), 0.0023285 secs] 44192K->3538K(125952K), 0.0023695 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 66666
 hello world
 Heap
 par new generation   total 46080K, used 18672K [0x00000007b3800000, 0x00000007b6a00000, 0x00000007b6a00000)
 eden space 40960K,  41% used [0x00000007b3800000, 0x00000007b4894d98, 0x00000007b6000000)
 from space 5120K,  33% used [0x00000007b6000000, 0x00000007b61a7470, 0x00000007b6500000)
 to   space 5120K,   0% used [0x00000007b6500000, 0x00000007b6500000, 0x00000007b6a00000)
 concurrent mark-sweep generation total 79872K, used 1845K [0x00000007b6a00000, 0x00000007bb800000, 0x00000007c0000000)
 Metaspace       used 3807K, capacity 4536K, committed 4864K, reserved 1056768K
 class space    used 423K, capacity 428K, committed 512K, reserved 1048576K
 *
 * 备注：new threshold会动态变化，每次gc后会重新计算， 此处demo都为3，视频中实验中会有1的情况
 */


public class MyTest4_JVM参数MaxTenuringThreshold {
    public static void main(String[] args) throws InterruptedException {
        byte[] byte_1 = new byte[512 * 1024];
        byte[] byte_2 = new byte[512 * 1024];

        myGC();
        Thread.sleep(1000);
        System.out.println("11111");

        myGC();
        Thread.sleep(1000);
        System.out.println("22222");

        myGC();
        Thread.sleep(1000);
        System.out.println("33333");

        myGC();
        Thread.sleep(1000);
        System.out.println("44444");

        byte[] byte_3 = new byte[512 * 1024];
        byte[] byte_4 = new byte[512 * 1024];
        byte[] byte_5 = new byte[512 * 1024];

        myGC();
        Thread.sleep(1000);
        System.out.println("55555");

        myGC();
        Thread.sleep(1000);
        System.out.println("66666");

        System.out.println("hello world");

    }

    private static void myGC() {
        for (int i = 0; i < 40; i++) {
            byte[] byteArray = new byte[1024 * 1024];
        }
    }
}
