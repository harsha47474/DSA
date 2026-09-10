class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        boolean zero = false;
        for(int i =0; i<nums.length; i++){
            sum += nums[i];
            max = Math.max(max, nums[i]);
            if(nums[i] == 0) zero = true;
        }
        if(!zero) return 0;
        int actualSum = (max*(max+1)) / 2;
        return actualSum - sum == 0 ? nums.length : actualSum - sum;
    }
}