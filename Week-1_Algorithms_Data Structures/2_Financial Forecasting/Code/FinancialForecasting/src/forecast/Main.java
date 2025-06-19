package forecast;

public class Main {
    public static void main(String[] args) {
        double currentValue = 1000;
        double growthRate = 0.05; // 5% growth
        int years = 10;

        System.out.println("Recursive Forecast: ₹" +
            Forecaster.forecastRecursive(currentValue, growthRate, years));

        System.out.println("Optimized Forecast: ₹" +
            Forecaster.forecastOptimized(currentValue, growthRate, years));

        double[] memo = new double[years + 1];
        System.out.println("Memoized Forecast: ₹" +
            Forecaster.forecastMemo(currentValue, growthRate, years, memo));
    }
}
