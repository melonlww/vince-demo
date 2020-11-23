package com.xima.jvm.practice.stage2_bytecode;

/**
 * #####方法的动态分派
 * 方法的动态分派涉及到一个重要的概念：方法接收者。
 * invokevirtual字节码指令多态的查找流程
 * 比较方法重载（overload）与方法重写（overwrite）。我们可以得到这样一个结论：
 * 方法重载是静态的，是编译器行为；方法重写是动态的，是运行期行为
 *
 *  invokevirtual字节码多态查找流程：
 *  1 首先去操作数的栈顶，去寻找栈顶的元素它所指向对象的实际类型
 *  Fruit orange = new Orange(); Fruit为静态类型（声明类型） 实际类型为Orange
 *  2 在这个实际类型中寻找到这个特定的方法（与常量池当中描述符和名称都相同,并且也具备相应的访问权限 例如 public void test()），
 *  如果符合，就返回目标方法的直接引用，过程结束
 *  3 如果找不到，就按继承关系，从子类到父类依次查找，知道真正找到这个特定的方法（与常量池当中描述符和名称都相同,并且也具备相应的访问权限）
 *  4 如果还是找不到就抛出异常
 *
 * 实验一：查看运行结果
 * ============================
 * Apple
 * Orange
 * Orange
 *
 * 操作：
 *    1.进入classpath
 *    2.javap生成字节码  -p打印private的字段和方法
 *    javap -p -v com.xima.jvm.practice.stage2_bytecode.MyTest6_invokevirtual操作_方法的动态分派
 *
 *      关注main方法
 *
 *        public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: (0x0009) ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=2, locals=3, args_size=1
 *          0: new           #2                  // class com/xima/jvm/practice/stage2_bytecode/Apple
 *          3: dup
 *          4: invokespecial #3                  // Method com/xima/jvm/practice/stage2_bytecode/Apple."<init>":()V
 *          7: astore_1
 *          8: new           #4                  // class com/xima/jvm/practice/stage2_bytecode/Orange
 *         11: dup
 *         12: invokespecial #5                  // Method com/xima/jvm/practice/stage2_bytecode/Orange."<init>":()V
 *         15: astore_2
 *         16: aload_1
 *         17: invokevirtual #6                  // Method com/xima/jvm/practice/stage2_bytecode/Fruit.test:()V
 *         20: aload_2
 *         21: invokevirtual #6                  // Method com/xima/jvm/practice/stage2_bytecode/Fruit.test:()V
 *         24: new           #4                  // class com/xima/jvm/practice/stage2_bytecode/Orange
 *         27: dup
 *         28: invokespecial #5                  // Method com/xima/jvm/practice/stage2_bytecode/Orange."<init>":()V
 *         31: astore_1
 *         32: aload_1
 *         33: invokevirtual #6                  // Method com/xima/jvm/practice/stage2_bytecode/Fruit.test:()V
 *         36: return
 *       LineNumberTable:
 *         line 17: 0
 *         line 18: 8
 *         line 20: 16
 *         line 21: 20
 *         line 23: 24
 *         line 24: 32
 *         line 25: 36
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      37     0  args   [Ljava/lang/String;
 *             8      29     1 apple   Lcom/xima/jvm/practice/stage2_bytecode/Fruit;
 *            16      21     2 orange   Lcom/xima/jvm/practice/stage2_bytecode/Fruit;
 *
 *
 *
 */
public class MyTest6_invokevirtual操作_方法的动态分派 {

    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }
}

class Fruit {

    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {

    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {

    @Override
    public void test() {
        System.out.println("Orange");
    }
}
