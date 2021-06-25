# 7. Reverse Integer
## Code
```java
public class Solution {
    public static int reverse(int x) {
        try {
            return Integer.parseInt(new StringBuilder(String.valueOf(Math.abs(x))).append(x < 0? "-": "").reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
```
## Complexity
### Time complexity
### Space complexity
