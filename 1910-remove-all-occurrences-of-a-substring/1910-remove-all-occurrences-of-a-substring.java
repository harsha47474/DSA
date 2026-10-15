class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length();
        int start = s.indexOf(part);

        while(start != -1){
            s = s.substring(0, start) + s.substring(start + part.length());
            start = s.indexOf(part);
        }

        return s;
    }
}