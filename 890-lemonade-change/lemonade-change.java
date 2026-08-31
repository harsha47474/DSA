class Solution {
    public boolean lemonadeChange(int[] bills) {
        int noOf5 = 0;
        int noOf10 = 0;
        int n = bills.length;

        for(int num: bills){
            if(num == 5) noOf5++;
            else if (num == 10) {
                if(noOf5 == 0) return false;
                else{
                    noOf10++;
                    noOf5--;
                }
            } else {
                if(noOf10 >=1 && noOf5 >=1){
                    noOf10--;
                    noOf5--;
                } else if(noOf5 >= 3){
                    noOf5 -= 3;
                } else return false;
            }
        }

        return true;
    }
}