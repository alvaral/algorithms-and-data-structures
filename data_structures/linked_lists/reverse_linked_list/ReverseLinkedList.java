package data_structures.linked_lists.reverse_linked_list;

/*
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:

Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 
Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 
Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseLinkedList {

    //SOL 1:  Iterative approach to reverse a linked list
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;  // Reverse the link
            prev = current;       // Move prev forward
            current = nextNode;   // Move current forward
        }
        return prev; // prev will be the new head
    }

    //SOL 2: Recursive approach to reverse a linked list
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;  // Base case: empty list or one element
        }

        ListNode newHead = reverseListRecursive(head.next);  // Recursively reverse the rest
        head.next.next = head;  // Reverse the current node's link
        head.next = null;       // Set the current node's next to null

        return newHead; // Return the new head of the reversed list
    }

    public static void main(String[] args) {
        LinkedListUtils utils = new LinkedListUtils();

        // Example 1: Input = [1,2,3,4,5]
        int[] input1 = {1, 2, 3, 4, 5};
        ListNode head1 = utils.arrayToList(input1);

        System.out.println("Original List 1: " + utils.printList(head1));

        // Test Iterative
        ListNode reversedHead1Iterative = reverseList(head1);
        System.out.println("Reversed List 1 (Iterative): " + utils.printList(reversedHead1Iterative));

        // Example 2: Input = [1,2]
        int[] input2 = {1, 2};
        ListNode head2 = utils.arrayToList(input2);

        System.out.println("Original List 2: " + utils.printList(head2));

        // Test Recursive
        ListNode reversedHead2Recursive = reverseListRecursive(head2);
        System.out.println("Reversed List 2 (Recursive): " + utils.printList(reversedHead2Recursive));

        // Example 3: Input = []
        int[] input3 = {};
        ListNode head3 = utils.arrayToList(input3);

        System.out.println("Original List 3: " + utils.printList(head3));

        // Test Iterative with empty list
        ListNode reversedHead3Iterative = reverseList(head3);
        System.out.println("Reversed List 3 (Iterative): " + utils.printList(reversedHead3Iterative));
    }
}
