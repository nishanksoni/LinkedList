package LinkedListStructure;

public class LinkedListStructure {
    public static Node head;  // head of list


    /* Node Class */
    public static class Node {
        public int data;
        public Node next;

        // Constructor to create a new node
        public Node(int d) {
            data = d;
            next = null; // By default initialized as null
        }
    }

    // Linked List Traversal
    // Print the data of each node
    // This function prints contents of linked list starting from head
    public static void printList() {

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;

        }
        System.out.println();
    }

    //Linked list traversal
    public static void printList(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println();
    }

    //Pushing data to a LinkedList
    public static void push(int new_data) {
        Node new_node = new Node(new_data);

        new_node.next = head;

        head = new_node;
    }


}
