function diagonalPrime(nums: number[][]): number {
    const isPrime = (n: number): boolean => {
        if (n <= 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        if (n % 2 == 0) {
            return false;
        }

        for (let i: number = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        };
        return true;
    }

    const len: number = nums.length;

    let maxPrime: number = 0;
    for (let i: number = 0; i < len; i++) {
        const nm1: number = nums[i][len - i - 1];
        const nm2: number = nums[i][i];

        if (nm1 > maxPrime) {
            if (isPrime(nm1)) {
                maxPrime = nm1;
            }
        }
        if (nm2 > maxPrime) {
            if (isPrime(nm2)) {
                maxPrime = nm2;
            }
        }
    }

    return maxPrime;
};