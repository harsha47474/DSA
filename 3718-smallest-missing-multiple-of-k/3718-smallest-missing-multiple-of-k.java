class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int n = k;
        int i = 2;
        while(true){
            if(!set.contains(n)) return n;
            n=k*i;
            i++;
        }
    }
}