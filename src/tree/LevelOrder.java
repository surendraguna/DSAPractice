package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


import tree.binaryTree.BinaryTreeImplementation;

public class LevelOrder {
    public static void main(String[] args) {
        BinaryTreeImplementation t = new BinaryTreeImplementation();
        for (int i = 1; i < 32; i++) 
            t.insertElement(i);
        System.out.println(levelOrder(t.getRoot()));
    }

    private static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> temp = new ArrayList<>();
            while(n-- > 0) {
                Node cur = q.poll();
                if(cur != null) {
                    temp.add(cur.data);
                    if(cur.left != null) q.add(cur.left);
                    if(cur.right != null) q.add(cur.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
