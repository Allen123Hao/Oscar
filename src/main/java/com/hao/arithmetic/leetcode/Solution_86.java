package com.hao.arithmetic.leetcode;

/**
 * <code>Solution_86</code>
 *
 * @description:
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2021-01-11
 * @version: 1.0
 */
public class Solution_86 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int[] arr) {
            if (arr == null || arr.length == 0)
                throw new IllegalArgumentException("arr can to be empty");
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                res.append(cur.val + "->");
                cur = cur.next;
            }
            res.append("NULL");
            return res.toString();
        }
    }

    static ListNode partition(ListNode head, int x){
        //当链表为空或者链表中只有一个节点的时候，直接返回
        if (head == null || head.next == null)
            return head;
        //给当前的链表一个虚拟表头结点，在后续就可以不用判断节点是不是表头结点这个特殊情况
        ListNode tempHead = new ListNode(0);
        //新建一个存放比给定值小的链表的虚拟头结点
        ListNode minHead = new ListNode(0);
        tempHead.next = head;
        //p表示的是当前遍历的节点，pre是当前遍历节点的前一个节点，因为要删除，所以需要知道前一个节点
        //t是存放比给定值小的链表的尾节点
        ListNode p, pre = tempHead, t = minHead;
        for (p = head; p != null; ) {
            //当前值小于给定值
            if (p.val < x) {
                //删除当前值
                pre.next = p.next;
                p.next = null;
                //将其插入存放小值的链表的末尾
                t.next = p;
                t = t.next;
                //删除之后，p的位置是pre后面的位置
                p=pre.next;
            } else {
                //p和pre的位置也向后移
                pre=p;
                p = p.next;
            }
        }
        t.next = tempHead.next;
        return minHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5, 2};
        ListNode head = new ListNode(arr);
        head = partition(head, 3);
        System.out.println(head.toString());
    }
}
