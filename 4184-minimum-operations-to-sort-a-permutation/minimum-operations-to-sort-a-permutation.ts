function minOperations(nums: number[]): number {
    const n: number       = nums.length;
    let ascCount: number  = 0;
    let descCount: number = 0;

    for (let i: number = 1; i < n; i++) {
        ascCount += (nums[i] == (nums[i - 1] + 1) % n) ? 1 : 0;
        descCount += (nums[i - 1] == (nums[i] + 1) % n) ? 1 : 0;
    }

    if (ascCount == n - 1 && nums[0] == 0) return 0;

    if (ascCount == n - 1) {
        const leftRot: number  = n - nums[0];
        const rightRot: number = 1 + (nums[n - 1] + 1) + 1;

        return Math.min(leftRot, rightRot);
    }

    if (descCount == n - 1) {
        const leftRot: number  = n - nums[n - 1] + 1;
        const rightRot: number = (nums[0] + 1) % n + 1;

        return Math.min(leftRot, rightRot);
    }

    return -1;

};