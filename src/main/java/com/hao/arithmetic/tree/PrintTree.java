package com.hao.arithmetic.tree;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <code>PrintTree</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/12/30
 * @version: 1.0
 */
public class PrintTree {
    class Node{
        int key;
        Node left;
        Node right;
        Node(int key,Node left,Node right){
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }
    public void stringToTree(String str){
        String[] parts = str.split(",");
        int length = parts.length;
        int count = 0;
        int rootKey = Integer.parseInt(parts[0]);
        Node root = new Node(rootKey,null,null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        count ++;
        while(!queue.isEmpty()){
            Node currentNode = queue.remove();
            if(count < length){
                Node leftNode = new Node(Integer.parseInt(parts[count]),null,null);
                queue.add(leftNode);
                count++;
                currentNode.left = leftNode;
            }
            if(count < length){
                Node rightNode = new Node(Integer.parseInt(parts[count]),null,null);
                queue.add(rightNode);
                count++;
                currentNode.right = rightNode;
            }
        }
        System.out.println(new Gson().toJson(root));
        System.out.println();
        prettyPrintTree(root);
        treeToString(root);
        System.out.println();
        printLines(root);
    }

    private void prettyPrintTree(Node node){
        prettyPrintTree(node,"",true);
    }

    private void prettyPrintTree(Node node,String prefix,boolean isLeft){
        if(node.right != null){
            prettyPrintTree(node.right,prefix+(isLeft? "│   " : "    "),false);
        }
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.key);

        if(node.left != null){
            prettyPrintTree(node.left,prefix+(isLeft?"    " : "│   "),true);
        }
    }


    private void treeToString(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.print(root.key+" ");
        while(!queue.isEmpty()){
            Node curNode = queue.remove();
            if(curNode.left != null){
                queue.add(curNode.left);
                System.out.print(curNode.left.key + " ");
            }
            if(curNode.right != null){
                queue.add(curNode.right);
                System.out.print(curNode.right.key + " ");
            }


        }
    }

    //递归按行输出
    //ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    //getList(pRoot, 1, list);
    public void getList(Node root, int level, List<List<Integer>> list){
        if (root == null)
            return;
        if (list.size() > level)
        {
            List<Integer> temp = list.get(level);
            temp.add(root.key);
        } else {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.key);
            list.add(level, temp);
        }
        getList(root.left, level + 1, list);
        getList(root.right, level + 1, list);
    }


    public ArrayList<ArrayList<Integer> > printLines(Node pRoot) {
        ArrayList<ArrayList<Integer>> arrs = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return arrs;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(pRoot);
        int last=q.size(), count=0;
        while(!q.isEmpty()){
            count = 0;
            last = q.size();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            while(count<last){
                Node tr = q.poll();
                count++;
                arr.add(tr.key);
                if(tr.left != null){
                    q.add(tr.left);
                }
                if(tr.right != null){
                    q.add(tr.right);
                }
            }
            arrs.add(arr);
        }
        System.out.println(new Gson().toJson(arrs));
        return arrs;
    }

    //递归输出每行
    public class Solution {
        ArrayList<ArrayList<Integer> > Print(Node pRoot) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            depth(pRoot, 1, list);
            return list;
        }

        private void depth(Node root, int depth, ArrayList<ArrayList<Integer>> list) {
            if(root == null) return;
            if(depth > list.size())
                list.add(new ArrayList<Integer>());
            list.get(depth -1).add(root.key);

            depth(root.left, depth + 1, list);
            depth(root.right, depth + 1, list);
        }
    }

    public static void main(String[] args) {
        PrintTree printTree = new PrintTree();
//        String arr = "1,2,3,4,5,6,7,8,9,10,11,12,13";
        String arr = "1,2,3,4";
        printTree.stringToTree(arr);
    }
}
