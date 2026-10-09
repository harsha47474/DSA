class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int score1 = 0;
        int score2 = 0;

        for (int i = 0; i < player1.length; i++) {
            int multiplier1 = 1;
            int multiplier2 = 1;

            if (i >= 1 && player1[i - 1] == 10 ||
                i >= 2 && player1[i - 2] == 10) {
                multiplier1 = 2;
            }

            if (i >= 1 && player2[i - 1] == 10 ||
                i >= 2 && player2[i - 2] == 10) {
                multiplier2 = 2;
            }

            score1 += player1[i] * multiplier1;
            score2 += player2[i] * multiplier2;
        }

        if (score1 > score2) return 1;
        if (score2 > score1) return 2;
        return 0;
    }
}