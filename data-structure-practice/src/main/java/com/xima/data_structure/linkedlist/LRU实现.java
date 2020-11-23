package com.xima.data_structure.linkedlist;

public class LRU实现 {

    public static class Node{
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }

    private int num;
    private int count;
    private Node head;

    public LRU实现(int num) {
        this.num = num;
    }


    public boolean query(String data){
        Node d = get(data);
        if(d==null){
            return false;
        }else if(d == head){
            return true;
        }
        d.next = head;
        head = d;
        return true;
    }


    private Node get(String data){
        Node pre = null;
        Node cur = head;
        while(cur!=null){
            if(cur.data.equals(data)){
                if(pre != null){
                    pre.next = cur.next;
                    cur.next = null;
                }
                return cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return null;
    }

    public void insert(String data){
        if(count == num){
            delete();
        }
        count++;
        Node c = head;
        Node newNode = new Node(data,c);
        head = newNode;
    }

    private Node delete(){
        Node pre = null;
        Node cur = head;
        while(cur.next!=null){
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        count--;
        return cur;
    }

    public void printAll(){
        System.out.println("=============打印===============");
        Node q = head;
        while(q!= null){
            System.out.print(q.getData()+ "");
            q = q.next;
        }
        System.out.println("");
    }



    public static void main(String[] args) {
        LRU实现 lurDemo = new LRU实现(5);
        lurDemo.insert("1");
        lurDemo.insert("2");
        lurDemo.insert("3");
        lurDemo.insert("4");
        lurDemo.insert("5");
        lurDemo.insert("6");
        lurDemo.printAll();

        boolean result = lurDemo.query("2");
        System.out.println(result);
        lurDemo.printAll();
    }




}
