/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        // BFS solution
        // Queue<Node> q = new LinkedList<>();
        // q.add(root);
        // while(!q.isEmpty()) {
        //     int size = q.size();
        //     for(int i = 0; i < size; i++) {
        //         Node curr = q.poll();
        //         if(i < size - 1) {
        //             curr.next = q.peek();
        //         }
        //         if(curr.left != null) {
        //             q.add(curr.left);
        //             q.add(curr.right);
        //         }
        //     }
        // }
        // return root;

        // Optimized solution - Iterative
        // Node left = root;
        // while(left.left != null) {
        //     Node curr = left;
        //     while(curr != null) {
        //         curr.left.next = curr.right;
        //         if(curr.next != null) {
        //             curr.right.next = curr.next.left;
        //         }
        //         curr = curr.next;
        //     }
        //     left = left.left;
        // }
        // return root;

        // Recursive solution - best in Space O(h)
        if(root == null) {
            return root;
        }
        dfs(root.left, root.right);
        return root;
    }

    private void dfs(Node left, Node right) {
        if(left == null) {
            return;
        }
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }
}
