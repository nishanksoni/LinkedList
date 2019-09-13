package Interviewbit;


import static LinkedListStructure.LinkedListStructure.Node;

// https://leetcode.com/problems/merge-k-sorted-lists/
// https://leetcode.com/problems/merge-k-sorted-lists/solution/
// https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
// Use an approach of merging two lists
// Time complexity : O(kN) where k is the number of linked lists
public class MergeKSortedLists {
    // Iterative way
    public Node mergeTwoLists(Node l1, Node l2) {
        Node dummyNode = new Node(0);
        Node ans = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                dummyNode.next = l1;
                // Increase the pointer of dummyNode and l1 list
                dummyNode = dummyNode.next;
                l1 = l1.next;
            } else {
                dummyNode.next = l2;
                // Increase the pointer of dummyNode and l2 list
                dummyNode = dummyNode.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            dummyNode.next = l2;
        }
        if (l2 == null) {
            dummyNode.next = l1;
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
