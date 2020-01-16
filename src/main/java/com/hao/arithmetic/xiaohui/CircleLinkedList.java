package com.hao.arithmetic.xiaohui;

import java.util.LinkedList;

/**
 * <code>CircleLinkedList</code>
 *
 * @description: 判断循环链表
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-16
 * @version: 1.0
 */
public class CircleLinkedList {

    public static boolean hasCircle(Node head){

        if(head == null || head.next == null){
            return false;
        }
        Node first = head.next.next;
        Node second = head;

        while(first != second && first!=null && first.next != null){
            first = first.next.next;
            second = second.next;
        }
        if(first == second){
            return true;
        }else{
            return false;
        }

    }

    public static Node initCircleLink(){
        Node node5 = new Node(5);
        Node node3 = new Node(3);
        Node node7 = new Node(7);
        Node node2 = new Node(2);
        Node node6 = new Node(6);
        Node node8 = new Node(8);
        Node node1 = new Node(1);

        node5.next = node3;
        node3.next = node7;
        node7.next = node2;
        node2.next = node6;
        node6.next = node8;
        node8.next = node1;
        node1.next = node2;

        return node7;



    }

    static class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node node = initCircleLink();
        boolean result = hasCircle(node);
        System.out.println(result);
    }
}
