package com.xima.jvm.practice.stage2_bytecode;

/**
 * 实验一：不加synchronized关键字生成字节码
 *  操作：
 *  1.进入classpath
 *  2.javap生成字节码  -p打印private的字段和方法
 *  javap -p -v classes.com.xima.jvm.practice.stage2_bytecode.MyTest2_synchronized关键字字节码
 *
 *  其他忽略 主要关注setX方法
 *  public void setX(int);
 *     descriptor: (I)V
 *     flags: (0x0001) ACC_PUBLIC
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: aload_0
 *          1: iload_1
 *          2: putfield      #4                  // Field x:I
 *          5: return
 *       LineNumberTable:
 *         line 21: 0
 *         line 22: 5
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       6     0  this   Lcom/xima/jvm/practice/stage2_bytecode/MyTest2_synchronized关键字字节码;
 *             0       6     1     x   I
 *
 *
 * 实验二：加synchronized关键字生成字节码
 *  操作：
 *  1.进入classpath
 *  2.javap生成字节码  -p打印private的字段和方法
 *  javap -p -v classes.com.xima.jvm.practice.stage2_bytecode.MyTest2_synchronized关键字字节码
 *
 *  其他忽略 主要关注setX方法，比实验一多了ACC_SYNCHRONIZED
 *
 *    public synchronized void setX(int);
 *     descriptor: (I)V
 *     flags: (0x0021) ACC_PUBLIC, ACC_SYNCHRONIZED
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: aload_0
 *          1: iload_1
 *          2: putfield      #4                  // Field x:I
 *          5: return
 *       LineNumberTable:
 *         line 58: 0
 *         line 59: 5
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       6     0  this   Lcom/xima/jvm/practice/stage2_bytecode/MyTest2_synchronized关键字字节码;
 *             0       6     1     x   I
 *
 * 实验三：synchronized代码块生成字节码
 * 操作：
 *  1.进入classpath
 *  2.javap生成字节码  -p打印private的字段和方法
 *  javap -p -v com.xima.jvm.practice.stage2_bytecode.MyTest2_synchronized关键字字节码

    其他忽略 主要关注test方法 有monitorenter，monitorexit关键字

    private void test(java.lang.String);
         descriptor: (Ljava/lang/String;)V
         flags: (0x0002) ACC_PRIVATE
         Code:
             stack=2, locals=4, args_size=2
             0: aload_0
             1: getfield      #6                  // Field obj:Ljava/lang/Object;
             4: dup
             5: astore_2
             6: monitorenter
             7: getstatic     #12                 // Field java/lang/System.out:Ljava/io/PrintStream;
             10: ldc           #14                 // String hello world
             12: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
             15: aload_2
             16: monitorexit
             17: goto          25
             20: astore_3
             21: aload_2
             22: monitorexit
             23: aload_3
             24: athrow
             25: return
         Exception table:
             from    to  target type
             7    17    20   any
             20    23    20   any
         LineNumberTable:
             line 85: 0
             line 86: 7
             line 87: 15
             line 88: 25
         LocalVariableTable:
             Start  Length  Slot  Name   Signature
                 0      26     0  this   Lcom/xima/jvm/practice/stage2_bytecode/MyTest2_synchronized关键字字节码;
                 0      26     1   str   Ljava/lang/String;
         StackMapTable: number_of_entries = 2
            frame_type = 255
                offset_delta = 20
                locals = [ class com/xima/jvm/practice/stage2_bytecode/MyTest2_synchronized关键字字节码, class java/lang/Strlass java/lang/Object ]
                stack = [ class java/lang/Throwable ]
            frame_type = 250
                offset_delta = 4

 * 实验四：
 * 操作：
 *  1.进入classpath
 *  2.javap生成字节码  -p打印private的字段和方法
 *  javap -p -v com.xima.jvm.practice.stage2_bytecode.MyTest2_synchronized关键字字节码
 *
 *   其他忽略 主要关注test2方法，当synchronized修饰的是一个静态方法synchronized是给`MyTest2_synchronized关键字字节码`所对应的class对象上锁
 *
     private static synchronized void test2();
         descriptor: ()V
         flags: (0x002a) ACC_PRIVATE, ACC_STATIC, ACC_SYNCHRONIZED
         Code:
            stack=0, locals=0, args_size=0
                0: return
            LineNumberTable:
                line 139: 0

 * 实验五：生成<init>构造函数字节码
 * 操作：
 *  1.进入classpath
 *  2.javap生成字节码  -p打印private的字段和方法
 *  javap -p -v com.xima.jvm.practice.stage2_bytecode.MyTest2_synchronized关键字字节码
 *
 * 其他忽略，主要关注init方法，
 * 此时重载定义了两个构造方法，jvm字节码会生成两个init方法，两个方法的字节码中都会将类成员变量的初始化放在构造方法（    String str = "Welcome"; private int x = 5;）
 *
 *   public com.xima.jvm.practice.stage2_bytecode.MyTest2_synchronized关键字字节码();
 *     descriptor: ()V
 *     flags: (0x0001) ACC_PUBLIC
 *     Code:
 *       stack=3, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: aload_0
 *          5: ldc           #2                  // String Welcome
 *          7: putfield      #3                  // Field str:Ljava/lang/String;
 *         10: aload_0
 *         11: iconst_5
 *         12: putfield      #4                  // Field x:I
 *         15: aload_0
 *         16: new           #5                  // class java/lang/Object
 *         19: dup
 *         20: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *         23: putfield      #6                  // Field obj:Ljava/lang/Object;
 *         26: return
 *       LineNumberTable:
 *         line 133: 0
 *         line 125: 4
 *         line 127: 10
 *         line 131: 15
 *         line 135: 26
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      27     0  this   Lcom/xima/jvm/practice/stage2_bytecode/MyTest2_synchronized关键字字节码;
 *
 *   public com.xima.jvm.practice.stage2_bytecode.MyTest2_synchronized关键字字节码(int);
 *     descriptor: (I)V
 *     flags: (0x0001) ACC_PUBLIC
 *     Code:
 *       stack=3, locals=2, args_size=2
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: aload_0
 *          5: ldc           #2                  // String Welcome
 *          7: putfield      #3                  // Field str:Ljava/lang/String;
 *         10: aload_0
 *         11: iconst_5
 *         12: putfield      #4                  // Field x:I
 *         15: aload_0
 *         16: new           #5                  // class java/lang/Object
 *         19: dup
 *         20: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *         23: putfield      #6                  // Field obj:Ljava/lang/Object;
 *         26: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         29: ldc           #8                  // String aaaa
 *         31: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         34: return
 *       LineNumberTable:
 *         line 137: 0
 *         line 125: 4
 *         line 127: 10
 *         line 131: 15
 *         line 138: 26
 *         line 139: 34
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      35     0  this   Lcom/xima/jvm/practice/stage2_bytecode/MyTest2_synchronized关键字字节码;
 *             0      35     1     i   I


 * 实验六：生成<clinit>静态构造函数字节码
 * 操作：
 *  1.进入classpath
 *  2.javap生成字节码  -p打印private的字段和方法
 *  javap -p -v com.xima.jvm.practice.stage2_bytecode.MyTest2_synchronized关键字字节码
 *
 *   其他忽略，主要关注clinit方法，
 *   类中若有静态成员变量或者静态代码块，jvm会生成clinit方法的字节码，静态成员和静态代码块的初始化会在clinit方法字节码中按定义顺序依次执行（public static Integer in = 10;  static{ System.out.println("test static block");}  ）
 *
 *
 *  static {};
 *     descriptor: ()V
 *     flags: (0x0008) ACC_STATIC
 *     Code:
 *       stack=2, locals=0, args_size=0
 *          0: bipush        10
 *          2: invokestatic  #13                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
 *          5: putstatic     #14                 // Field in:Ljava/lang/Integer;
 *          8: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         11: ldc           #16                 // String test static block
 *         13: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         16: return
 *       LineNumberTable:
 *         line 129: 0
 *         line 148: 8
 *         line 149: 16
 *
 *
*/
public class MyTest2_synchronized关键字字节码 {

    String str = "Welcome";

    private int x = 5;

    public static Integer in = 10;

    private Object obj = new Object();

    // 实验五：生成<init>构造函数字节码
    public MyTest2_synchronized关键字字节码(){

    }

    public MyTest2_synchronized关键字字节码(int i){
        System.out.println("aaaa");
    }

    public static void main(String[] args) {
        MyTest2_synchronized关键字字节码 myTest2 = new MyTest2_synchronized关键字字节码();
        myTest2.setX(8);
        in = 10;
    }
    // 实验六：生成<clinit>静态构造函数字节码
    static{
        System.out.println("test static block");
    }

// 实验一：不加synchronized关键字生成字节码
//    public void setX(int x){
// 实验二：加synchronized关键字生成字节码
    public synchronized void setX(int x){
        this.x = x;
    }

// 实验三：synchronized代码块生成字节码
    private void test(String str){
        synchronized (this.obj){
            System.out.println("hello world");
        }
    }

// 实验四：synchronized修饰静态方法
    private synchronized static void test2(){

    }



}
