# 129. Sum Root to Leaf Numbers
## Code
```java
class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode node, int sum) {

        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return sum * 10 + node.val;
        }

        return sum(node.left, sum * 10 + node.val) + sum(node.right, sum * 10 + node.val);
    }
}
```
## Result
![img.png](img.png)

## Complexity
### Time complexity
O(n)
### Space complexity
O(k),  where k: height of a tree