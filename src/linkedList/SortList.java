package linkedList;

public class SortList {
    public static void main(String[] args) {
        SingleLL list = new SingleLL();
        list.insertAtEnd(5);
        list.insertAtEnd(2);
        list.insertAtHead(100);
        list.insertAtEnd(4);
        list.insertAtEnd(1);
        list.insertAtEnd(3);
        list.insertAtEnd(0);
        list.setHead(merge(list.getHead()));
        list.display();
    }

    private static Node merge(Node first) {
        if(first == null || first.next == null) return first;
        Node mid = findMid(first);
        Node second = reverse(mid.next);
        mid.next = null;
        Node left = merge(first);
        Node right = merge(second);
        return mergeSort(left, right);
    }

    private static Node mergeSort(Node left, Node right) {
        Node dummy = new Node(0);
        Node temp = dummy;
        while (left != null && right != null) {
            if(left.data <= right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if(left != null) temp.next = left;
        if(right != null) temp.next = right;
        return dummy.next;
    }

    private static Node reverse(Node node) {
        Node cur = node, prev = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private static Node findMid(Node node) {
        Node fast = node;
        while (fast != null && fast.next != null && fast.next.next != null) {
            node = node.next;
            fast = fast.next.next;
        }
        return node;
    }
}
