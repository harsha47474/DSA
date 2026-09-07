class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suffix = new int[n];
        suffix[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){  
            if(suffix[i+1] > nums[i]){
                suffix[i] = nums[i];
            } else {
                suffix[i] = suffix[i+1];
            }
        }

        int maxElem = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            maxElem = Math.max(maxElem, nums[i]);
            int stabilityScore = maxElem - suffix[i];
            if(stabilityScore <= k) return i;
        }

        return -1;
    }
}