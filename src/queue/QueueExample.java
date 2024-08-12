package queue;

import linkedList.SingleLL;

public class QueueExample extends SingleLL {
    public static void main(String[] args) {
        QueueExample q = new QueueExample();
        q.insertAtEnd(1);
        q.insertAtEnd(2);
        q.insertAtHead(3);
        q.insertAtHead(4);
        q.display();
        q.removeAtHead();
        q.removeAtLast();
        q.display();
    }
}
