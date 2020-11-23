package com.xima.data_structure.linkedlist2;

public class 单链表反转 {

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

    private Node head = null;

    /**
     * 翻转
     * @param
     * @return
     */
    public void inverseLinkList(){
        Node pre = null;
        Node current = head;
        while(current!=null){
            Node nextNode = current.next;
            current.next = pre;
            pre = current;
            current = nextNode;
        }
        head = pre;
    }

    /**
     * 链表尾部插入
     * @param value
     */
    public void insertTail(String value){
        Node newNode = new Node(value, null);
        if(head == null){
            head = newNode;
        }else{
            Node q = head;
            while(q.next != null){
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    public void printAll(){
        System.out.println("=============打印===============");
        Node q = head;
        while(q!= null){
            System.out.print(q.getData()+ " ");
            q = q.next;
        }
    }


    public static void main(String[] args) {
        单链表反转 inverse = new 单链表反转();
        String[] data = {"1","2","3","2","5"};
        for(int i =0 ;i<data.length;i++){
            inverse.insertTail(data[i]);
        }
        inverse.printAll();
        inverse.inverseLinkList();
        inverse.printAll();
    }






}
