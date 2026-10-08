function removeOuterParentheses(s: string): string {
    let st: string = "";
    let count: number = 0;
    for (let i: number = 0; i < s.length; i++) {
        if (s[i] == '(') {
            if (count > 0) {
                st += s[i];
            }
            count++;
        } else {
            count--;
            if (count > 0) {
                st += s[i];
            }
        }
    }
    return st;
};