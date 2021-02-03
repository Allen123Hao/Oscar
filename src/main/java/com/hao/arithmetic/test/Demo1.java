package com.hao.arithmetic.test;

import com.hao.arithmetic.LinkedNode;
import com.hao.arithmetic.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <code>Demo1</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2021-01-13
 * @version: 1.0
 */
public class Demo1 {

    public int calStep(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return calStep(n-1)+calStep(n-2);
    }

    int s;

    int[] steps = new int[s];

    int idx;

    int sum;

    public void calSteps(int s){
        if(s < 0){
            return;
        }
        if(s == 0){
            sum++;
            printSteps();
            return;
        }
        for(int t=1;t<=2;t++){
            steps[idx] = t;
            idx++;
            calStep(s-t);
            idx--;
        }

    }

    private void printSteps(){
        for(int i=0;i<idx;i++){
            System.out.print(steps[i]+" ");
        }
        System.out.println();
    }


    public int binaryFind(int[] arr,int t){
        int left = 0;
        int right = arr.length-1;
        int mid;
        while(left < right){
//            mid = (left+right)/2;
            mid = left + (right-left)/2;
            if(arr[mid] == t){
                return mid;
            }
            if(arr[mid] > t){
                right = mid-1;
            }
            if(arr[mid] < t){
                left = mid+1;
            }
        }
        return -1;
    }

    /**
     * 层次遍历二叉树
     * @param rootNode
     */
    public void levelTraverse(TreeNode rootNode){
        if(rootNode == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.left != null){
                queue.add(node.left);
            }
        }
    }


    /**
     * 链表翻转
     * @param head
     * @return
     */
    public LinkedNode reverse(LinkedNode head){
        LinkedNode pre;
        LinkedNode cur;
        if(head == null || head.next == null){
            return head;
        }
        cur = head;
        pre = null;
        while(cur != null){
            // 暂存后继节点 cur.next
            LinkedNode tem = cur.next;
            //修改 next 引用指向
            cur.next = pre;
            //pre 暂存 cur
            pre = cur;
            //cur 访问下一节点
            cur = tem;
        }
        return pre;
    }


}
