package Interviewbit;


import static LinkedListStructure.LinkedListStructure.Node;

public class MergeKSortedLists {
    // Iterative way
    public Node mergeTwoLists(Node l1, Node l2) {
        Node h = new Node(0);
        Node ans = h;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            h.next = l2;
        }
        if (l2 == null) {
            h.next = l1;
        }
        return ans.next;
    }


    public Node mergeKLists(Node lists[]) {
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 0) {
            return null;
        }
        Node head = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    public static void main(String[] args) {
    }

}
