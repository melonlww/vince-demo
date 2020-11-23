package com.xima.data_structure.stack;

//基于数组实现的顺序栈
public class ArrayStackWithExpansion {
    private String[] items; // 数组
    private int count; // 栈中元素个数
    private int n; //栈的大小

    public ArrayStackWithExpansion(int num){
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
            expansion();
        }
        items[count++] = data;
        return true;
    }


    private void expansion(){
        int newSize = n * 2;
        String[] newItems = new String[newSize];
        for(int i = 0 ;i< n;i++){
            newItems[i] = items[i];
        }
        n = newSize;
        items = newItems;
    }



    public static void main(String[] args) {
        ArrayStackWithExpansion arrayStack = new ArrayStackWithExpansion(5);
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");
        arrayStack.push("5");
        arrayStack.push("6");
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());


    }

}
