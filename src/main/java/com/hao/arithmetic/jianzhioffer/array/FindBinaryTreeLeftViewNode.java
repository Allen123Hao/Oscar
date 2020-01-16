package com.hao.arithmetic.jianzhioffer.array;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <code>FindBinaryTreeLeftViewNode</code>
 *
 * @description: 查找二叉树左侧能看到节点
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-19
 * @version: 1.0
 */
public class FindBinaryTreeLeftViewNode {

    public static void findFromLeft(Node node){
        if(node == null){
            return;
        }
        Queue<LevelNode> queue = new LinkedBlockingQueue<>();
        int level = 1;
        queue.add(new LevelNode(level,node));
        Set levels = new HashSet();
        while(queue.size() != 0){
            LevelNode levelNode = queue.poll();
            level = levelNode.level;
            Node node1 = levelNode.node;
            if(!levels.contains(level)){
                System.out.println("node:"+node1.value+",level:"+level);
                levels.add(level);
            }
            if(node1.left != null || node1.right != null){
                level++;
            }
            //如果查找从右侧看到的节点，只需先把右侧的放进去
            if(node1.left != null){
                queue.add(new LevelNode(level,node1.left));
            }
            if(node1.right != null){
                queue.add(new LevelNode(level,node1.right));
            }
        }
    }

    /**
     *       A
     *      / \
     *     B   C
     *    /   / \
     *   E   F  G
     *       \
     *       H
     * @return
     */
    public static Node initTree(){
        Node node_h = new Node('H',null,null);
        Node node_e = new Node('E',null,null);
        Node node_f = new Node('F',null,node_h);
        Node node_g = new Node('G',null,null);
        Node node_b = new Node('B',node_e,null);
        Node node_c = new Node('C',node_f,node_g);
        Node node_d = new Node('D',null,null);
        Node node_a = new Node('A',node_b,node_c);
        return node_a;
    }

    static class Node{
        char value;
        Node left;
        Node right;

        Node(char value,Node left,Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static class LevelNode{
        int level;
        Node node;

        LevelNode(int level,Node node){
            this.level = level;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        Node root = initTree();
        findFromLeft(root);
    }
}
