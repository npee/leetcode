# 342. Power of Four
## Code
```java
public class Solution {
    public static boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
```
## Complexity
### Time complexity
num > 0 : O(1)  
num & (num - 1) == 0 : O(n)  
num & 0x55555555 : O(n)  
=> O(n)
### Space complexity