package com.hao.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <code>BinaryTree</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/5/23
 * @version: 1.0
 */
public class BinaryTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinaryTree tree = new BinaryTree();
        int[] datas = new int[]{1,2,3,4,5,6,7,8,9};
        List<Node> nodelist = new LinkedList<>();
        tree.createBinaryTree(datas, nodelist);
        Node root = nodelist.get(0);
        System.out.println("递归先序遍历：");
        tree.preOrderTraversal(root);
        System.out.println();
        System.out.println("非递归先序遍历：");
        tree.preOrderTraversalByLoop(root);
        System.out.println();
        System.out.println("递归中序遍历：");
        tree.inOrderTraversal(root);
        System.out.println();
        System.out.println("非递归中序遍历：");
        tree.inOrderTraversalByLoop(root);
        System.out.println();
        System.out.println("递归后序遍历：");
        tree.postOrderTraversal(root);
        System.out.println();
        System.out.println("非递归后序遍历：");
        tree.postOrderTraversalByLoop(root);
        System.out.println();
        System.out.println("广度优先遍历：");
        tree.bfs(root);
        System.out.println();
        System.out.println("深度优先遍历：");
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        tree.dfs(root,rst,list);
        System.out.println(rst);
    }



    /**
     * @param datas 实现二叉树各节点值的数组
     * @param nodeList 二叉树list
     */
    private void createBinaryTree(int[] datas,List<Node> nodeList){
        //将数组变成node节点
        for(int index=0;index<datas.length;index++){
            Node node = new Node(datas[index]);
            nodeList.add(node);
        }
        //给所有父节点设定子节点
        int size = nodeList.size();
        for(int i=0;i<size/2-1;i++){
            //编号为n的节点他的左子节点编号为2*n 右子节点编号为2*n+1 但是因为list从0开始编号，所以还要+1
            //这里父节点有1（2,3）,2（4,5）,3（6,7）,4（8,9） 但是最后一个父节点有可能没有右子节点 需要单独处理
            nodeList.get(i).setLchild(nodeList.get(i*2+1));
            nodeList.get(i).setRchild(nodeList.get(i*2+2));
        }
        //单独处理最后一个父节点  因为它有可能没有右子节点
        int index = size/2-1;
        nodeList.get(index).setLchild(nodeList.get(index*2+1));
        //如果有奇数个节点，最后一个父节点才有右子节点
        if(size%2 == 1){
            nodeList.get(index).setRchild(nodeList.get(index*2+2));
        }
    }

    /**
     * 访问当前节点
     * @param node
     */
    public void visitNode(Node node){
        System.out.println(node.getData()+" ");
    }

    /**
     * 前序遍历
     * @param node
     */
    public void preOrderTraversal(Node node){
        if(node == null){
            return;
        }
        visitNode(node);
        preOrderTraversal(node.getLchild());
        preOrderTraversal(node.getRchild());
    }

    /**
     * 中序遍历
     * @param node
     */
    public void inOrderTraversal(Node node){
        if(node == null){
            return;
        }
        preOrderTraversal(node.getLchild());
        visitNode(node);
        preOrderTraversal(node.getRchild());
    }

    /**
     * 后序遍历
     * @param node
     */
    public void postOrderTraversal(Node node){
        if(node == null){
            return;
        }
        preOrderTraversal(node.getLchild());
        preOrderTraversal(node.getRchild());
        visitNode(node);
    }

    /**
     * 非递归前序遍历
     * @param node
     */
    public void preOrderTraversalByLoop(Node node){
        Stack<Node> stack = new Stack();
        Node p = node;
        while(p != null || !stack.isEmpty()){
            while(p != null){
                visitNode(node);
                stack.push(p);
                p = p.getLchild();
            }
            if(!stack.isEmpty()){
                p = stack.pop();
                p = p.getRchild();
            }
        }
    }

    /**
     * 非递归中序遍历
     * @param node
     */
    public void inOrderTraversalByLoop(Node node){
        Stack<Node> stack = new Stack();
        Node p = node;
        while(p != null || !stack.isEmpty()){
            while(p != null){
                stack.push(p);
                p = p.getLchild();
            }
            if(!stack.isEmpty()){
                p = stack.pop();
                visitNode(node);
                p = p.getRchild();
            }
        }
    }

    /**
     * 非递归后序遍历
     * @param node
     */
    public void postOrderTraversalByLoop(Node node){
        Stack<Node> stack = new Stack();
        Node p = node;
        Node prev = node;
        while(p != null || !stack.isEmpty()){
            while(p != null){
                stack.push(p);
                p = p.getLchild();
            }
            if(!stack.isEmpty()){
                Node temp = stack.peek().getRchild();
                if(temp == null || temp == prev){
                    p = stack.pop();
                    visitNode(p);
                    prev = p;
                    p = null;
                }else{
                    p = temp;
                }
            }
        }
    }

    /**
     * 广度优先遍历（从上到下遍历二叉树）
     * @param root
     */
    public void bfs(Node root){
        if(root == null) return;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(root); //首先将根节点存入队列
        //当队列里有值时，每次取出队首的node打印，打印之后判断node是否有子节点，若有，则将子节点加入队列
        while(queue.size() > 0){
            Node node = queue.peek();
            queue.poll(); //取出队首元素并打印
            System.out.print(node.getData()+" ");
            if(node.lchild != null){ //如果有左子节点，则将其存入队列
                queue.offer(node.lchild);
            }
            if(node.rchild != null){ //如果有右子节点，则将其存入队列
                queue.offer(node.rchild);
            }
        }
    }
    /**
     * 深度优先遍历
     * @param node
     * @param rst
     * @param list
     */
    public void dfs(Node node,List<List<Integer>> rst,List<Integer> list){
        if(node == null) return;
        if(node.lchild == null && node.rchild == null){
            list.add(node.data);
            /* 这里将list存入rst中时，不能直接将list存入，而是通过新建一个list来实现，
             * 因为如果直接用list的话，后面remove的时候也会将其最后一个存的节点删掉*/
            rst.add(new ArrayList<>(list));
            list.remove(list.size()-1);
        }
        list.add(node.data);
        dfs(node.lchild,rst,list);
        dfs(node.rchild,rst,list);
        list.remove(list.size()-1);
    }




    /**
     *  节点类
     */
    class Node{
        Integer data;
        Node lchild;
        Node rchild;
        public Node(Integer data){
            this.data = data;
            this.lchild = null;
            this.rchild = null;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Node getLchild() {
            return lchild;
        }

        public void setLchild(Node lchild) {
            this.lchild = lchild;
        }

        public Node getRchild() {
            return rchild;
        }

        public void setRchild(Node rchild) {
            this.rchild = rchild;
        }
    }
}
