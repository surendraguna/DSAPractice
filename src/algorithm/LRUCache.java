package algorithm;

import java.util.HashMap;

class LRUCache {

    Node head, tail;
    HashMap<Integer, Node> map;
    int cap;
    class Node{
        int key, data;
        Node next, prev;
        Node (int key, int data) {
            this.key = key;
            this.data = data;
            next = prev = null;
        }
    }

    

    public LRUCache(int capacity) {
        head = tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            deleteNode(map.get(key));
            addFirst(map.get(key));
            return map.get(key).data;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) deleteNode(map.get(key));
        if(cap == map.size()){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        Node node = new Node(key, value);
        addFirst(node);
        map.put(key, node);
    }
    void addFirst (Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    void deleteNode (Node node) {
        tail.prev = node.prev;
        node.prev.next = tail;
    }
    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        l.put(1, 1);
        l.put(2,2);
        System.out.println(l.get(1));
        l.put(3, 3);
        System.out.println(l.get(2));
        l.put(4, 4);
        System.out.println(l.get(1) + " " + l.get(3) + " " + l.get(4));
    }
}