function finalString(s: string): string {
    let result: string = "";

    for (const c of s) {
        if (c === 'i') {
            result = result.split('').reverse().join('');
        } else {
            result += c;
        }
    }

    return result;
}