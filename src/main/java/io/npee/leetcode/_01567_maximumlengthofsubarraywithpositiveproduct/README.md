# 1567. Maximum Length of Subarray With Positive Product
## Code
```java
class Solution {
    public int getMaxLen(int[] nums) {
        int negativeCount = 0, max = 0;
        int firstNegativePos = -1, zeroPos = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeCount++;
                if (firstNegativePos == -1) {
                    firstNegativePos = i;
                }
            }
            if (nums[i] == 0) {
                negativeCount = 0;
                firstNegativePos = -1;
                zeroPos = i;
            } else {
                if (negativeCount % 2 == 0) {
                    max = Math.max(i - zeroPos, max);
                } else {
                    max = Math.max(i - firstNegativePos, max);
                }
            }
        }
        return max;
    }
}
```
## Result
![img.png](img.png)

## Complexity
### Time complexity
O(N)
### Space complexity
O(1)