class Solution {
    public int maxDepth(String s) {
        int globalMax = 0;
        int currMax = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                currMax = currMax + 1;
            else if(s.charAt(i) == ')')
                currMax = currMax - 1;
            globalMax = Math.max(currMax, globalMax);
        }
        return globalMax;
    }
}