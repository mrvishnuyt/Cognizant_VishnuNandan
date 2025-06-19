package forecast;

public class Forecaster {

    // Recursive method
    public static double forecastRecursive(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return forecastRecursive(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    // Optimized using power function (optional)
    public static double forecastOptimized(double currentValue, double growthRate, int years) {
        return currentValue * Math.pow(1 + growthRate, years);
    }

    // Memoization approach (for academic interest)
    public static double forecastMemo(double currentValue, double growthRate, int years, double[] memo) {
        if (years == 0) return currentValue;
        if (memo[years] != 0) return memo[years];
        memo[years] = forecastMemo(currentValue, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }
}
