class Solution {
    public String removeOuterParentheses(String s) {
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<s.length(); i++){
            char ch = s.charAt(i);
            if(count == 0){
                count++;
                continue;
            }
            if(ch == '(') {
                count++;
                sb.append('(');
            }
            if(ch == ')'){
                count--;
                if(count == 0) continue;
                else sb.append(')');
            }
        }
        return sb.toString();
    }
}