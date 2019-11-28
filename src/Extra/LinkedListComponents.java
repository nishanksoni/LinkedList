package Extra;

import LinkedListStructure.LinkedListStructure.Node;

import java.util.HashSet;
import java.util.Set;

import static LinkedListStructure.LinkedListStructure.head;
import static LinkedListStructure.LinkedListStructure.push;

public class LinkedListComponents {
    public int numComponents(Node head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int num : G) {
            set.add(num);
        }
        int count = 0;
        Node temp = head;
        while (temp != null) {
            if (set.contains(temp.data) && (temp.next == null || !set.contains(temp.next.data))) {
                count++;
            }
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        push(3);
        push(2);
        push(1);
        push(0);

        int[] G = {0, 1, 3};
        int i = new LinkedListComponents().numComponents(head, G);
        System.out.println(i);
    }
}
