class Solution {
    public int calculate(String s) {
        // Deque<Integer> nums = new ArrayDeque<>();
        // Deque<Character> operators = new ArrayDeque<>();

        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     if(ch == ' ') continue;
        //     if (ch == '+' || ch == '-' || ch == '(')
        //         operators.push(ch);
        //     else if (ch == ')'){
        //         while(operators.peek() != ')'){
        //             int n1 = nums.pop();
        //             int n2 = nums.pop();
        //             if(operators.peek() == '+'){
        //                 nums.push(n1 + n2);
        //                 operators.pop();
        //             } else {
        //                 nums.push(n1 - n2);
        //                 operators.pop();
        //             }
        //         }
        //         operators.pop();
        //     }
        //     else {
        //         int n = Character.getNumericValue(ch);
        //         if (operators.isEmpty()) {
        //             nums.push(n);
        //             continue;
        //         }
        //         if (operators.peek() == '(') {
        //             nums.push(n);
        //         } else if (operators.peek() == '+') {
        //             nums.push(n + nums.pop());
        //             operators.pop();
        //         } else {
        //             nums.push(n - nums.pop());
        //             operators.pop();
        //         }
        //     }
        // }

        // while (!operators.isEmpty()) {
        //     System.out.print(nums.peek());
        //     int n = nums.pop();
        //     if (operators.peek() == '+') {
        //         nums.push(n + nums.pop());
        //         operators.pop();
        //     } else {
        //         nums.push(n - nums.pop());
        //         operators.pop();
        //     }
        // }

        // return nums.peek();

        ArrayDeque<Integer> st = new ArrayDeque<>();
        int res=0;
        int sign = 1;
        int num = 0; 
        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '+' || ch == '-') {
                res += num * sign;
                num=0;
                sign = ch=='+' ? 1: -1;
            } else if (ch == '(') {
                st.push(res);
                st.push(sign);
                res = 0; sign = 1;
            } else if (ch == ')') {
                res += num * sign;
                num=0;
                res *= st.pop();
                res += st.pop();
            }
        }

        return res + sign * num;
    }
}