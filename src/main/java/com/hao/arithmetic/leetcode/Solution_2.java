package com.hao.arithmetic.leetcode;

import com.hao.arithmetic.ListNode;

/**
 * <code>Solution_2</code>
 *
 * @description:
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2021-01-25
 * @version: 1.0
 */
public class Solution_2 {

    public static ListNode createListNode(int[] arr){
        ListNode l = new ListNode(0);
        ListNode temp = l;
        for(int i=0;i<arr.length;i++){
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return l.next;
    }

    public static void print(ListNode l){
        while(l.next != null){
            System.out.print(l.val + "->");
            l = l.next;
        }
        System.out.print(l.val);
        System.out.println();
    }

    public static ListNode mergeListNode(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        //虚拟一个结果的头结点
        ListNode l3 = new ListNode(0,null);
        ListNode curNode = l3;
        //表示需要进位的值
        int add = 0;
        while(true){
            if(cur1 == null && cur2 == null){
                if(add > 0){
                    ListNode tempNode = new ListNode(add,null);
                    curNode.next = tempNode;
                }
                break;
            }
            int curSum = 0;
            if(cur1 != null ){
                curSum += cur1.val;
                cur1 = cur1.next;
            }
            if(cur2 != null){
                curSum += cur2.val;
                cur2 = cur2.next;
            }
            curSum += add;
            int val = curSum % 10;
            add = curSum/10;
            ListNode tempNode = new ListNode(val,null);
            curNode.next = tempNode;
            curNode = curNode.next;
        }
        return l3.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = createListNode(new int[]{2,4,3});
        ListNode l2 = createListNode(new int[]{5,6,4});
        print(l1);
        print(l2);
        ListNode l3 = mergeListNode(l1,l2);
        print(l3);
    }
}
