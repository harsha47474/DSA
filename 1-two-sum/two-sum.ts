function twoSum(nums: number[], target: number): number[] {
    let map = new Map<number, number>();
    const n: number = nums.length;

    for (let i: number = 0; i < n; i++) {
        const complement: number = target - nums[i];
        if (map.has(complement)) {
            return [i, map.get(complement)];
        }
        map.set(nums[i], i);
    }

    return [-1, -1];
};