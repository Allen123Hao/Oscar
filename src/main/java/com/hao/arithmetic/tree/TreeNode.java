package com.hao.arithmetic.tree;

/**
 * <code>TreeNode</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2021-01-13
 * @version: 1.0
 */
public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key, TreeNode left, TreeNode right){
        this.key = key;
        this.left = left;
        this.right = right;
    }
}
