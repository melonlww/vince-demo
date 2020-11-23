package com.xima.jvm.practice.stage2_bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 *
 * ## 方法局部变量表
 * 对于java类中的每一个实例方法（非static方法），其在编译后所生成的字节码当中，方法参数的数量总是会比源代码中方法
 *  参数的数量多一个（this），它位于方法的第一参数位置处；这样，我们就可以再java的实例方法中使用this来访问当前
 *  对象的属性以及其他方法。
 *
 *  这个操作是在编译期间完成的，即由javac编译器在编译的时候将对this的访问转化为对一个普通实例方法参数的访问；接下来在运行期间，
 *  由jvm在调用实例方法时，自动向实例方法传入该this参数。所以，在实例方法的局部变量表中，至少会有一个指向当前对象的局部变量。
 *
 * ## java字节码对异常的处理方式
 * 1.统一采用异常表的方式来对异常进行处理
 * 2.在jdk 1.4.2之前的版本中，并不是使用异常表的方式来对异常进行处理的，而是采用特定的指令方式
 * 3.当异常处理存在finally语句块时，现代化的jvm采取的处理方式是将finally语句块的字节码拼接到每一个流程后面（正常流程和每个catch块后面），
 *   换句话说，程序中存在多少个（n）catch块，就会在每一个catch块后面重复多少（n+2，1.正常流程 2.异常表any异常，3每个catch块各一个）个finally语句块的字节码
 *
 *
 *  实验一：方法局部变量表
 *   操作：
 *   1.进入classpath
 *   2.javap生成字节码  -p打印private的字段和方法
 *   javap -p -v classes.com.xima.jvm.practice.stage2_bytecode.MyTest3_方法局部变量表与异常表
 *
 *   其他忽略 主要关注test方法
 *   *局部变量表 stack=3, locals=4, args_size=1
 *
 *
 *     public void test();
 *     descriptor: ()V
 *     flags: (0x0001) ACC_PUBLIC
 *     Code:
 *       stack=3, locals=4, args_size=1
 *          0: new           #2                  // class java/io/FileInputStream
 *          3: dup
 *          4: ldc           #3                  // String test.txt
 *          6: invokespecial #4                  // Method java/io/FileInputStream."<init>":(Ljava/lang/String;)V
 *          9: astore_1
 *         10: new           #5                  // class java/net/ServerSocket
 *         13: dup
 *         14: sipush        9999
 *         17: invokespecial #6                  // Method java/net/ServerSocket."<init>":(I)V
 *         20: astore_2
 *         21: aload_2
 *         22: invokevirtual #7                  // Method java/net/ServerSocket.accept:()Ljava/net/Socket;
 *         25: pop
 *         26: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         29: ldc           #9                  // String finally
 *         31: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         34: goto          84
 *         37: astore_1
 *         38: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         41: ldc           #9                  // String finally
 *         43: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         46: goto          84
 *         49: astore_1
 *         50: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         53: ldc           #9                  // String finally
 *         55: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         58: goto          84
 *         61: astore_1
 *         62: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         65: ldc           #9                  // String finally
 *         67: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         70: goto          84
 *         73: astore_3
 *         74: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         77: ldc           #9                  // String finally
 *         79: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         82: aload_3
 *         83: athrow
 *         84: return
 *       Exception table:
 *          from    to  target type
 *              0    26    37   Class java/io/FileNotFoundException
 *              0    26    49   Class java/io/IOException
 *              0    26    61   Class java/lang/Exception
 *              0    26    73   any
 *       LineNumberTable:
 *         line 13: 0
 *         line 15: 10
 *         line 16: 21
 *         line 24: 26
 *         line 25: 34
 *         line 17: 37
 *         line 24: 38
 *         line 25: 46
 *         line 19: 49
 *         line 24: 50
 *         line 25: 58
 *         line 21: 61
 *         line 24: 62
 *         line 25: 70
 *         line 24: 73
 *         line 25: 82
 *         line 26: 84
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *            10      16     1    is   Ljava/io/InputStream;
 *            21       5     2 serverSocket   Ljava/net/ServerSocket;
 *             0      85     0  this   Lcom/xima/jvm/practice/stage2_bytecode/MyTest3_方法局部变量表与异常表;
 *       StackMapTable: number_of_entries = 5
 *         frame_type = 101 \/* same_locals_1_stack_item *\/
 *          stack=[

            class java/io/FileNotFoundException]
                    *frame_type=75 \/* same_locals_1_stack_item *\/
                    *stack=[

            class java/io/IOException]
                    *frame_type=75 \/* same_locals_1_stack_item *\/
                    *stack=[

            class java/lang/Exception]
                    *frame_type=75 \/* same_locals_1_stack_item *\/
                    *stack=[

            class java/lang/Throwable]
                    *frame_type=10 \/* same *\/
 *
 */
public class MyTest3_方法局部变量表与异常表 {

    public void test(){
        try{
            InputStream is = new FileInputStream("test.txt");

            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (Exception e) {

        } finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {
        MyTest3_方法局部变量表与异常表 myTest3 = new MyTest3_方法局部变量表与异常表();
        myTest3.test();
    }

}
