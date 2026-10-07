class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();

        findTheTree(root, targetSum, ans, currAns, 0);

        return ans;
    }

    public void findTheTree(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> curr, int sum) {
        if (root == null) {
            return;
        }

        curr.add(root.val);
        sum += root.val;

        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                ans.add(new ArrayList<>(curr));
            }
        }

        findTheTree(root.left, targetSum, ans, curr, sum);
        findTheTree(root.right, targetSum, ans, curr, sum);

        curr.remove(curr.size() - 1);
    }
}