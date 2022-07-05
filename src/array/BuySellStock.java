package src.array;

public class BuySellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int maxDiff = Integer.MIN_VALUE;
        
        for(int i = 1; i<n; i++){
            maxDiff = Math.max(maxDiff, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        
        return Math.max(0, maxDiff);
    }
}
