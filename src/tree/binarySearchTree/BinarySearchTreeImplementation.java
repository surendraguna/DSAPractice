package tree.binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.Node;
import tree.binaryTree.BinaryTreeImplementation;

public class BinarySearchTreeImplementation extends BinaryTreeImplementation implements BinarySearchTree{
        
    @Override
    public void insertElement(int data) {
        insertElement(data, getRoot());
    }

    private void insertElement(int data, Node root) {
        if(root == null) {
            root = new Node(data);
            setRoot(root);
            return;
        }
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            parent = cur;
            if(cur.data == data) return;
            if(cur.data > data) cur = cur.left;
            else cur = cur.right;
        }
        if(parent.data > data)
            parent.left = new Node(data);
        else 
            parent.right = new Node(data);
    }

    @Override
    public void removeElement(int data) {
        setRoot(removeElement(data, getRoot()));
    }

    private Node removeElement(int data, Node root) {
        if(root == null) return null;
        if(root.data > data) root.left = removeElement(data, root.left);
        else if (root.data < data) root.right = removeElement(data, root.right);
        else {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            /* Successor */
            root.data = findMin(root.right).data;
            root.right = removeElement(root.data, root.right);
        }
        return root;
    }

    private Node findMin (Node root) {
        if(root == null) return null;
        while (root.left != null) root = root.left;
        return root;
    }

    
    @SuppressWarnings("unused") /* It is for Predecessor */
    private Node findMax(Node root) {
        if(root == null) return null;
        while (root.right != null) root = root.right;
        return root;
    }

    @Override
    public boolean searchElement(int data) {
        return searchElement(data, getRoot());
    }

    private boolean searchElement(int data, Node root) {
        if(root == null) return false;
        Node cur = root;
        while (cur != null) {
            if(cur.data == data) return true;
            if(cur.data > data) cur = cur.left;
            else cur = cur.right;
        }
        return false;
    }

    @Override
    public int heightOfElement(int data) {
        Node node = findNode(data, getRoot());
        if(node == null) return -1;
        return heightOfElement(node);
    }



    private Node findNode(int data, Node root) {
        if(root == null) return null;
        Node cur = root;
        while (cur != null) {
            if(cur.data == data) return cur;
            if(cur.data > data) cur = cur.left;
            else cur = cur.right;
        }
        return cur;
    }

    private int heightOfElement(Node node) {
        if(node == null) return -1;
        int leftNode = heightOfElement(node.left);
        int rightNode = heightOfElement(node.right);
        return Math.max(leftNode, rightNode) + 1;
    }

    @Override
    public int depthOfElement(int data) {
        return depthOfElement(data, getRoot());
    }

    private int depthOfElement(int data, Node root) {
        if(root == null) return 0;
        int depth = 0;
        Node cur = root;
        while (cur != null) {
            if(cur.data == data) return depth;
            if(cur.data > data) cur = cur.left;
            else cur = cur.right;
            depth++;
        }
        return -1;
    }

    @Override
    public int numberOfNodes() {
        return numberOfNodes(getRoot());
    }

    private int numberOfNodes(Node root) {
        if(root == null) return 0;
        int left = numberOfNodes(root.left);
        int right = numberOfNodes(root.right);
        return left + right + 1;
    }

    @Override
    public int numberOfEdges() {
        return numberOfNodes() - 1;
    }

    @Override
    public int numberOfLevels() {
        return heightOfElement(getRoot());
    }

    @Override
    public List<Integer> getElementsAtLevel(int data) {
        return getElementsAtLevel(data, getRoot());
    }

    private List<Integer> getElementsAtLevel(int data, Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int l = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if(l == data) {
                for(int i = 0; i < size; i++)
                    res.add(q.poll().data);
                return res;
            } 
            for(int  i = 0; i < size; i++) {
                Node temp = q.poll();
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            l++;
        }
        return res;
    }

    @Override
    public List<Integer> getLeafNodes() {
        List<Integer> res = new ArrayList<>();
        getLeafNodes(getRoot(), res);
        return res;
    }

    private void getLeafNodes(Node root, List<Integer> res) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            res.add(root.data);
            return;
        }
        getLeafNodes(root.left, res);
        getLeafNodes(root.right, res);
    }
}
