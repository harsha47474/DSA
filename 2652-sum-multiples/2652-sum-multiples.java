class Solution {
    public int sumOfMultiples(int n) {
        int sumOf3 = 3 * ((n/3) * ((n/3) + 1) / 2);
        int sumOf5 = 5 * ((n/5) * ((n/5) + 1) / 2);
        int sumOf7 = 7 * ((n/7) * ((n/7) + 1) / 2);
        int commons = 15 * ((n/15) * ((n/15) + 1) / 2);
        int commons2 = 21 * ((n/21) * ((n/21) + 1) / 2);
        int commons3 = 35 * ((n/35) * ((n/35) + 1) / 2);
        int commons3Way = 105 * ((n/105) * ((n/105) + 1) / 2);

        return (sumOf3 + sumOf5 + sumOf7) - (commons + commons2 + commons3) + commons3Way;
    }
}
