package leetcode.剑指;

import java.util.HashMap;
import java.util.Map;

public class 剑指offer07 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    class Solution {
        Map<Integer, Integer> orderMap;
        int[] preorder;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            orderMap = new HashMap<>();
            this.preorder = preorder;
            for(int i = 0; i < inorder.length; i++){
                orderMap.put(inorder[i], i);
            }
            return buildTree(0, 0, inorder.length -1);
        }

        /**
         * 通过 不断提取根结点，从而生成树
         * 1。前序找到根结点
         * 2。中序找到该根结点index
         * 3。根据index能够确定左/右子树数量，从而在前序中划分左子树/右子树，从而从中提出子树根结点
         * @param root 前序中根结点index
         * @param left 左边届
         * @param right 右边界
         *  通过左右边界及中序中 根节点index，可计算左子树个数，右子树个数，进而通过 前序中根节点index，划分左右子数，提出子数根结点
         * @return
         */
        private TreeNode buildTree(int root, int left, int right){
            if (left > right)
                return null;
            TreeNode rootNode = new TreeNode(preorder[root]);
            int rootIndex = orderMap.get(preorder[root]);
            //左子树
            //这个地方给中序边界 就是为了能从 前序 根结点计算元素个数，划分出左右子树
            rootNode.left = buildTree(root + 1, left, rootIndex -1);
            //右子树
            rootNode.right = buildTree(root + (rootIndex - left) + 1, rootIndex + 1, right);
            return rootNode;
        }
    }

}
