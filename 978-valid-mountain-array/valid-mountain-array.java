class Solution {
    public boolean validMountainArray(int[] arr) {
        int pivot = 0;
        int n = arr.length;
        if(n < 3) return false;
        int pivotIndex = findPivot(arr);
        if(pivotIndex >= n-1 || pivotIndex == 0) return false;
        for(int i=pivotIndex; i<n-1; i++){
            if(arr[i]<=arr[i+1]) return false;
        }

        return true;
    }
    private static int findPivot(int[] arr){
        int i = 1;
        while(i<arr.length && arr[i] > arr[i-1]){
            i++;
        }
        return i-1;
    }
}