package io.npee.leetcode._00106_constructbinarytreefrominorderandpostordertraversal;


import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null && postorder == null) {
            return null;
        }

        // O(n)
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return traverse(
                inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1,
                inorderMap);
    }

    public static TreeNode traverse(
            int[] inorder, int inStartPos, int inEndPos,
            int[] postorder, int postStartPos, int postEndPos,
            Map<Integer, Integer> inorderMap) {

        if (inStartPos > inEndPos || postStartPos > postEndPos) {
            return null;
        }

        TreeNode tree = new TreeNode(postorder[postEndPos]);

        // root : postorder 의 마지막 요소
        int rootPos = inorderMap.get(postorder[postEndPos]); // inorder 의 root 위치
        // inorder 배열에서 root 를 기준으로 왼쪽 트리, 오른쪽 트리로 구별(재귀)
        // inorder 왼쪽 트리 : pos(inorder[0]) ~ rootPos -1
        // inorder 오른쪽 트리 : rootPos + 1 ~ pos(inorder[inorder.length - 1])

        // ** 왼쪽 트리 요소 수 : leftNodeCount = rootPos - pos(inorder[0])

        // postorder 왼쪽 트리 : pos(postorder[0]) ~ pos(postorder[0]) + leftNodeCount - 1
        // postorder 오른쪽 트리 : pos(postorder[0]) + leftNodeCount ~ pos(postorder[postorder.length - 1]) - 1
        TreeNode leftNode = traverse(
                inorder, inStartPos, rootPos - 1, // inorder left
                postorder, postStartPos, postStartPos + rootPos - inStartPos - 1, // postorder left
                inorderMap);

        TreeNode rightNode = traverse(
                inorder, rootPos + 1, inEndPos,
                postorder, postStartPos + rootPos - inStartPos, postEndPos - 1,
                inorderMap
        );

        tree.left = leftNode;
        tree.right = rightNode;
        return tree;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode result = buildTree(inorder, postorder);
        System.out.println("result.val = " + result.val);
        System.out.println("result.right.right = " + result.right.right.val);
    }

    public static void printNode(TreeNode node) {
        // expect [3,9,20,null,null,15,7]
    }

//    private static TreeNode rootNode() {
//        // root = [3,9,20,null,null,15,7]
//        return new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
//    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
