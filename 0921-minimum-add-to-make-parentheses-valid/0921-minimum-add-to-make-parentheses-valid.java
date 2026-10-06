class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        
        for(char ch: s.toCharArray()){
            if(st.size() > 0 && (st.peek() == '(' && ch == ')')){
                st.pop();
                continue;
            }
            st.push(ch);
        }
        return st.size();
    }
}