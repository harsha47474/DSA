class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suf = new int[n];
 
        int minElem = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            minElem = Math.min(minElem, nums[i]);
            suf[i] = minElem;
        }
 
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            int score = max - suf[i];
            if (score <= k)
                return i;
        }
 
        return -1;
    }
}