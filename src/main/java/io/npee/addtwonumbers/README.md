# 2. Add Two Numbers
## Code
```java
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            carry /= 10;
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(carry % 10);
            current = current.next;
        }
        if (carry / 10 == 1) {
            current.next = new ListNode(1);
        }
        return head.next;
    }
}
```
## Complexity
### Time complexity
while (l1 != null || l2 != null) {...} : O(n)
=> O(n)
### Space complexity