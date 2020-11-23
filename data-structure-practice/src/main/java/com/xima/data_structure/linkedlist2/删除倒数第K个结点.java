package com.xima.data_structure.linkedlist2;

public class 删除倒数第K个结点 {

    private Node head = null;
    
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
    
    public Node deleteLastKth(int k) {
        Node fast = head;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) return head;

        Node slow = head;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }
        return head;
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
        删除倒数第K个结点 delete = new 删除倒数第K个结点();
        String[] data = {"1","2","3","2","5"};
        for(int i =0 ;i<data.length;i++){
            delete.insertTail(data[i]);
        }
        delete.printAll();

        delete.deleteLastKth(2);
        delete.printAll();
    }


}

