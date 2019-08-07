package Basics;

import static LinkedListStructure.LinkedListStructure.*;

public class searchAnElement {


    boolean searchRecursively(Node head, int target) {
        if (head == null) {
            return false;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == target) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    boolean searchIteratively(Node head, int target) {
        if (head == null) {
            return false;
        }
        if (head.data == target) {
            return true;
        }
        return searchRecursively(head.next, target);
    }


    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);
        push(40);
        push(50);


        boolean searchIteratively = new searchAnElement().searchRecursively(head, 0);
        System.out.println("Search an element in a linked list by iterative way is :- " + searchIteratively);


        boolean searchRec = new searchAnElement().searchIteratively(head, 10);
        System.out.println("Search an element in a linked list by recursion is  :- " + searchRec);
    }
}
