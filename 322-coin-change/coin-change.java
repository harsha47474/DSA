class Solution {
    public int coinChange(int[] coins, int amount) {
        // 1D dp
        int n = coins.length;
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int sub = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE)
                    sub = Math.min(sub, dp[i - coins[j]]);
            }
            if (sub != Integer.MAX_VALUE)
                dp[i] = 1 + sub;
            else
                dp[i] = Integer.MAX_VALUE;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}