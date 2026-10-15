class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        List<List<Integer>> rowList = new ArrayList<>();
        Map<List<Integer>, Integer> colList = new HashMap<>();

        for(int i = 0; i<n; i++){
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for(int j=0; j<n; j++){
                list1.add(grid[i][j]);
                list2.add(grid[j][i]);
            }

            rowList.add(list1);
            colList.put(list2, colList.getOrDefault(list2, 0) + 1);
        }

        int ans = 0;
        for(List<Integer> key: rowList){
            if(colList.containsKey(key)){
                ans += colList.get(key);
            }
        }

        System.out.println(rowList);
        System.out.print(colList);
        return ans;
    }
}