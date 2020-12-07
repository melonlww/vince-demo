package com.xima.jvm.practice.stage4_gc;

/**
 * 虚拟机参数
 * -------------------------------------
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:+UseConcMarkSweepGC
 *
 *
 * 输出：
 * -------------------------------------
 * 1111111
 * [GC (Allocation Failure) [ParNew: 6192K->493K(9216K), 0.0067069 secs] 6192K->4591K(19456K), 0.0067846 secs] [Times: user=0.02 sys=0.01, real=0.01 secs]
 * 2222222
 * [GC (Allocation Failure) [ParNew: 4744K->634K(9216K), 0.0180754 secs] 8842K->8831K(19456K), 0.0181051 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
 * [GC (CMS Initial Mark) [1 CMS-initial-mark: 8196K(10240K)] 12927K(19456K), 0.0010737 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [CMS-concurrent-mark-start]
 * [CMS-concurrent-mark: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [CMS-concurrent-preclean-start]
 * [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [CMS-concurrent-abortable-preclean-start]
 * [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (CMS Final Remark) [YG occupancy: 4894 K (9216 K)][Rescan (parallel) , 0.0010033 secs][weak refs processing, 0.0000081 secs][class unloading, 0.0002876 secs][scrub symbol table, 0.0004879 secs][scrub string table, 0.0001512 secs][1 CMS-remark: 8196K(10240K)] 13090K(19456K), 0.0020128 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 * [CMS-concurrent-sweep-start]
 * [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * 3333333[CMS-concurrent-reset-start]
 *
 * [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * 4444444
 * Heap
 *  par new generation   total 9216K, used 7182K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
 *   eden space 8192K,  79% used [0x00000007bec00000, 0x00000007bf264ff8, 0x00000007bf400000)
 *   from space 1024K,  61% used [0x00000007bf400000, 0x00000007bf49eb80, 0x00000007bf500000)
 *   to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
 *  concurrent mark-sweep generation total 10240K, used 8196K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
 *  Metaspace       used 3309K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 365K, capacity 388K, committed 512K, reserved 1048576K
 *
 * Process finished with exit code 0
 */
public class MyTest5_输出GC信息_CMS {

    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAlloc1 = new byte[4 * size];
        System.out.println("1111111");

        byte[] myAlloc2 = new byte[4 * size];
        System.out.println("2222222");

        byte[] myAlloc3 = new byte[4 * size];
        System.out.println("3333333");

        byte[] myAlloc4 = new byte[2 * size];
        System.out.println("4444444");
    }
}