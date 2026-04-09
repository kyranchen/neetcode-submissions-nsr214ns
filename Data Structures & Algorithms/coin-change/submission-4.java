public class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int dfs(int amount, int[] coins) {
        if (amount == 0) return 0;
        if (memo.containsKey(amount))
            return memo.get(amount);

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int result = dfs(amount - coin, coins);
                if (result != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + result);
                }
            }
        }

        memo.put(amount, res);
        return res;
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        // reverse manually
        for (int i = 0, j = coins.length - 1; i < j; i++, j--) {
            int temp = coins[i];
            coins[i] = coins[j];
            coins[j] = temp;
        }
        int minCoins = dfs(amount, coins);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
}