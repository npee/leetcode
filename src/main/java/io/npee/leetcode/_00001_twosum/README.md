# 1. Two Sum
## Code
```java
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[1] = i;
                res[0] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
```
## Complexity
### Time complexity
for: O(n) * map.containsKey: O(log n) = O(n log n)
### Space complexity
