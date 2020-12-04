package com.xima.thread.practice.thread_demo.dead_lock;

public class TransferMoney_避免死锁 implements Runnable {
    int flag;
    static Account a = new Account(500);
    static Account b = new Account(500);

    static class Account {
        public Account(int balance) {
            this.balance = balance;
        }

        int balance;
    }

    @Override
    public void run() {
        if (flag == 1) {
            transferMoney(a, b, 200);
        }
        if (flag == 0) {
            transferMoney(b, a, 200);
        }
    }

    /**
     * 快速先获取两把锁, 每个锁的持有时间很短，同时释放也很快
     * @param from
     * @param to
     * @param amount
     */
    public static void transferMoney(Account from, Account to, int amount) {
        //先获取两把锁，然后开始转账
        synchronized (to) {
            synchronized (from) {
                if (from.balance - amount < 0) {
                    System.out.println("余额不足，转账失败。");
                    return;
                }
                from.balance -= amount;
                to.balance += amount;
                System.out.println("成功转账" + amount + "元");
            }
        }
    }

    /**
     * 加了 Thread.sleep(500); 很大概率会发生死锁
     * @param from
     * @param to
     * @param amount
     */
    public static void transferMoney2(Account from, Account to, int amount) {
        //先获取两把锁，然后开始转账
        synchronized (to) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (from) {
                if (from.balance - amount < 0) {
                    System.out.println("余额不足，转账失败。");
                    return;
                }
                from.balance -= amount;
                to.balance += amount;
                System.out.println("成功转账" + amount + "元");
            }
        }
    }

    /**
     * 使用HashCode 的值来决定获得锁顺序，避免 两个不同的线程获取两个锁的顺序是相反的
     * @param from
     * @param to
     * @param amount
     */
    public static void transferMoney3(Account from, Account to, int amount) {
        int fromHash = System.identityHashCode(from);
        int toHash = System.identityHashCode(to);
        if (fromHash < toHash) {
            synchronized (from) {
                synchronized (to) {
                    if (from.balance - amount < 0) {
                        System.out.println("余额不足，转账失败。");
                        return;
                    }
                    from.balance -= amount;
                    to.balance += amount;
                    System.out.println("成功转账" + amount + "元");
                }
            }
        } else if (fromHash > toHash) {
            synchronized (to) {
                synchronized (from) {
                    if (from.balance - amount < 0) {
                        System.out.println("余额不足，转账失败。");
                        return;
                    }
                    from.balance -= amount;
                    to.balance += amount;
                    System.out.println("成功转账" + amount + "元");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TransferMoney_避免死锁 r1 = new TransferMoney_避免死锁();
        TransferMoney_避免死锁 r2 = new TransferMoney_避免死锁();
        r1.flag = 1;
        r2.flag = 0;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("a的余额" + a.balance);
        System.out.println("b的余额" + b.balance);
    }
}