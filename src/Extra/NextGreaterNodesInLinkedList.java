package Extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static LinkedListStructure.LinkedListStructure.*;

public class NextGreaterNodesInLinkedList {
    Node root;

    public int[] nextLargerNodes(Node head) {
        List<Integer> list = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }
        int arr[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            int max = 0;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    max = list.get(j);
                    break;
                }
            }
            arr[i] = max;
        }
        return arr;
    }


    public static void main(String[] args) {
        NextGreaterNodesInLinkedList llist = new NextGreaterNodesInLinkedList();
        /* Use push() to construct below list
           1->12->1->4->1  */

        push(5);
        push(3);
        push(4);
        push(7);
        push(2);

        printList();

        new NextGreaterNodesInLinkedList().test();

        int[] ints = new NextGreaterNodesInLinkedList().nextLargerNodes(head);
       System.out.println("re " + Arrays.toString(ints));

    }


    int[] test() {
        int arr[] = {1, 7, 5, 1, 9, 2, 5, 1};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int max = 0;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    max = arr[j];
                    break;
                }
            }
            list.add(max);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }


}
