class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        StringBuilder curr = new StringBuilder();
        String[] result = new String[]{""};
        solve(curr, result, count, target, 0, false);

        return result[0];
    }

    public boolean solve(StringBuilder curr, String[] result, int[] count, String target, int i, boolean greater) {
        if (i == target.length()) {
            if (greater) {
                result[0] = curr.toString();
                return true;
            }
            return false;
        }

        for(char ch = 'a'; ch<='z'; ch++){
            if(count[ch - 'a'] == 0) continue;

            if(greater == false && ch < target.charAt(i)) continue;

            curr.append(ch);
            count[ch - 'a']--;

            boolean isGreater = greater || ch>target.charAt(i);

            if(solve(curr, result, count, target, i+1, isGreater)) return true;

            curr.deleteCharAt(curr.length() - 1);
            count[ch - 'a']++;
        }

        return false;
    }
}