package com.xima.jvm.practice.stage3_memory;

/**
 * -Xss200k
 *
 * 虚拟机栈溢出
 *
 * 1092
 * java.lang.StackOverflowError
 * 	at com.xima.jvm.practice.stage3_memory.MyTest2_StackOverflowError.test(MyTest2_StackOverflowError.java:17)
 * 	at com.xima.jvm.practice.stage3_memory.MyTest2_StackOverflowError.test(MyTest2_StackOverflowError.java:19)
 * 	at com.xima.jvm.practice.stage3_memory.MyTest2_StackOverflowError.test(MyTest2_StackOverflowError.java:19)
 * 	at com.xima.jvm.practice.stage3_memory.MyTest2_StackOverflowError.test(MyTest2_StackOverflowError.java:19)
 * 	at com.xima.jvm.practice.stage3_memory.MyTest2_StackOverflowError.test(MyTest2_StackOverflowError.java:19)
 *
 *
 */
public class MyTest2_StackOverflowError {

    private int length;

    public int getLength() {
        return length;
    }

    public void test(){
        this.length++;

        test();
    }

    public static void main(String[] args) {

        MyTest2_StackOverflowError myTest2StackOverflowError = new MyTest2_StackOverflowError();
        try {
            myTest2StackOverflowError.test();
        }catch (Throwable ex){
            System.err.println(myTest2StackOverflowError.length);
            ex.printStackTrace();
        }
    }


}
