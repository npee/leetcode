# 9. Palindrome Number
## Code
```java
public class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int reverse = 0;
        int copy = x;

        while (copy > 0) {
            int digit = copy % 10;
            reverse = reverse * 10 + digit;
            copy /= 10;
        }

        return reverse == x;
    }
}
```
## Complexity
### Time complexity
while: O(n) => O(n)
### Space complexity
