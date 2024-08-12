package linkedList;

public class ReverseLL {
    public static void main(String[] args) {
        SingleLL s = new SingleLL();
        s.insertAtEnd(1);
        s.insertAtEnd(2);
        s.insertAtEnd(3);
        s.insertAtEnd(4);
        Node head = s.getHead();
        head = reverse(head);
        s.display(head);
    }

    private static Node reverse(Node head) {
        if(head == null || head.next == null)
            return head;
        Node newHead = reverse(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}
