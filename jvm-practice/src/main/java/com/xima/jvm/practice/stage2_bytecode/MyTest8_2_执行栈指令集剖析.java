package com.xima.jvm.practice.stage2_bytecode;

/**
 * 查看执行指令，了解操作步骤
 *
 * 关注myCalculate()方法
 *  0 iconst_4  //int型常量值4进栈（操作数）
 *  1 istore_1  //将栈顶int型数值存入index1局部变量 a=4
 *  2 iconst_3  //int型常量值3进栈（操作数）
 *  3 istore_2  //将栈顶int型数值存入index2局部变量 b=3
 *  4 iconst_2  //int型常量值2进栈（操作数）
 *  5 istore_3  //将栈顶int型数值存入index3局部变量 c=2
 *  6 iconst_1  //int型常量值1进栈（操作数）
 *  7 istore 4  //将栈顶int型数值存入index4局部变量 d=1
 *  9 iload_1  //index1 int型局部变量进栈
 *  10 iload_2  //index2 int型局部变量进栈
 *  11 iadd     //将栈顶index2，栈顶后一个index1弹出栈执行加法操作，再讲结果进栈，先称为x1
 *  12 iload_3  //index3 int型局部变量进栈
 *  13 isub     //将栈顶index3和栈顶后一个x1弹出栈执行减法操作，再讲结果进栈，先称为x2
 *  14 iload 4  //index4 int型局部变量进栈
 *  16 imul  //将栈顶index4和栈顶后一个x2弹出栈执行乘法操作，再讲结果进栈，先称为x3
 *  17 istore 5 //将栈顶int型数值x3弹出，并存入index5局部变量 result
 *  19 iload 5 //index5 int型局部变量进栈
 *  21 ireturn //将栈顶元素返回
 *
 */
public class MyTest8_2_执行栈指令集剖析 {

    public int myCalculate() {
        int a = 4;
        int b = 3;
        int c = 2;
        int d = 1;

        int result = (a + b - c) * d;

        return result;
    }

    public static void main(String[] args) {
        MyTest8_2_执行栈指令集剖析 myTest8 = new MyTest8_2_执行栈指令集剖析();
        System.out.println(myTest8.myCalculate());
    }
}
