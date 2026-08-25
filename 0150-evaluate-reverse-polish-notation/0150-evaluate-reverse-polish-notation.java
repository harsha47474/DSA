class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String str: tokens){
            if(str.equals("*") || str.equals("+") || str.equals("/") || str.equals("-")){
                if(str.equals("*")){
                    int elem1 = st.pop();
                    int elem2 = st.pop();
                    st.push(elem1 * elem2);
                }
                else if(str.equals("/")){
                    int elem1 = st.pop();
                    int elem2 = st.pop();
                    st.push(elem2 / elem1);
                }
                else if(str.equals("+")){
                    int elem1 = st.pop();
                    int elem2 = st.pop();
                    st.push(elem1 + elem2);
                } else {
                    int elem1 = st.pop();
                    int elem2 = st.pop();
                    st.push(elem2 - elem1);
                }
            }else{
                st.push(Integer.parseInt(str));
            }
        }
        return st.peek();
    }
}