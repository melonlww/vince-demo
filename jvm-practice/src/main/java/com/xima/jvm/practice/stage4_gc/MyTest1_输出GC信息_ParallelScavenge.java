package com.xima.jvm.practice.stage4_gc;

/**
 *
 *
 * 虚拟机参数
 * -------------------------------------
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:+UseParallelGC
 *
 *
 *
 */
public class MyTest1_输出GC信息_ParallelScavenge {

    public static void main(String[] args) {
        int size = 1024 * 1024;

//        byte[] myAlloc1 = new byte[2 * size];
//        byte[] myAlloc2 = new byte[2 * size];
//        byte[] myAlloc3 = new byte[2 * size];
        /**
         * 输出：
         * -------------------------------------
         * [0.011s][info   ][gc] Using Parallel
         * [0.011s][info   ][gc,heap,coops] Heap address: 0x00000007fec00000, size: 20 MB, Compressed Oops mode: Zero based, Oop shift amount: 3
         * [0.198s][info   ][gc,start     ] GC(0) Pause Young (Allocation Failure)
         * [0.201s][info   ][gc,heap      ] GC(0) PSYoungGen: 6396K->993K(9216K)
         * [0.201s][info   ][gc,heap      ] GC(0) ParOldGen: 0K->4168K(10240K)
         * [0.201s][info   ][gc,metaspace ] GC(0) Metaspace: 6408K->6408K(1056768K)
         * [0.201s][info   ][gc           ] GC(0) Pause Young (Allocation Failure) 6M->5M(19M) 3.271ms
         * [0.201s][info   ][gc,cpu       ] GC(0) User=0.00s Sys=0.01s Real=0.00s
         */

        /**
         * 备注：
         * Pause Young (Allocation Failure)    Minor GC -> GC原因： Allocation Failure
         * 6396K-993K = 5403K          执行完gc后，新生代释放的空间容量
         * ParOldGen: 0K->4168K        4168K  执行完gc后，老年代的空间容量
         *
         *
         *  PSYoungGen: Parallel Scavenge 新生代垃圾收集器
         *  ParOldGen： Parallel Old 老年代垃圾收集器
         */

//        byte[] myAlloc1 = new byte[2 * size];
//        byte[] myAlloc2 = new byte[2 * size];
//        byte[] myAlloc3 = new byte[3 * size];
//        byte[] myAlloc4 = new byte[3 * size];
        /**
         * 输出：
         * -------------------------------------
         * [0.011s][info   ][gc] Using Parallel
         * [0.011s][info   ][gc,heap,coops] Heap address: 0x00000007fec00000, size: 20 MB, Compressed Oops mode: Zero based, Oop shift amount: 3
         * [0.218s][info   ][gc,start     ] GC(0) Pause Young (Allocation Failure)
         * [0.222s][info   ][gc,heap      ] GC(0) PSYoungGen: 6397K->993K(9216K)
         * [0.222s][info   ][gc,heap      ] GC(0) ParOldGen: 0K->4168K(10240K)
         * [0.222s][info   ][gc,metaspace ] GC(0) Metaspace: 6452K->6452K(1056768K)
         * [0.222s][info   ][gc           ] GC(0) Pause Young (Allocation Failure) 6M->5M(19M) 3.731ms
         * [0.222s][info   ][gc,cpu       ] GC(0) User=0.00s Sys=0.00s Real=0.00s
         */


        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[2 * size];
        byte[] myAlloc4 = new byte[2 * size];
        byte[] myAlloc5 = new byte[2 * size];
        byte[] myAlloc6 = new byte[2 * size];
        /**
         * 输出：
         * -------------------------------------
         * [0.208s][info   ][gc,start     ] GC(0) Pause Young (Allocation Failure)
         * [0.211s][info   ][gc,heap      ] GC(0) PSYoungGen: 6396K->1018K(9216K)
         * [0.211s][info   ][gc,heap      ] GC(0) ParOldGen: 0K->4136K(10240K)
         * [0.211s][info   ][gc,metaspace ] GC(0) Metaspace: 6286K->6286K(1056768K)
         * [0.211s][info   ][gc           ] GC(0) Pause Young (Allocation Failure) 6M->5M(19M) 3.183ms
         * [0.211s][info   ][gc,cpu       ] GC(0) User=0.01s Sys=0.00s Real=0.00s
         * [0.212s][info   ][gc,start     ] GC(1) Pause Young (Allocation Failure)
         * [0.216s][info   ][gc,promotion ] Promotion failed
         * [0.216s][info   ][gc,heap      ] GC(1) PSYoungGen: 7399K->7399K(9216K)
         * [0.216s][info   ][gc,heap      ] GC(1) ParOldGen: 4136K->8232K(10240K)
         * [0.216s][info   ][gc,metaspace ] GC(1) Metaspace: 6304K->6304K(1056768K)
         * [0.216s][info   ][gc           ] GC(1) Pause Young (Allocation Failure) 11M->15M(19M) 4.505ms
         * [0.216s][info   ][gc,cpu       ] GC(1) User=0.00s Sys=0.01s Real=0.01s
         * [0.217s][info   ][gc,start     ] GC(2) Pause Full (Ergonomics)
         * [0.217s][info   ][gc,phases,start] GC(2) Marking Phase
         * [0.218s][info   ][gc,phases      ] GC(2) Marking Phase 1.901ms
         * [0.218s][info   ][gc,phases,start] GC(2) Summary Phase
         * [0.218s][info   ][gc,phases      ] GC(2) Summary Phase 0.008ms
         * [0.218s][info   ][gc,phases,start] GC(2) Adjust Roots
         * [0.220s][info   ][gc,phases      ] GC(2) Adjust Roots 1.052ms
         * [0.220s][info   ][gc,phases,start] GC(2) Compaction Phase
         * [0.223s][info   ][gc,phases      ] GC(2) Compaction Phase 3.480ms
         * [0.223s][info   ][gc,phases,start] GC(2) Post Compact
         * [0.223s][info   ][gc,phases      ] GC(2) Post Compact 0.238ms
         * [0.223s][info   ][gc,heap        ] GC(2) PSYoungGen: 7399K->3021K(9216K)
         * [0.223s][info   ][gc,heap        ] GC(2) ParOldGen: 8232K->8228K(10240K)
         * [0.223s][info   ][gc,metaspace   ] GC(2) Metaspace: 6304K->6304K(1056768K)
         * [0.223s][info   ][gc             ] GC(2) Pause Full (Ergonomics) 15M->10M(19M) 6.806ms
         * [0.223s][info   ][gc,cpu         ] GC(2) User=0.02s Sys=0.00s Real=0.00s
         */

        /**
         * 备注：
         *  Pause Young (Allocation Failure)    Minor GC -> GC原因： Allocation Failure
         *  Pause Full (Ergonomics)             Full GC ->  Ergonomics翻译成中文，一般都是“人体工程学”。在JVM中的垃圾收集器中的Ergonomics就是负责自动的调解gc暂停时间和吞吐量之间的平衡，然后你的虚拟机性能更好的一种做法。
         *
         */

        System.out.println("hello world");
    }
}
