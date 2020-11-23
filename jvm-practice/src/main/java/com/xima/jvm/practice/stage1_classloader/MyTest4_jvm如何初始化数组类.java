package com.xima.jvm.practice.stage1_classloader;

/**
 * test1 首次主动使用的时候会初始化
 * test2 对于数组实例来说，其类型是由jvm在运行期间动态生成的，表示为[Lcom.xima.jvm.practice.stage1_classloader.MyParent4
 * 这种形式，动态生成的类型，其父类型就是Object
 * 对于数组来说，javadoc经常将构成数组的元素为Component，实际上就是将数组降低一个维度后的类型
 *
 *
 * javap -c com.xima.jvm.practice.stage1_classloader.MyTest4
 * ==============result=================
 *  Code:
 *        0: iconst_1
 *        1: anewarray     #2                  // class com/xima/jvm/practice/stage1_classloader/MyParent4
 * ...
 *        7: multianewarray #3,  2             // class "[[Lcom/xima/jvm/practice/stage1_classloader/MyParent4;"
 * ...
 *       74: iconst_1
 *       75: newarray       int
 *       77: astore_3
 *
 * 助记符：anewarray
 *  表示创建一个引用类型的（如类，接口，数组）数组，并将其引用值压入栈顶
 * 助记符：newarray
 *  表示创建一个指定的原始类型（如int，float，char等）的数组，并将其引用值压入栈顶
 */
public class MyTest4_jvm如何初始化数组类 {

    public static void main(String[] args) {
        //test1
//        MyParent4 myParent = new MyParent4();
//        System.out.println("================");
//        MyParent4 test = new MyParent4();

        //test2
        MyParent4[] myParent4s = new MyParent4[1];
        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s1.getClass());

        System.out.println(myParent4s.getClass().getSuperclass());
        System.out.println(myParent4s1.getClass().getSuperclass());
        System.out.println(MyParent4.class);
        System.out.println("================");

        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());



    }
}

class MyParent4{
    static{
        System.out.println("MyParent4 static code");
    }
}
