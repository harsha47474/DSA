class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;

        int maxPrime = 0;
        for(int i=0; i<n; i++){
            int nm1 = nums[i][n-i-1];
            int nm2 = nums[i][i];

            if(nm1 > maxPrime){
                if(isPrime(nm1)) maxPrime = nm1;
            }
            if(nm2 > maxPrime){
                if(isPrime(nm2)) maxPrime = nm2;
            }
        }

        return maxPrime;
    }

    public boolean isPrime(int n) {
        if (n <= 1)
            return false;

        if (n == 2)
            return true;

        if (n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}