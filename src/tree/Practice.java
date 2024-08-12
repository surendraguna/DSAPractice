package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.binarySearchTree.BinarySearchTreeImplementation;

public class Practice {
    static Node root = null;
    public static void main(String[] args) {
        // given a binary search tree find the k th heighest number
        BinarySearchTreeImplementation b = new BinarySearchTreeImplementation();
        insertElement(6);
        insertElement(8);
        insertElement(4);
        insertElement(7);
        insertElement(5);
        insertElement(3);
        b.setRoot(root);
        // levelOrder();
        // b.levelOrder();
        // inOrder();
        // b.inOrder();
        // preOrder();
        // b.preOrder();
        postOrder();
        b.postOrder();
    }
    static void insertElement(int val) {
        if(root == null) {
            root = new Node(val);
            return;
        }
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            parent = cur;
            if(cur.data > val) cur = cur.left;
            else if (cur.data < val) cur = cur.right;
            else return;
        }
        if(parent.data > val)  parent.left = new Node(val);
        else parent.right = new Node(val);
    }

    static void levelOrder() {
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
        }
        System.out.println();
    }

    static void inOrder() {
        if(root == null) return;
        Stack<Node> s = new Stack<>();
        Node cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            System.out.print(cur.data + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    static void preOrder() {
        if(root == null) return;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node temp = s.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null) s.push(temp.right);
            if(temp.left != null) s.push(temp.left);
        }
        System.out.println();
    }

    static void postOrder() {
        if(root == null) return;
        Stack<Node> s = new Stack<>();
        Node cur = root;
        while (cur != null || !s.isEmpty()) {
            
        }
    }
}
