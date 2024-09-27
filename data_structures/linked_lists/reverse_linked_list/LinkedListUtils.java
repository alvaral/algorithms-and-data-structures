package data_structures.linked_lists.reverse_linked_list;

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class LinkedListUtils {

    // Helper function to print the linked list as a string
    public String printList(ListNode head) {
        StringBuilder result = new StringBuilder();
        while (head != null) {
            result.append(head.val).append(" ");
            head = head.next;
        }
        return result.toString().trim();
    }

    // Helper function to convert an array to a linked list
    public ListNode arrayToList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
}
