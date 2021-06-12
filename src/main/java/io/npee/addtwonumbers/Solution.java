package io.npee.addtwonumbers;

import java.util.Arrays;
import java.util.Stack;

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

    public static void main(String[] args) {
        // int[] array1 = {9, 9, 9, 9, 9, 9, 9};
        int[] array1 = {2, 4, 3};
        // int[] array2 = {9, 9, 9, 9};
        int[] array2 = {5, 6, 4};
        ListNode l1 = arrayToListNode(array1);
        ListNode l2 = arrayToListNode(array2);
        System.out.println("Input: l1 = [" + listNodeToString(l1) + "], l2 = [" + listNodeToString(l2) + "]");
        System.out.println("Output: [" + listNodeToString(addTwoNumbers(l1, l2)) + "]");
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode arrayToListNode(int[] array) {
        Stack<Integer> stack = new Stack<>();
        Arrays.stream(array).forEach(stack::push);
        ListNode tempNode = new ListNode(stack.pop());
        while (!stack.empty()) {
            tempNode = new ListNode(stack.pop(), tempNode);
        }
        return tempNode;
    }

    public static String listNodeToString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        if (node.next != null) {
            sb.append(", ").append(listNodeToString(node.next));
        }
        return sb.toString();
    }
}
