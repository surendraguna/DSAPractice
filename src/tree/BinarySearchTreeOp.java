package tree;

import tree.binarySearchTree.BinarySearchTreeImplementation;

public class BinarySearchTreeOp {
    public static void main(String[] args) {
        BinarySearchTreeImplementation tree = new BinarySearchTreeImplementation();
        int[] a = {8, 3, 10, 1, 6, 4, 7, 14, 13, 5};
        for (int i : a) {
            tree.insertElement(i);
        }   
        System.out.println(isValidBST(tree.getRoot()));
    }
    
    public static boolean isValidBST(Node root) {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(Node node, Integer low, Integer high) {
        if(node == null) return true;
        if ((low != null && node.data <= low) || (high != null && node.data >= high)) return false;
        return isValidBST(node.left, low, node.data) && isValidBST(node.right, node.data, high);
    }
}
