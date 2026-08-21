class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] hash = new int[26];
        for(Character ch: sentence.toCharArray()){
            hash[ch-'a']++;
        }
        for(int i=0; i<hash.length; i++){
            if(hash[i] == 0) return false;
        }

        return true;
    }
}