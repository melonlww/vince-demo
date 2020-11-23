package com.xima.data_structure.stack;

//基于数组实现的顺序栈
public class ArrayStack {
    private String[] items; // 数组
    private int count; // 栈中元素个数
    private int n; //栈的大小

    public ArrayStack(int num){
        this.n = num;
        items = new String[num];
    }

    public String pop(){
        if(count == 0){
            return null;
        }
        return items[--count];
    }

    public boolean push(String data){
        if(count == n){
            return false;
        }
        items[count++] = data;
        return true;
    }




    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());


    }

}
