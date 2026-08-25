class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> st = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && ch == st.peek()[0]){
                st.peek()[1] = st.peek()[1] + 1;
                if(k == st.peek()[1]){
                    st.pop();
                }
            }else {
                st.push(new int[]{ch,1});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            for(int i=0; i<st.peek()[1]; i++){
                sb.insert(0, (char) st.peek()[0]);
            }
            st.pop();
        }
        return sb.toString();
    }
}