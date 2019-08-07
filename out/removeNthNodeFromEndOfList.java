package src.BasicQuestions;


import static LinkedListStructures.LinkedListStructure.*;

public class removeNthNodeFromEndOfList {

    public Node removeNthFromEnd(Node head, int index) {
        Node dummy = new Node(0);
        Node first = head;
        int length = 0;

        while (first != null) {
            length++;
            first = first.next;
        }
        length = length - index;


    }


    public static void main(String[] args) {
        removeNthNodeFromEndOfList removeNthNodeFromEndOfList = new removeNthNodeFromEndOfList();

        push(5);
        push(4);
        push(3);
        push(7);
        push(2);
        push(1);

        printList();

        Node sort = removeNthNodeFromEndOfList.removeNthFromEnd(head, 3);


        printList(sort);


    }


}
