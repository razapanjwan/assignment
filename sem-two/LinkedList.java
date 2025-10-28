public class LinkedList {
    // ===== Inner Node class =====
    // Each Node holds data and a reference to the next Node
    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {

        // ===== STEP 1: Create 5 separate nodes =====
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();

        // ===== STEP 2: Assign data values =====
        a.data = 31;
        b.data = 6;
        c.data = 15;
        d.data = 44;
        e.data = 10;
        
        // ===== STEP 3: Link nodes together =====
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;  // last node should point to null

        Node head = a;

        System.out.println("Original Linked List:");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println(); 

        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data > j.data) {
                    // swap only data (not links)
                    int t = i.data;
                    i.data = j.data;
                    j.data = t;
                }
            }
        }
        System.out.println("Sorted Linked List:");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }
}