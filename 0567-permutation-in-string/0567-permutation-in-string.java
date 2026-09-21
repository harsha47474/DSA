class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = s1.length() - 1;

        if(s1.length() > s2.length()){
            return false;
        }
        char[] char1 = s1.toCharArray();
        Arrays.sort(char1);
        s1 = new String(char1);

        StringBuilder sb = new StringBuilder(s2);

        for(; right < s2.length(); right++){
            String original = sb.substring(left, right+1).toString();
            char[] chars = original.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if(sorted.equals(s1)){
                return true;
            }
            left++;
        }

        return false;
    }
}