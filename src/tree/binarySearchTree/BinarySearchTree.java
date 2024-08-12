package tree.binarySearchTree;

import java.util.List;

import tree.binaryTree.BinaryTree;

public interface BinarySearchTree extends BinaryTree{
    int heightOfElement(int data);
    int depthOfElement(int data);
    int numberOfNodes();
    int numberOfEdges(); 
    int numberOfLevels();
    List<Integer> getElementsAtLevel(int data);
    List<Integer> getLeafNodes();
}
