/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        getTheParentNodes(root, parents);
        Map<TreeNode, Boolean> visitedNodes = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        int distance = 0;
        visitedNodes.put(target, true);
        while(!q.isEmpty()){
            int size = q.size();
            if(distance == k) {
                break;
            }

            for(int i=0; i<size; i++){
                TreeNode current = q.poll();
                if(current.left != null && visitedNodes.get(current.left) == null){
                    q.offer(current.left);
                    visitedNodes.put(current.left, true);
                }
                if(current.right != null && visitedNodes.get(current.right) == null){
                    q.offer(current.right);
                    visitedNodes.put(current.right, true);
                }
                if(parents.get(current) != null && visitedNodes.get(parents.get(current)) == null){
                    q.offer(parents.get(current));
                    visitedNodes.put(parents.get(current), true);
                }
            }
            distance++;
        }

        List<Integer> list = new ArrayList<>();

        while(!q.isEmpty()){
            list.add(q.poll().val);
        }

        return list;
    }

    public void getTheParentNodes(TreeNode root, Map<TreeNode, TreeNode> map){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode current = q.poll();
            if(current.left != null) {
                map.put(current.left, current);
                q.offer(current.left);
            }
            if(current.right != null){
                map.put(current.right, current);
                q.offer(current.right);
            }
        }
    }
}