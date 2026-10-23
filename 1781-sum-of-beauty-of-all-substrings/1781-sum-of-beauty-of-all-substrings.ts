function beautySum(s: string): number {
    let totalBeauty = 0;

    for (let i = 0; i < s.length; i++) {
        const freqMap = new Map<string, number>();

        for (let j = i; j < s.length; j++) {
            const char = s[j];
            freqMap.set(char, (freqMap.get(char) || 0) + 1);

            let maxF = 0;
            let minF = Infinity;


            for (const count of freqMap.values()) {
                maxF = Math.max(maxF, count);
                minF = Math.min(minF, count);
            }
            
            totalBeauty += (maxF - minF);
        }
    }

    return totalBeauty;
}
