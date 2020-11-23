package com.xima.loader;

/**
 * 顺序加载
 * 总耗时 1s + 2s + 3s = 6s
 */
public class SerialDataLoader extends DataLoader {

    protected void doLoad() { // 串行计算
        int i = super.loadConfigurations(); // 耗时 1s
        i = super.loadUsers(i); // 耗时 2s
        i = super.loadOrders(i); // 耗时 3s
        System.out.println(i);
    }


    public static void main(String[] args) {
        new SerialDataLoader().load();
    }
}
