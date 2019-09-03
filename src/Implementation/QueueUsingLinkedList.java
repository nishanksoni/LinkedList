package Implementation;

import static LinkedListStructure.LinkedListStructure.*;


public class QueueUsingLinkedList {
    Node front = null;
    Node rear = null;


    void EnQueue(int num) {
        Node temp = new Node(num);
        // If the queue is empty then new node is front and rear both
        if (front == null && rear == null) {
            front = rear = temp;
            return;
        }
        // Add the new node at the end of queue and change rear
        rear.next = temp;
        rear = temp;
    }


    Node deque() {
        // If queue is empty than return null
        if (front == null) {
            return null;
        }
        // If front and rear becomes null than return null
        Node temp = front;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
        }
        return null;
    }


    public static void main(String[] args) {

        QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();
    }
}
