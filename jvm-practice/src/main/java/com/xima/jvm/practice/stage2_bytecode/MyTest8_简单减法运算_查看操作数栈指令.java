package com.xima.jvm.practice.stage2_bytecode;

/**
 *
 * 1.iconst_1 //将数字1压到（操作数）栈顶
 * 2.iconst_2 //将数字2压到（操作数）栈顶
 * 3.isub    //将栈顶连续两个数弹出，将栈顶的数字减去栈顶下面那个数字，将相减的结果再压到栈顶
 * 4.istore_3  //将栈顶的元素放置到局部变量表的第3个slot中

 *
 *
 */
public class MyTest8_简单减法运算_查看操作数栈指令 {

    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        int x = i -j;
    }
}
