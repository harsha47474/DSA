function isWinner(player1: number[], player2: number[]): number {
    let score1 = 0;
    let score2 = 0;

    for (let i = 0; i < player1.length; i++) {
        let multiplier1 = 1;
        let multiplier2 = 1;

        if (
            (i >= 1 && player1[i - 1] === 10) ||
            (i >= 2 && player1[i - 2] === 10)
        ) {
            multiplier1 = 2;
        }

        if (
            (i >= 1 && player2[i - 1] === 10) ||
            (i >= 2 && player2[i - 2] === 10)
        ) {
            multiplier2 = 2;
        }

        score1 += player1[i] * multiplier1;
        score2 += player2[i] * multiplier2;
    }

    if (score1 > score2) return 1;
    if (score2 > score1) return 2;
    return 0;
}