package Interviewbit;

import static LinkedListStructure.LinkedListStructure.*;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedListAnotherWay {
    // Using Divide and conquer
    public Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return sort(lists, 0, lists.length - 1);
    }

    private Node sort(Node[] lists, int low, int high) {
        if (low >= high) {

            return lists[low];
        }
        int mid = low + (high - low) / 2;
        Node l1 = sort(lists, low, mid);
        Node l2 = sort(lists, mid + 1, high);
        return merge(l1, l2);
    }

    // Normal merge
    private Node merge(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.data < l2.data) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
