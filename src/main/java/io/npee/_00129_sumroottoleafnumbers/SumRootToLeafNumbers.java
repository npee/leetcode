package io.npee._00129_sumroottoleafnumbers;



public class SumRootToLeafNumbers {

    public static int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public static int sum(TreeNode node, int sum) {

        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            // 재귀 종료 조건(leaf node)
            return sum * 10 + node.val;
        }

        return sum(node.left, sum * 10 + node.val) + sum(node.right, sum * 10 + node.val);
    }

    public static void main(String[] args) {
        int result = sumNumbers(rootNode());
        System.out.println("result = " + result);
    }

    private static TreeNode rootNode() {
        // [4, 9, 0, 5, 1]
        return new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
    }
}

class TreeNode {
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

