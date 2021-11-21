package io.npee._00106_constructbinarytreefrominorderandpostordertraversal;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public ConstructBinaryTreeFromInorderAndPostorderTraversal.TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null && postorder == null) {
            return null;
        }

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return traverse(
                inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1,
                inorderMap);
    }

    public ConstructBinaryTreeFromInorderAndPostorderTraversal.TreeNode traverse(
            int[] inorder, int inStartPos, int inEndPos,
            int[] postorder, int postStartPos, int postEndPos,
            Map<Integer, Integer> inorderMap) {

        if (inStartPos > inEndPos || postStartPos > postEndPos) {
            return null;
        }

        ConstructBinaryTreeFromInorderAndPostorderTraversal.TreeNode tree
                = new ConstructBinaryTreeFromInorderAndPostorderTraversal.TreeNode(postorder[postEndPos]);

        int rootPos = inorderMap.get(postorder[postEndPos]);

        ConstructBinaryTreeFromInorderAndPostorderTraversal.TreeNode leftNode = traverse(
                inorder, inStartPos, rootPos - 1,
                postorder, postStartPos, postStartPos + rootPos - inStartPos - 1,
                inorderMap);

        ConstructBinaryTreeFromInorderAndPostorderTraversal.TreeNode rightNode = traverse(
                inorder, rootPos + 1, inEndPos,
                postorder, postStartPos + rootPos - inStartPos, postEndPos - 1,
                inorderMap
        );

        tree.left = leftNode;
        tree.right = rightNode;
        return tree;
    }
}