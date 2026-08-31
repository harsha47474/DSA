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

class Pair {
    TreeNode node;
    int idx;

    public Pair(TreeNode node, int idx) {
        this.node = node;
        this.idx = idx;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int maxWidth = Integer.MIN_VALUE;
        int count = 1;
        
        while(!q.isEmpty()){
            int currWidth = q.peekLast().idx - q.peekFirst().idx + 1;
            maxWidth = Math.max(maxWidth, currWidth);
            
            int tempCount = count;
            count = 0;
            for(int i=0; i<tempCount; i++){
                Pair temp = q.remove();
                if(temp.node.left != null){
                    q.offer(new Pair(temp.node.left, 2*temp.idx + 1));
                    count++;
                }
                if(temp.node.right != null){
                    q.offer(new Pair(temp.node.right, 2*temp.idx + 2));
                    count++;
                }
            }

        }

        return maxWidth;
    }
}