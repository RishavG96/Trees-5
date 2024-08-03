/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev;
    TreeNode first = null, second = null;
    int cnt;
    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }
        // Recursive
        // inorder(root);
        // int temp = first.val;
        // first.val = second.val;
        // second.val = temp;

        //Iterative
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev != null && prev.val > root.val) {
                if(first == null) {
                    first = prev;
                }
                second = root;
            }
            prev = root;
            root = root.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if(root == null || cnt == 2) {
            return;
        }
        inorder(root.left);
        if(prev != null && prev.val > root.val) {
            cnt++;
            if(first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}
