package com.xima.data_structure.linkedlist;

public class 判断回文 {

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

    /**
     * 翻转
     * @param p
     * @return
     */
    public Node inverseLinkList(Node p){
        Node pre = null;
        Node current = head;
        while(current!=p){
            Node nextNode = current.next;
            current.next = pre;
            pre = current;
            current = nextNode;
        }
        return pre;
    }



    public boolean palindrome() {
        if (head == null) {
            return false;
        } else {
            System.out.println("开始执行找到中间节点");
            Node p = head;
            Node q = head;
            if (p.next == null) {
                System.out.println("只有一个元素");
                return true;
            }
            while (q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;
            }
            System.out.println("中间节点" + p.data);

            Node leftNode;
            Node rightNode;
            if(q.next == null){
                System.out.println("执行奇数回文判断");
                leftNode = inverseLinkList(p);
                rightNode = p.next;
            }else{
                System.out.println("执行偶数回文判断");
                leftNode = inverseLinkList(p.next);
                rightNode = p.next;
            }
            System.out.print("left:");
            printNodeList(leftNode);
            System.out.print("right:");
            printNodeList(rightNode);

            return result(leftNode,rightNode);
        }
    }

    /**
     * 判断是否一致
     * @param left
     * @param right
     * @return
     */
    public boolean result(Node left, Node right) {
        if (left == null || right == null) {
            return false;
        }
        Node l = left;
        Node r = right;

        boolean flag = true;
        while (l != null && r != null) {
            if (l.data.equals(r.data)) {
                l = l.next;
                r = r.next;
                continue;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }


    public void printAll(){
        System.out.println("=============打印===============");
        Node q = head;
        while(q!= null){
            System.out.print(q.getData()+ "");
            q = q.next;
        }
    }

    public void printNodeList(Node node){
        while(node!= null){
            System.out.print(node.getData()+" ");
            node = node.next;
        }
    }


    public static void main(String[] args) {
        判断回文 check = new 判断回文();
//        String[] data = {"1","2","5","3","2"};
//        String[] data = {"1","2","3","4","5"};
        String[] data = {"1","2","3","2","1"};
        for(int i =0 ;i<data.length;i++){
            check.insertTail(data[i]);
        }

        check.printAll();
        boolean result = check.palindrome();
        System.out.println("是否回文:"+ result);
    }
}
