package com.xima.jvm.practice.stage2_bytecode;

/**
 * 实验一：查看运行结果
 * run
 * ===========result==============
 * grandpa
 * grandpa
 *
 * ##### 方法的静态分派
 *
 * Grandpa g1 = new Father();
 * 1.以上代码，g1的静态类型（声明类型）是Grandpa，而g1的实际类型（真正指向的类型）是Father。
 * 2.我们可以得出这样一个结论：变量的静态类型是不会发生变化的，而变量的实际类型则是可以发生变化的（多态的一种体现），实际类型
 * 是在运行期方可确定。
 * 3.方法重载，是一种静态的行为，编译器就可以完全组额定，jvm会根据g1的静态类型去重载方法中匹配
 *
 * 实验二：查看助记码
 * 操作：
 *    1.进入classpath
 *    2.javap生成字节码  -p打印private的字段和方法
 *    javap -p -v com.xima.jvm.practice.stage2_bytecode.MyTest5_方法的静态分派
 *
 *    主要关注main方法:
 *
 *    24: aload_3
 *    25: aload_1
 *    26: invokevirtual #13                 // Method test:(Lcom/xima/jvm/practice/stage2_bytecode/Grandpa;)V
 *    29: aload_3
 *    30: aload_2
 *    31: invokevirtual #13                 // Method test:(Lcom/xima/jvm/practice/stage2_bytecode/Grandpa;)V
 *
 *
 *
 *
 *    public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: (0x0009) ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=2, locals=4, args_size=1
 *          0: new           #7                  // class com/xima/jvm/practice/stage2_bytecode/Father
 *          3: dup
 *          4: invokespecial #8                  // Method com/xima/jvm/practice/stage2_bytecode/Father."<init>":()V
 *          7: astore_1
 *          8: new           #9                  // class com/xima/jvm/practice/stage2_bytecode/Son
 *         11: dup
 *         12: invokespecial #10                 // Method com/xima/jvm/practice/stage2_bytecode/Son."<init>":()V
 *         15: astore_2
 *         16: new           #11                 // class com/xima/jvm/practice/stage2_bytecode/MyTest5_方法的静态分派
 *         19: dup
 *         20: invokespecial #12                 // Method "<init>":()V
 *         23: astore_3
 *         24: aload_3
 *         25: aload_1
 *         26: invokevirtual #13                 // Method test:(Lcom/xima/jvm/practice/stage2_bytecode/Grandpa;)V
 *         29: aload_3
 *         30: aload_2
 *         31: invokevirtual #13                 // Method test:(Lcom/xima/jvm/practice/stage2_bytecode/Grandpa;)V
 *         34: return
 *       LineNumberTable:
 *         line 42: 0
 *         line 43: 8
 *         line 45: 16
 *         line 46: 24
 *         line 47: 29
 *         line 48: 34
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      35     0  args   [Ljava/lang/String;
 *             8      27     1    g1   Lcom/xima/jvm/practice/stage2_bytecode/Grandpa;
 *            16      19     2    g2   Lcom/xima/jvm/practice/stage2_bytecode/Grandpa;
 *            24      11     3 myTest5   Lcom/xima/jvm/practice/stage2_bytecode/MyTest5_方法的静态分派;
 *
 */
public class MyTest5_invokevirtual操作_方法的静态分派 {

    public void test(Grandpa grandpa){
        System.out.println("grandpa");
    }

    public void test(Father father){
        System.out.println("father");
    }

    public void test(Son son){
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        MyTest5_invokevirtual操作_方法的静态分派 myTest5 = new MyTest5_invokevirtual操作_方法的静态分派();
        myTest5.test(g1);
        myTest5.test(g2);
    }
}

class Grandpa{

}

class Father extends Grandpa{

}

class Son extends Father{

}