package Interviewbit;

import static LinkedListStructure.LinkedListStructure.*;

// https://leetcode.com/problems/merge-two-sorted-lists/
// https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
public class MergeTwoSortedLists {

    // Using Recursion
    public Node mergeTwoListUsingRecursion(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.data < l2.data) {
            l1.next = mergeTwoListUsingRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListUsingRecursion(l1, l2.next);
            return l2;
        }
    }

    // Iterative way
    public Node mergeTwoListsIterative(Node l1, Node l2) {
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

    public static void main(String[] args) {
        MergeTwoSortedLists list1 = new MergeTwoSortedLists();
        MergeTwoSortedLists list2 = new MergeTwoSortedLists();
    }
}
