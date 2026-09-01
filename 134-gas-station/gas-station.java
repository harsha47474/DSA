class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int idx = 0;
        int gasTank = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            gasTank += diff;

            if (gasTank < 0) {
                idx = i + 1;
                gasTank = 0;
            }
        }

        return total >= 0 ? idx : -1;
    }
}