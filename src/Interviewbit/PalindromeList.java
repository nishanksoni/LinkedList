package Interviewbit;

import static LinkedListStructure.LinkedListStructure.*;

// Runner technique
// Best optimized way
// First get the middle node  -- reverse second half -- compare first and second half
// combination of two programs
// https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeList {


    boolean isPalindromeOptimized(Node head) {
        // First get the middle node
        Node middleNode = getMiddleNode(head);

        // Reverse second half - after middle
        Node secondHalf = reverseAfterMiddle(middleNode);

        // Compare first half and second half - start loop from secondHalf
        boolean result = compareFirstAndSecondHalf(head, secondHalf);
        return result;
    }


    Node getMiddleNode(Node head) {
        Node slow_runner = head;
        Node fast_runner = head;
        if (head == null) {
            return null;
        }
        while (fast_runner != null && fast_runner.next != null) {
            fast_runner = fast_runner.next.next; // Always two steps ahead
            slow_runner = slow_runner.next; // Running only by 1x speed -- slow pointer will reach at the mid
        }
        return slow_runner;
    }

    Node reverseAfterMiddle(Node secondHalf) {
        Node current = secondHalf;
        Node prev = null;
        Node next;

        while (current != null) {
            // We are storing currents next pointer
            next = current.next;
            current.next = prev;
            // We are putting previous to currents position
            prev = current;
            // We are making current to go one step ahead
            current = next;
        }
        Node head = prev;
        return head;
    }

    private boolean compareFirstAndSecondHalf(Node head, Node secondHalf) {
        Node secondHalfList = secondHalf;
        Node current = head;
        while (secondHalfList != null) {
            if (current.data != secondHalfList.data) {
                return false;
            }
            secondHalfList = secondHalfList.next;
            current = current.next;
        }
        return true;
    }


    public static void main(String[] args) {
        PalindromeList linkedListIsPalindrome = new PalindromeList();
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(2);
        Node four = new Node(2);
        Node five = new Node(2);
        Node six = new Node(1);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;


        boolean palindromeOptimized = linkedListIsPalindrome.isPalindromeOptimized(head);

        System.out.println(palindromeOptimized);
    }


}
