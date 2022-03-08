package io.npee.leetcode._00002_addtwonumbers;

import java.util.Arrays;
import java.util.Stack;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.next != null) {
            if (l1.val + l2.val >= 10) {
                l1.next.val++;
            }
            if (l2.next == null) {
                return new ListNode((l1.val + l2.val) % 10, addTwoNumbers(l1.next, new ListNode(0)));
            } else {
                return new ListNode((l1.val + l2.val) % 10, addTwoNumbers(l1.next, l2.next));
            }
        } else {
            if (l2.next == null) {
                if (l1.val + l2.val >= 10) {
                    return new ListNode((l1.val + l2.val) % 10, new ListNode(1));
                } else {
                    return new ListNode(l1.val + l2.val);
                }
            } else {
                if (l1.val + l2.val >= 10) {
                    l2.next.val++;
                }
                return new ListNode((l1.val + l2.val) % 10, addTwoNumbers(new ListNode(0), l2.next));
            }
        }
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
