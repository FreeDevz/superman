package com.example;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class MyAddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy head to simplify construction
        ListNode current = dummy; // Pointer to build the result list
        int carry = 0; // Carry for sums >= 10

        // Continue while there are nodes to process or carry exists
        while (l1 != null || l2 != null || carry != 0) {
            // Get values from current nodes (0 if node is null)
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate sum and new carry
            int sum = val1 + val2 + carry;
            carry = sum / 10; // New carry (1 if sum >= 10, 0 otherwise)

            // Create new node with the digit (sum % 10)
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Move to next nodes if they exist
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return dummy.next; // Return the actual head (skip dummy)
    }
}
