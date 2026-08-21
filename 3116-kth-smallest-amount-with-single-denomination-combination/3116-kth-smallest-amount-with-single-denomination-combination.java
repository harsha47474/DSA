import java.util.*;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long left = 1;
        long minCoin = Arrays.stream(coins).min().getAsInt();
        long right = (long) k * minCoin;
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (countSmallerToLeft(mid, coins) >= k) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private static long countSmallerToLeft(long mid, int[] coins) {
        long count = 0;
        int n = coins.length;
        for (int exp = 1; exp <= (1 << n) - 1; exp++) {
            long order = 0;
            long lcm = 0;
            for (int i = 0; i < n; i++) {
                if ((exp & (1 << i)) != 0) {
                    order++;

                    if (lcm == 0) {
                        lcm = coins[i];
                    } else {
                        lcm = lcm * coins[i] / gcd(lcm, coins[i]);
                    }
                }

            }
            if ((order & 1) != 0) {
                count += mid / lcm;
            } else {
                count -= mid / lcm;
            }
        }
        return count;
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
