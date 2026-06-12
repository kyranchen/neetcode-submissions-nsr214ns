class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int gasSum = 0;
        int costSum = 0;

        for (int i = 0; i < n; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (gasSum < costSum) return -1;

        for (int i = 0; i < n; i++) {
            int startingGas = gas[i] - cost[i];
            if (startingGas < 0) continue;

            int j = (i + 1) % n;
            while (j != i) {
                startingGas += gas[j] - cost[j];
                if (startingGas < 0) break;
                j = (j + 1) % n;
            }

            if (j == i) return i;
        }

        return -1;
    }
}
