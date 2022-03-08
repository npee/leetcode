package io.npee.leetcode._00328_oddevenlinkedlist;

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        // 홀수 번째 노드를 모아서 앞으로, 짝수 번째 노드는 모아서 그 뒤로 배치해야 한다.
        // O(n) 시간, O(1) 추가 공간 사용
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        // input : [2,1,3,5,6,4,7]
        ListNode head =
                new ListNode(2
                , new ListNode(1
                , new ListNode(3
                , new ListNode(5
                , new ListNode(6
                , new ListNode(4
                , new ListNode(7
        )))))));
        ListNode result = oddEvenList(head);
        printNode(result);
    }

    public static void printNode(ListNode head) {
        if (head.next != null) {
            System.out.print(head.val + " -> ");
            printNode(head.next);
        } else {
            System.out.print(head.val);
        }
    }
}

