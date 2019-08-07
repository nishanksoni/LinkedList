package LinkedListStructure;

import static LinkedListStructure.LinkedListStructure.*;

public class simpleLinkedList {


    public static void main(String[] args) {
        simpleLinkedList createLinkedList = new simpleLinkedList();

        // Ways to  create a linked list
        head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(5);


        // Link first node with the second node
        head.next = second;
        second.next = third;


        printList();

    }
}
