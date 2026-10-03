class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        helper(0, 0, 0, output, res, n);
        return res;

    }

    private void helper(int i, int open_count, int close_count, StringBuilder output, List<String> res, int n) {
        if (i == 2 * n) {
            res.add(output.toString());
            return;
        }

        if (open_count < n) {
            output.append('(');
            helper(i + 1, open_count + 1, close_count, output, res, n);
            output.deleteCharAt(output.length() - 1);
        }

        if (open_count > close_count) {
            output.append(')');
            helper(i + 1, open_count, close_count + 1, output, res, n);
            output.deleteCharAt(output.length() - 1);
        }
    }
}