function isGood(nums: number[]): boolean {
    const n: number = nums.length;
    nums.sort((a: number, b: number) => a - b);
    const maxElem: number = nums[n - 1];

    let count: number = 1;
    let flag: boolean = true;
    for(let i: number=0; i<n-1; i++){
        if(nums[i] != i+1){
            flag = false;
            break;
        }
    }

    return nums[n-1] == nums[n-2] && flag;
};