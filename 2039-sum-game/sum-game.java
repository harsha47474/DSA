class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftQuestionMark = 0;
        int rightQuestionMark = 0;

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            if (ch == '?') {
                if (i < n / 2)
                    leftQuestionMark++;
                else
                    rightQuestionMark++;
            } else {
                if (i < n / 2)
                    leftSum += ch - '0';
                else
                    rightSum += ch - '0';
            }
        }
        int totalQuestionMark = rightQuestionMark + leftQuestionMark;

        if ((totalQuestionMark & 1) == 1)
            return true;
        int left = 2 * leftSum + 9 * leftQuestionMark;
        int right = 2 * rightSum + 9 * rightQuestionMark;

        if (left == right)
            return false;
        return true;
    }
}