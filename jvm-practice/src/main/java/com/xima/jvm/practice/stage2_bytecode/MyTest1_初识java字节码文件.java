package com.xima.jvm.practice.stage2_bytecode;

/**
 *  1.使用javap -verbose命令分析一个字节码文件时，将会分析该字节码文件的魔数、版本号、常量池、类信息、类的构造方法、类中的方法信息、类变量与成员变量等信息
 *  2.魔数：所有的.class字节码文件的前4个字节都是魔数，魔数值为固定值：0xCAFEBABE
 *  3.魔数之后的4个字节为版本信息，前两个字节表示minor version（次版本号），后两个自己表示major version（主版本号）。
 *  这里的版本号为 00 00 00 37，换算成十进制，表示此版本号为0，主版本号为55。所以，该文件的版本号为：11 , 可以通过java -version命令来验证这一点。
 *  4.常量池（constant pool）：紧接着主版本号之后的就是常量池入口，一个java类中定义的很多信息就是由常量池来维护和描述的，可以将常量池看做是CLass文件的资源
 *  仓库，比如说java类中定义的方法和变量信息，都是存储在常量池中。常量池中主要存储两类常量：字面量与符号引用。字面量如文本字符串，java中声明为final的常量值等。
 *  而符号引用如类和接口的全局限定名，字段的名称和描述符，方法的名称和描述符等。
 *  5.常量池的总体结构：java类所对应的常量池主要由常量池数量与常量池数组这两部分共同构成。长安凌迟数量紧跟在主板本后面，占据2个字节；常量池数组则紧跟在常量池数量之后，
 *  常量池数组与一般的数组不同的是，常量池数组中不同的元素的类型、结构都是不同的，长度当然也就不同；但是，每一种元素的第一个数据都是u1类型，该字节是个标志位，
 *  占据1个字节，JVM在解析常量池时，会根据这个u1类型来获取元素的具体类型。`值得注意的是，常量池中元素的个数=常量池数-1（其中0暂时不使用）`,目的是满足某些常量池索引值
 *  的数据在特定情况下需要表达「不引用任何一个常量池」的含义；根本原因在于，引用为0也是一个常量（保留常量），只不过它部位与常量表中，这个常量就对应null值；所以常量池的索引从1而非0开始
 *
 *
 *  实验一：查看class文件的助记码
 *  操作：
 *  1.进入classpath
 *  2.javap -p -v com.xima.jvm.practice.stage2_bytecode.MyTest1_初识java字节码文件
 *
 *  result===========================
 *  Classfile /Users/xmly/practice/code/vince-practice/jvm-practice/target/classes/com/xima/jvm/practice/stage2_bytecode/MyTest1_初识java字节码文件.class
 *   Last modified 2020年7月7日; size 590 bytes
 *   MD5 checksum 1f97cb2571fcfc73d04ada8e0a1389cb
 *   Compiled from "MyTest1_初识java字节码文件.java"
 * public class com.xima.jvm.practice.stage2_bytecode.MyTest1_初识java字节码文件
 *   minor version: 0
 *   major version: 55
 *   flags: (0x0021) ACC_PUBLIC, ACC_SUPER
 *   this_class: #3                          // com/xima/jvm/practice/stage2_bytecode/MyTest1_初识java字节码文件
 *   super_class: #4                         // java/lang/Object
 *   interfaces: 0, fields: 1, methods: 3, attributes: 1
 * Constant pool:
 *    #1 = Methodref          #4.#20         // java/lang/Object."<init>":()V
 *    #2 = Fieldref           #3.#21         // com/xima/jvm/practice/stage2_bytecode/MyTest1_初识java字节码文件.i:I
 *    #3 = Class              #22            // com/xima/jvm/practice/stage2_bytecode/MyTest1_初识java字节码文件
 *    #4 = Class              #23            // java/lang/Object
 *    #5 = Utf8               i
 *    #6 = Utf8               I
 *    #7 = Utf8               <init>
 *    #8 = Utf8               ()V
 *    #9 = Utf8               Code
 *   #10 = Utf8               LineNumberTable
 *   #11 = Utf8               LocalVariableTable
 *   #12 = Utf8               this
 *   #13 = Utf8               Lcom/xima/jvm/practice/stage2_bytecode/MyTest1_初识java字节码文件;
 *   #14 = Utf8               getI
 *   #15 = Utf8               ()I
 *   #16 = Utf8               setI
 *   #17 = Utf8               (I)V
 *   #18 = Utf8               SourceFile
 *   #19 = Utf8               MyTest1_初识java字节码文件.java
 *   #20 = NameAndType        #7:#8          // "<init>":()V
 *   #21 = NameAndType        #5:#6          // i:I
 *   #22 = Utf8               com/xima/jvm/practice/stage2_bytecode/MyTest1_初识java字节码文件
 *   #23 = Utf8               java/lang/Object
 * {
 *   private int i;
 *     descriptor: I
 *     flags: (0x0002) ACC_PRIVATE
 *
 *   public com.xima.jvm.practice.stage2_bytecode.MyTest1_初识java字节码文件();
 *     descriptor: ()V
 *     flags: (0x0001) ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 110: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lcom/xima/jvm/practice/stage2_bytecode/MyTest1_初识java字节码文件;
 *
 *   public int getI();
 *     descriptor: ()I
 *     flags: (0x0001) ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: getfield      #2                  // Field i:I
 *          4: ireturn
 *       LineNumberTable:
 *         line 115: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lcom/xima/jvm/practice/stage2_bytecode/MyTest1_初识java字节码文件;
 *
 *   public void setI(int);
 *     descriptor: (I)V
 *     flags: (0x0001) ACC_PUBLIC
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: aload_0
 *          1: iload_1
 *          2: putfield      #2                  // Field i:I
 *          5: return
 *       LineNumberTable:
 *         line 119: 0
 *         line 120: 5
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       6     0  this   Lcom/xima/jvm/practice/stage2_bytecode/MyTest1_初识java字节码文件;
 *             0       6     1     i   I
 * }
 * SourceFile: "MyTest1_初识java字节码文件.java"
 *
 *
 *
 *
 * 实验二：查看class文件的二进制文件
 * mac推荐工具： Hex Fiend
 * 打开class文件，显示如下：
 *
 * CAFEBABE 00000037 00180A00 04001409 00030015 07001607 00170100 01690100 01490100 063C696E 69743E01 00032829 56010004 436F6465 01000F4C 696E654E 756D6265 72546162 6C650100 124C6F63 616C5661 72696162 6C655461 626C6501 00047468 69730100 324C636F 6D2F7869 6D612F6A 766D2F70 72616374 6963652F 73746167 65325F62 79746563 6F64652F 48656C6C 6F576F72 6C643B01 00046765 74490100 03282949 01000473 65744901 00042849 29560100 0A536F75 72636546 696C6501 000F4865 6C6C6F57 6F726C64 2E6A6176 610C0007 00080C00 05000601 0030636F 6D2F7869 6D612F6A 766D2F70 72616374 6963652F 73746167 65325F62 79746563 6F64652F 48656C6C 6F576F72 6C640100 106A6176 612F6C61 6E672F4F 626A6563 74002100 03000400 00000100 02000500 06000000 03000100 07000800 01000900 00002F00 01000100 0000052A B70001B1 00000002 000A0000 00060001 00000003 000B0000 000C0001 00000005 000C000D 00000001 000E000F 00010009 0000002F 00010001 00000005 2AB40002 AC000000 02000A00 00000600 01000000 08000B00 00000C00 01000000 05000C00 0D000000 01001000 11000100 09000000 3E000200 02000000 062A1BB5 0002B100 00000200 0A000000 0A000200 00000C00 05000D00 0B000000 16000200 00000600 0C000D00 00000000 06000500 06000100 01001200 00000200 13
 */
public class MyTest1_初识java字节码文件 {

    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
