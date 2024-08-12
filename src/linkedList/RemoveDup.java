package linkedList;

public class RemoveDup {
    public static void main(String[] args) {
        SingleLL l = new SingleLL();
        int a[] = {1,2,3,3,4,4,5};
        for (int i : a) {
            l.insertAtEnd(i);
        }
        Node head = deleteDuplicates(l.getHead());
        l.display(head);
    }
    public static Node deleteDuplicates(Node head) {
        if(head == null || head.next == null) return head;
        Node cur = head, prev = null;
        Node dummy = new Node(0);
        Node tail = dummy;
        while(cur != null) {
            if(prev != null && cur.next != null) {
                if(prev.data != cur.data && cur.data != cur.next.data) {
                    tail.next = cur;
                    tail = tail.next;
                }
                prev = cur;
            } else if (prev == null && cur.next != null) {
                if(cur.data != cur.next.data) {
                    tail.next = cur;
                    tail = tail.next;
                }
                prev = cur;
            } else if(cur.next == null && prev != null){
                if(prev.data != cur.data) {
                    tail.next = cur;
                    tail = tail.next;
                }
                prev = cur;
            }
            cur = cur.next;
        }
        tail.next = null;
        return dummy.next;
    }
}
